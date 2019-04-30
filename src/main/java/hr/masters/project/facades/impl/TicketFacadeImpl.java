package hr.masters.project.facades.impl;

import hr.masters.project.enums.OutcomeEnum;
import hr.masters.project.facades.TicketFacade;
import hr.masters.project.facades.UserFacade;
import hr.masters.project.forms.NewTicketForm;
import hr.masters.project.model.TicketModel;
import hr.masters.project.model.UserModel;
import hr.masters.project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketFacadeImpl implements TicketFacade
{
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private TicketService ticketService;

    @Override
    public List<TicketModel> retrieveUserTickets()
    {
        final UserModel user = userFacade.retrieveLoggedUser();
        return ticketService.getTicketsByUser(user);
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
        ticketService.createTicket(newTicket);
    }

    @Override
    public TicketModel retrieveTicket(final String ticket)
    {
        return ticketService.getTicketByTickedId(ticket).get();
    }
}
