package hr.masters.project.validators;

import hr.masters.project.facades.UserFacade;
import hr.masters.project.forms.ProfileSettingsForm;
import hr.masters.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ProfileSettingsValidator implements Validator
{
    @Autowired
    private UserService userService;

    @Autowired
    private UserFacade userFacade;

    @Override
    public boolean supports(final Class<?> aClass)
    {
        return ProfileSettingsForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors)
    {
        final ProfileSettingsForm profileSettingsForm = (ProfileSettingsForm) o;

        if (!profileSettingsForm.getEmail().equals(userFacade.retrieveLoggedUser().getEmail()) && this.userService
                .getByEmail(profileSettingsForm.getEmail())
                .isPresent())
        {
            errors.rejectValue("email", "error.email.exists");
        }

        final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
                "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE
        );
        final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(profileSettingsForm.getEmail());
        if (!matcher.find())
        {
            errors.rejectValue("email", "error.email.message");
        }

        if (profileSettingsForm.getPassword().length() > 0 && profileSettingsForm.getPassword().length() < 6)
        {
            errors.rejectValue("password", "error.password.length");
        }
    }
}
