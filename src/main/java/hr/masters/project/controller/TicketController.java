package hr.masters.project.controller;

import hr.masters.project.facades.TicketFacade;
import hr.masters.project.facades.UserFacade;
import hr.masters.project.forms.NewTicketForm;
import hr.masters.project.util.Constants;
import hr.masters.project.validators.TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketController
{
    private static final String TICKETS_ATTRIBUTE = "tickets";
    private static final String NEW_TICKET_ATTRIBUTE = "ticket";
    private static final String USER_ATTRIBUTE = "user";

    @Autowired
    private TicketValidator ticketValidator;

    @Autowired
    private TicketFacade ticketFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = Constants.Paths.MY_TICKETS, method = RequestMethod.GET)
    public ModelAndView showMyTickets()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute(TICKETS_ATTRIBUTE, ticketFacade.retrieveUserTickets());
        modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.getLoggedUser().getUsername());
        modelAndView.setViewName(Constants.Pages.MY_TICKETS);
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.ADD_TICKET, method = RequestMethod.GET)
    public ModelAndView showAddTicketForm()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.ADD_TICKET);
        modelAndView.getModelMap().addAttribute(NEW_TICKET_ATTRIBUTE, new NewTicketForm());
        modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.getLoggedUser().getUsername());
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.ADD_TICKET, method = RequestMethod.POST)
    public ModelAndView addTicket(
            @ModelAttribute(NEW_TICKET_ATTRIBUTE)
            final NewTicketForm newTicketForm,
            final BindingResult bindingResult)
    {
        final ModelAndView modelAndView = new ModelAndView();
        ValidationUtils.invokeValidator(ticketValidator, newTicketForm, bindingResult);

        if (bindingResult.hasErrors())
        {
            modelAndView.getModelMap().addAttribute(NEW_TICKET_ATTRIBUTE, newTicketForm);
            modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.getLoggedUser().getUsername());
            modelAndView.setViewName(Constants.Pages.ADD_TICKET);

        }
        else
        {
            ticketFacade.createNewTicket(newTicketForm);
            modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.getLoggedUser().getUsername());
            modelAndView.setViewName(Constants.Pages.HOME);
        }
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.TICKET_DETAILS, method = RequestMethod.GET)
    public ModelAndView getTicketDetailsRedirect()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.getLoggedUser().getUsername());
        modelAndView.setViewName(Constants.Pages.HOME);
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.TICKET_DETAILS, method = RequestMethod.POST)
    public ModelAndView getTicketDetails(
            @RequestParam
            final String ticket)
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.getLoggedUser().getUsername());
        modelAndView.setViewName(Constants.Pages.TICKET_DETAILS);
        return modelAndView;
    }

}
