package hr.masters.project.facades;

import hr.masters.project.forms.NewMatchForm;
import hr.masters.project.model.MatchModel;

import java.util.List;

public interface MatchFacade
{
    List<MatchModel> retrieveTicketMatches(String ticket);

    void addMatchToTicket(NewMatchForm newMatchForm);
}
