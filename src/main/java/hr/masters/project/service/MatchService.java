package hr.masters.project.service;

import hr.masters.project.model.MatchModel;

import java.util.List;

public interface MatchService
{
    List<MatchModel> getMatchesByTicket(String ticket);
}
