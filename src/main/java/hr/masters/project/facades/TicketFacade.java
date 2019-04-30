package hr.masters.project.facades;

import hr.masters.project.forms.NewTicketForm;
import hr.masters.project.model.TicketModel;

import java.util.List;

public interface TicketFacade
{
    List<TicketModel> retrieveUserTickets();

    List<TicketModel> retrieveWinningTickets();

    void createNewTicket(final NewTicketForm newTicket);

    TicketModel retrieveTicket(String ticket);
}
