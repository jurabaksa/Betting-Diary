package hr.masters.project.facades.impl;

import hr.masters.project.enums.OutcomeEnum;
import hr.masters.project.facades.TicketFacade;
import hr.masters.project.facades.UserFacade;
import hr.masters.project.forms.NewTicketForm;
import hr.masters.project.model.ChartValuesModel;
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
    private UserService userService;

    @Autowired
    private TicketService ticketService;

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
        return allTickets.stream().filter(ticket -> OutcomeEnum.POSITIVE.name().equals(ticket.getOutcome()))
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

    @Override
    public ChartValuesModel retrieveWinningTicketsByStake()
    {
        final List<TicketModel> allTickets = ticketService.getTicketsByUser(userFacade.retrieveLoggedUser());
        final ChartValuesModel chartValuesModel = new ChartValuesModel();
        chartValuesModel.setFirstLabel(allTickets
                .stream()
                .filter(line -> line.getStake() <= 10)
                .filter(line -> line.getOutcome().equals("POSITIVE"))
                .count());
        chartValuesModel.setSecondLabel(allTickets
                .stream()
                .filter(line -> line.getStake() > 10)
                .filter(line -> line.getStake() <= 30)
                .filter(line -> line.getOutcome().equals("POSITIVE"))
                .count());
        chartValuesModel.setThirdLabel(allTickets
                .stream()
                .filter(line -> line.getStake() > 30)
                .filter(line -> line.getStake() <= 100)
                .filter(line -> line.getOutcome().equals("POSITIVE"))
                .count());
        chartValuesModel.setFourthLabel(allTickets
                .stream()
                .filter(line -> line.getStake() > 100)
                .filter(line -> line.getOutcome().equals("POSITIVE"))
                .count());

        return chartValuesModel;

    }

    @Override
    public ChartValuesModel retrieveWinningTicketsByWinning()
    {
        final List<TicketModel> allTickets = ticketService.getTicketsByUser(userFacade.retrieveLoggedUser());
        final ChartValuesModel chartValuesModel = new ChartValuesModel();
        chartValuesModel.setFirstLabel(allTickets
                .stream()
                .filter(line -> line.getWinning() <= 50)
                .filter(line -> line.getOutcome().equals("POSITIVE"))
                .count());
        chartValuesModel.setSecondLabel(allTickets
                .stream()
                .filter(line -> line.getWinning() > 50)
                .filter(line -> line.getWinning() <= 200)
                .filter(line -> line.getOutcome().equals("POSITIVE"))
                .count());
        chartValuesModel.setThirdLabel(allTickets
                .stream()
                .filter(line -> line.getWinning() > 200)
                .filter(line -> line.getWinning() <= 1000)
                .filter(line -> line.getOutcome().equals("POSITIVE"))
                .count());
        chartValuesModel.setFourthLabel(allTickets
                .stream()
                .filter(line -> line.getWinning() > 1000)
                .filter(line -> line.getOutcome().equals("POSITIVE"))
                .count());
        return chartValuesModel;
    }

    @Override
    public ChartValuesModel retrieveLosingTicketsByStake()
    {
        final List<TicketModel> allTickets = ticketService.getTicketsByUser(userFacade.retrieveLoggedUser());
        final ChartValuesModel chartValuesModel = new ChartValuesModel();
        chartValuesModel.setFirstLabel(allTickets
                .stream()
                .filter(line -> line.getStake() <= 10)
                .filter(line -> line.getOutcome().equals("NEGATIVE"))
                .count());
        chartValuesModel.setSecondLabel(allTickets
                .stream()
                .filter(line -> line.getStake() > 10)
                .filter(line -> line.getStake() <= 30)
                .filter(line -> line.getOutcome().equals("NEGATIVE"))
                .count());
        chartValuesModel.setThirdLabel(allTickets
                .stream()
                .filter(line -> line.getStake() > 30)
                .filter(line -> line.getStake() <= 100)
                .filter(line -> line.getOutcome().equals("NEGATIVE"))
                .count());
        chartValuesModel.setFourthLabel(allTickets
                .stream()
                .filter(line -> line.getStake() > 100)
                .filter(line -> line.getOutcome().equals("NEGATIVE"))
                .count());
        return chartValuesModel;
    }

    @Override
    public ChartValuesModel retrieveLosingTicketsByWinning()
    {
        final List<TicketModel> allTickets = ticketService.getTicketsByUser(userFacade.retrieveLoggedUser());
        final ChartValuesModel chartValuesModel = new ChartValuesModel();
        chartValuesModel.setFirstLabel(allTickets
                .stream()
                .filter(line -> line.getWinning() <= 50)
                .filter(line -> line.getOutcome().equals("NEGATIVE"))
                .count());
        chartValuesModel.setSecondLabel(allTickets
                .stream()
                .filter(line -> line.getWinning() > 50)
                .filter(line -> line.getWinning() <= 200)
                .filter(line -> line.getOutcome().equals("NEGATIVE"))
                .count());
        chartValuesModel.setThirdLabel(allTickets
                .stream()
                .filter(line -> line.getWinning() > 200)
                .filter(line -> line.getWinning() <= 1000)
                .filter(line -> line.getOutcome().equals("NEGATIVE"))
                .count());
        chartValuesModel.setFourthLabel(allTickets
                .stream()
                .filter(line -> line.getWinning() > 1000)
                .filter(line -> line.getOutcome().equals("NEGATIVE"))
                .count());
        return chartValuesModel;
    }

    @Override
    public List<TicketModel> retrieveTicketsFromTo(final double winningStart, final double winningEnd)
    {
        final List<TicketModel> allTickets = ticketService.getTicketsByUser(userFacade.retrieveLoggedUser());
        return allTickets
                .stream()
                .filter(ticket -> ticket.getWinning() > winningStart)
                .filter(ticket -> ticket.getWinning() < winningEnd)
                .collect(
                        Collectors.toList());
    }
}
