package hr.masters.project.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tickets", schema = "betting_diary_db")
public class TicketModel
{
    @Id
    private String ticket;
    private double stake;
    private double winning;
    private String outcome;
    private double coefficient;
    private Date time;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "username")
    private UserModel user;

    public TicketModel()
    {
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

    public String getOutcome()
    {
        return outcome;
    }

    public void setOutcome(final String outcome)
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

    public String getTicket()
    {
        return ticket;
    }

    public void setTicket(final String ticket)
    {
        this.ticket = ticket;
    }

    public double getCoefficient()
    {
        return coefficient;
    }

    public void setCoefficient(final double coefficient)
    {
        this.coefficient = coefficient;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(final Date time)
    {
        this.time = time;
    }
}
