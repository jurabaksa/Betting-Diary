package hr.masters.project.facades.impl;

import hr.masters.project.facades.TicketFacade;
import hr.masters.project.facades.UserFacade;
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
        final UserModel user = userFacade.getLoggedUser();
        return ticketService.getTicketsByUser(user);
    }
}
