package hr.masters.project.controller;

import hr.masters.project.facades.TicketFacade;
import hr.masters.project.facades.UserFacade;
import hr.masters.project.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WinningsStatsController
{
    private static final String USER_ATTRIBUTE = "user";
    private static final String WINNING_TICKETS_ATTRIBUTE = "tickets";

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private TicketFacade ticketFacade;

    @RequestMapping(value = Constants.Paths.WINNINGS_HISTORY, method = RequestMethod.GET)
    public ModelAndView displayMyWinningTickets()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.retrieveLoggedUser());
        modelAndView.getModelMap().addAttribute(WINNING_TICKETS_ATTRIBUTE, ticketFacade.retrieveWinningTickets());
        modelAndView.setViewName(Constants.Pages.WINNINGS_HISTORY);
        return modelAndView;
    }
}
