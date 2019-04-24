package hr.masters.project.forms;

import java.sql.Date;

public class NewTicketForm
{
    String ticket_id;
    Date time;
    double stake;

    public String getTicket_id()
    {
        return ticket_id;
    }

    public void setTicket_id(final String ticket_id)
    {
        this.ticket_id = ticket_id;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(final Date time)
    {
        this.time = time;
    }

    public double getStake()
    {
        return stake;
    }

    public void setStake(final double stake)
    {
        this.stake = stake;
    }
}
