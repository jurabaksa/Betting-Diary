package hr.masters.project.validators;

import hr.masters.project.forms.NewUserForm;
import hr.masters.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegistrationValidator implements Validator
{
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(final Class<?> aClass)
    {
        return NewUserForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors)
    {
        final NewUserForm newUserForm = (NewUserForm) o;

        if (this.userService.findByUsername(newUserForm.getUsername()).isPresent())
        {
            errors.rejectValue("username", "error.username.exists");
        }

        if (newUserForm.getUsername().length() < 5)
        {
            errors.rejectValue("username", "error.username.length");
        }

        if (this.userService.findByEmail(newUserForm.getEmail()).isPresent())
        {
            errors.rejectValue("email", "error.email.exists");
        }

        final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
                "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE
        );
        final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(newUserForm.getEmail());
        if (!matcher.find())
        {
            errors.rejectValue("email", "error.email.message");
        }

        if (newUserForm.getPassword().length() < 6)
        {
            errors.rejectValue("password", "error.password.length");
        }
    }
}
