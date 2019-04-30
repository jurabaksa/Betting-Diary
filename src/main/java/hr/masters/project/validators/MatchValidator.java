package hr.masters.project.validators;

import hr.masters.project.forms.NewMatchForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MatchValidator implements Validator
{
    @Override
    public boolean supports(final Class<?> aClass)
    {
        return NewMatchForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors)
    {
        final NewMatchForm newMatchForm = (NewMatchForm) o;

        if (newMatchForm.getHomeTeam().isEmpty())
        {
            errors.rejectValue("homeTeam", "error.match.empty");
        }

        if (newMatchForm.getGuestTeam().isEmpty())
        {
            errors.rejectValue("guestTeam", "error.match.empty");
        }

        if (newMatchForm.getPrediction().isEmpty())
        {
            errors.rejectValue("prediction", "error.match.empty");
        }

        if (newMatchForm.getCoefficient() < 1)
        {
            errors.rejectValue("coefficient", "error.coefficient.faulty");
        }

        if (newMatchForm.getSport().isEmpty())
        {
            errors.rejectValue("sport", "error.match.empty");
        }

        if (newMatchForm.getLeague().isEmpty())
        {
            errors.rejectValue("league", "error.match.empty");
        }

        if (newMatchForm.getTime() == null)
        {
            errors.rejectValue("time", "error.match.empty");
        }
    }
}
