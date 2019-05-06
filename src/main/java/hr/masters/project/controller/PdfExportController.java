package hr.masters.project.controller;

import hr.masters.project.facades.TicketFacade;
import hr.masters.project.facades.UserFacade;
import hr.masters.project.util.Constants;
import hr.masters.project.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;

@Controller
public class PdfExportController
{
    private static final String USER_ATTRIBUTE = "user";

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private TicketFacade ticketFacade;

    @RequestMapping(value = Constants.Paths.PDF_EXPORT, method = RequestMethod.GET)
    public ModelAndView displayVisualStats()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.retrieveLoggedUser());
        modelAndView.setViewName(Constants.Pages.PDF_EXPORT);
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.PDF_EXPORT, method = RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> generatePdfReport(final Double winningStart, final Double winningEnd)
    {
        double start = 0;
        double end = 100000000;

        if (winningStart != null)
        {
            start = winningStart.doubleValue();
        }
        if (winningEnd != null)
        {
            end = winningEnd.doubleValue();
        }
        final ByteArrayInputStream byteArrayInputStreamPdf = PdfGenerator.makePdfReport(ticketFacade.retrieveTicketsFromTo(
                start,
                end
        ));

        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=custom-pdf-report.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(
                byteArrayInputStreamPdf));
    }
}
