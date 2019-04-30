package hr.masters.project.forms;

public class NewTicketForm
{
    String ticket_id;
    Double coefficient;
    Double winning;
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

    public Double getCoefficient()
    {
        return coefficient;
    }

    public void setCoefficient(final Double coefficient)
    {
        this.coefficient = coefficient;
    }

    public Double getWinning()
    {
        return winning;
    }

    public void setWinning(final Double winning)
    {
        this.winning = winning;
    }
}
