package hr.masters.project.forms;

import hr.masters.project.model.TicketModel;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class NewMatchForm
{
    double coefficient;
    String guestTeam;
    String homeTeam;
    String league;
    String outcome;
    String prediction;
    String sport;
    Date time;
    Set<TicketModel> tickets = new HashSet<>();

    public double getCoefficient()
    {
        return coefficient;
    }

    public void setCoefficient(final double coefficient)
    {
        this.coefficient = coefficient;
    }

    public String getGuestTeam()
    {
        return guestTeam;
    }

    public void setGuestTeam(final String guestTeam)
    {
        this.guestTeam = guestTeam;
    }

    public String getHomeTeam()
    {
        return homeTeam;
    }

    public void setHomeTeam(final String homeTeam)
    {
        this.homeTeam = homeTeam;
    }

    public String getLeague()
    {
        return league;
    }

    public void setLeague(final String league)
    {
        this.league = league;
    }

    public String getOutcome()
    {
        return outcome;
    }

    public void setOutcome(final String outcome)
    {
        this.outcome = outcome;
    }

    public String getPrediction()
    {
        return prediction;
    }

    public void setPrediction(final String prediction)
    {
        this.prediction = prediction;
    }

    public String getSport()
    {
        return sport;
    }

    public void setSport(final String sport)
    {
        this.sport = sport;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(final Date time)
    {
        this.time = time;
    }

    public Set<TicketModel> getTickets()
    {
        return tickets;
    }

    public void setTickets(final Set<TicketModel> tickets)
    {
        this.tickets = tickets;
    }
}
