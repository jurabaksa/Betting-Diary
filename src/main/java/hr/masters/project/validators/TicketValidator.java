package hr.masters.project.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TicketValidator implements Validator
{
    @Override
    public boolean supports(final Class<?> aClass)
    {
        return false;
    }

    @Override
    public void validate(final Object o, final Errors errors)
    {

    }
}
