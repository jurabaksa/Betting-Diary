package hr.masters.project.forms;

public class NewTicketForm
{
    String ticket_id;
    double stake;

    public String getTicket_id()
    {
        return ticket_id;
    }

    public void setTicket_id(final String ticket_id)
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
}
