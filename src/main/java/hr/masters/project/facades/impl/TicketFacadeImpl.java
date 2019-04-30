package hr.masters.project.facades.impl;

import hr.masters.project.enums.OutcomeEnum;
import hr.masters.project.facades.TicketFacade;
import hr.masters.project.facades.UserFacade;
import hr.masters.project.forms.NewTicketForm;
import hr.masters.project.model.TicketModel;
import hr.masters.project.model.UserModel;
import hr.masters.project.service.TicketService;
import hr.masters.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketFacadeImpl implements TicketFacade
{
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Override
    public List<TicketModel> retrieveUserTickets()
    {
        final UserModel user = userFacade.retrieveLoggedUser();
        return ticketService.getTicketsByUser(user);
    }

    @Override
    public List<TicketModel> retrieveWinningTickets()
    {
        final UserModel user = userFacade.retrieveLoggedUser();
        final List<TicketModel> allTickets = ticketService.getTicketsByUser(user);
        return allTickets.stream().filter(ticket -> "POSITIVE".equals(ticket.getOutcome()))
                         .collect(Collectors.toList());
    }

    @Override
    public void createNewTicket(final NewTicketForm newTicketForm)
    {
        final TicketModel newTicket = new TicketModel();
        newTicket.setTicket(newTicketForm.getTicket_id());
        newTicket.setStake(newTicketForm.getStake());
        newTicket.setUser(userFacade.retrieveLoggedUser());
        newTicket.setOutcome(OutcomeEnum.POSITIVE.name());
        newTicket.setCoefficient(1d);
        newTicket.setWinning(newTicket.getCoefficient() * newTicket.getStake() * 0.9);
        final UserModel user = userFacade.retrieveLoggedUser();
        user.setBalance(user.getBalance() - newTicket.getStake() + newTicket.getWinning());
        userService.saveUser(user);
        ticketService.createTicket(newTicket);
    }

    @Override
    public TicketModel retrieveTicket(final String ticket)
    {
        return ticketService.getTicketByTickedId(ticket).get();
    }
}
