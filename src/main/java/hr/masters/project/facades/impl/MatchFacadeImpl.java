package hr.masters.project.facades.impl;

import hr.masters.project.enums.OutcomeEnum;
import hr.masters.project.facades.MatchFacade;
import hr.masters.project.forms.NewMatchForm;
import hr.masters.project.model.MatchModel;
import hr.masters.project.service.MatchService;
import hr.masters.project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchFacadeImpl implements MatchFacade
{
    @Autowired
    private MatchService matchService;

    @Autowired
    private TicketService ticketService;

    @Override
    public List<MatchModel> retrieveTicketMatches(final String ticket)
    {
        return matchService.getMatchesByTicket(ticket);
    }

    @Override
    public void addMatchToTicket(final NewMatchForm newMatchForm)
    {
        final MatchModel newMatch = new MatchModel();
        newMatch.setHomeTeam(newMatchForm.getHomeTeam());
        newMatch.setGuestTeam(newMatchForm.getGuestTeam());
        newMatch.setPrediction(newMatchForm.getPrediction());
        newMatch.setOutcome(OutcomeEnum.IN_PROGRESS);
        newMatch.setCoefficient(newMatchForm.getCoefficient());
        newMatch.setSport(newMatchForm.getSport());
        newMatch.setLeague(newMatchForm.getLeague());
        newMatch.setTime(newMatchForm.getTime());
        newMatch.setTicket(newMatchForm.getTicket());
        ticketService.updateTicket(newMatchForm.getTicket(), newMatch);
        matchService.saveMatch(newMatch);
    }
}
