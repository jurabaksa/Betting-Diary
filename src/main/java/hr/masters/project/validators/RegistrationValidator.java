package hr.masters.project.validators;

import hr.masters.project.forms.NewUserForm;
import hr.masters.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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

        final String newUserUsername = newUserForm.getUsername();
        if (this.userService.findByUsername(newUserUsername).isPresent())
        {
            errors.rejectValue("username", "error.username.exists");
        }

        final String newUserMail = newUserForm.getEmail();
        if (this.userService.findByEmail(newUserMail).isPresent())
        {
            errors.rejectValue("email", "error.email.exists");
        }

        final String newUserPassword = newUserForm.getPassword();

        if (newUserPassword.length() < 6)
        {
            errors.rejectValue("password", "error.password.length)");
        }
    }
}
