package hr.masters.project.forms;

public class NewTicketForm
{
    String outcome;
    String stake;
    String winning;
    String user;

    public String getOutcome()
    {
        return outcome;
    }

    public void setOutcome(final String outcome)
    {
        this.outcome = outcome;
    }

    public String getStake()
    {
        return stake;
    }

    public void setStake(final String stake)
    {
        this.stake = stake;
    }

    public String getWinning()
    {
        return winning;
    }

    public void setWinning(final String winning)
    {
        this.winning = winning;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(final String user)
    {
        this.user = user;
    }
}
