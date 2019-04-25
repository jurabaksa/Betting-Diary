package hr.masters.project.service.impl;

import hr.masters.project.model.MatchModel;
import hr.masters.project.repository.MatchRepository;
import hr.masters.project.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService
{
    @Autowired
    private MatchRepository matchRepository;

    @Override
    public List<MatchModel> getMatchesByTicket(final String ticket)
    {
        return matchRepository.findByTicket_Ticket(ticket);
    }
}
