package hr.masters.project.model;

import hr.masters.project.enums.OutcomeEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tickets", schema = "betting_diary_db")
public class TicketModel
{
    @Id
    @GeneratedValue
    private Long ticket_id;

    private double stake;
    private double winning;
    private OutcomeEnum outcome;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "username")
    private UserModel user;

    @ManyToMany(mappedBy = "tickets")
    private final Set<MatchModel> matches = new HashSet<>();

    public TicketModel()
    {
    }

    public Long getId()
    {
        return ticket_id;
    }

    public void setId(final Long ticket_id)
    {
        this.ticket_id = ticket_id;
    }

    public double getStake()
    {
        return stake;
    }

    public void setStake(final double stake)
    {
        this.stake = stake;
    }

    public double getWinning()
    {
        return winning;
    }

    public void setWinning(final double winning)
    {
        this.winning = winning;
    }

    public OutcomeEnum getOutcome()
    {
        return outcome;
    }

    public void setOutcome(final OutcomeEnum outcome)
    {
        this.outcome = outcome;
    }

    public UserModel getUser()
    {
        return user;
    }

    public void setUser(final UserModel user)
    {
        this.user = user;
    }

    public Set<MatchModel> getMatches()
    {
        return matches;
    }
}
