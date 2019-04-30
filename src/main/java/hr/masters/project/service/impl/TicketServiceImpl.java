package hr.masters.project.service.impl;

import hr.masters.project.enums.OutcomeEnum;
import hr.masters.project.facades.UserFacade;
import hr.masters.project.model.MatchModel;
import hr.masters.project.model.TicketModel;
import hr.masters.project.model.UserModel;
import hr.masters.project.repository.TicketRepository;
import hr.masters.project.service.TicketService;
import hr.masters.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService
{
    @Autowired
    private UserFacade userFacade;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<TicketModel> getTicketsByUser(final UserModel user)
    {
        return ticketRepository.findByUser(user);
    }

    @Override
    public void createTicket(final TicketModel newTicket)
    {
        ticketRepository.save(newTicket);
    }

    @Override
    public Optional<TicketModel> getTicketByTickedId(final String tickedId)
    {
        return ticketRepository.findByTicket(tickedId);
    }

    @Override
    public TicketModel updateTicket(final TicketModel ticket, final MatchModel match)
    {
        final double oldWinning = ticket.getWinning();
        ticket.setCoefficient(ticket.getCoefficient() * match.getCoefficient());
        ticket.setWinning(ticket.getWinning() * match.getCoefficient());
        final UserModel user = userFacade.retrieveLoggedUser();

        if (isTicketFailed(match.getOutcome()) && ticket.getOutcome().equals(OutcomeEnum.POSITIVE.name()))
        {
            ticket.setOutcome(OutcomeEnum.NEGATIVE.name());
            user.setBalance(user.getBalance() - oldWinning);

        }
        if (!(ticket.getOutcome().equals(OutcomeEnum.NEGATIVE.name())))
        {
            user.setBalance(user.getBalance() - oldWinning + ticket.getWinning());
        }
        userService.updateUser(user);
        ticketRepository.save(ticket);
        return ticket;
    }

    private boolean isTicketFailed(final String outcome)
    {
        if (outcome.equals(OutcomeEnum.NEGATIVE.name()))
        {
            return true;
        }

        return false;
    }
}
