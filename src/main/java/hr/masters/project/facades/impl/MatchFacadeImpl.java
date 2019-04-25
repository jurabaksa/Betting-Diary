package hr.masters.project.facades.impl;

import hr.masters.project.facades.MatchFacade;
import hr.masters.project.model.MatchModel;
import hr.masters.project.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchFacadeImpl implements MatchFacade
{
    @Autowired
    private MatchService matchService;

    @Override
    public List<MatchModel> retrieveTicketMatches(final String ticket)
    {
        return matchService.getMatchesByTicket(ticket);
    }
}
