package hr.masters.project.validators;

import hr.masters.project.forms.NewTicketForm;
import hr.masters.project.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TicketValidator implements Validator
{
    @Autowired
    private TicketService ticketService;

    @Override
    public boolean supports(final Class<?> aClass)
    {
        return NewTicketForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors)
    {
        final NewTicketForm newTicketForm = (NewTicketForm) o;

        if (this.ticketService.getTicketByTickedId(newTicketForm.getTicket_id()).isPresent())
        {
            errors.rejectValue("ticket_id", "error.ticket.exists");
        }

        if (newTicketForm.getTicket_id().length() < 1)
        {
            errors.rejectValue("ticket_id", "error.ticket.empty");
        }

        if (newTicketForm.getStake() < 0)
        {
            errors.rejectValue("stake", "error.stake.faulty");
        }
    }
}
