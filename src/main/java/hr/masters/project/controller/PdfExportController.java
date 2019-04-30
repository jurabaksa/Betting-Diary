package hr.masters.project.controller;

import hr.masters.project.facades.UserFacade;
import hr.masters.project.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PdfExportController
{
    private static final String USER_ATTRIBUTE = "user";

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = Constants.Paths.PDF_EXPORT, method = RequestMethod.GET)
    public ModelAndView displayVisualStats()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.retrieveLoggedUser());
        modelAndView.setViewName(Constants.Pages.PDF_EXPORT);
        return modelAndView;
    }
}
