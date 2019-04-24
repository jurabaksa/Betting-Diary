package hr.masters.project.facades;

import hr.masters.project.model.TicketModel;

import java.util.List;

public interface TicketFacade
{
    List<TicketModel> retrieveUserTickets();
}
