package hr.masters.project.service;

import hr.masters.project.model.MatchModel;
import hr.masters.project.model.TicketModel;
import hr.masters.project.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface TicketService
{
    List<TicketModel> getTicketsByUser(final UserModel userModel);

    void createTicket(final TicketModel newTicket);

    Optional<TicketModel> getTicketByTickedId(final String tickedId);

    TicketModel updateTicket(final TicketModel ticket, final MatchModel match);
}
