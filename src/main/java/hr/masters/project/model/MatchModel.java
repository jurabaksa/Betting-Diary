package hr.masters.project.model;

import hr.masters.project.enums.OutcomeEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static hr.masters.project.enums.OutcomeEnum.UPCOMING;

@Entity
@Table(name = "matches", schema = "betting_diary_db")
public class MatchModel
{
    @Id
    @GeneratedValue
    private Long match_id;

    private OutcomeEnum outcome;
    private String prediction;
    private Date time;
    private String homeTeam;
    private String guestTeam;
    private String league;
    private String sport;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Match_Ticket",
            joinColumns = { @JoinColumn(name = "match_id") },
            inverseJoinColumns = { @JoinColumn(name = "ticket_id") }
    )
    final Set<TicketModel> tickets = new HashSet<>();

    public MatchModel()
    {
        outcome = UPCOMING;
    }

    public Long getId()
    {
        return match_id;
    }

    public void setId(final Long match_id)
    {
        this.match_id = match_id;
    }

    public OutcomeEnum getOutcome()
    {
        return outcome;
    }

    public void setOutcome(final OutcomeEnum outcome)
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

    public Set<TicketModel> getTickets()
    {
        return tickets;
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
}
