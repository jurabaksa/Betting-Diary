package hr.masters.project.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "matches", schema = "nova")
public class MatchModel
{
    @Id
    @GeneratedValue
    private Long match_id;
    private String outcome;
    private String prediction;
    private double coefficient;
    private Date time;
    private String homeTeam;
    private String guestTeam;
    private String league;
    private String sport;

    @ManyToOne
    @JoinColumn(name = "ticket", referencedColumnName = "ticket")
    private TicketModel ticket;

    public MatchModel()
    {
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

    public Date getTime()
    {
        return time;
    }

    public void setTime(final Date time)
    {
        this.time = time;
    }

    public String getHomeTeam()
    {
        return homeTeam;
    }

    public void setHomeTeam(final String homeTeam)
    {
        this.homeTeam = homeTeam;
    }

    public String getGuestTeam()
    {
        return guestTeam;
    }

    public void setGuestTeam(final String guestTeam)
    {
        this.guestTeam = guestTeam;
    }

    public String getLeague()
    {
        return league;
    }

    public void setLeague(final String league)
    {
        this.league = league;
    }

    public String getSport()
    {
        return sport;
    }

    public void setSport(final String sport)
    {
        this.sport = sport;
    }

    public Long getMatch_id()
    {
        return match_id;
    }

    public void setMatch_id(final Long match_id)
    {
        this.match_id = match_id;
    }

    public double getCoefficient()
    {
        return coefficient;
    }

    public void setCoefficient(final double coefficient)
    {
        this.coefficient = coefficient;
    }

    public TicketModel getTicket()
    {
        return ticket;
    }

    public void setTicket(final TicketModel ticket)
    {
        this.ticket = ticket;
    }
}
