package hr.masters.project.service.impl;

import hr.masters.project.model.TicketModel;
import hr.masters.project.model.UserModel;
import hr.masters.project.repository.TicketRepository;
import hr.masters.project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService
{
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<TicketModel> getTicketsByUser(final UserModel user)
    {
        return ticketRepository.findByUser(user);
    }
}
