package hr.masters.project.controller;

import hr.masters.project.facades.UserFacade;
import hr.masters.project.forms.NewUserForm;
import hr.masters.project.util.Constants;
import hr.masters.project.validators.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController
{
    private static final String USER_FORM_ATTRIBUTE = "NewUserForm";

    @Autowired
    private RegistrationValidator registrationValidator;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = Constants.Paths.REGISTER, method = RequestMethod.GET)
    public ModelAndView showRegistrationForm()
    {
        final ModelAndView modelAndView = new ModelAndView();
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
        {
            modelAndView.setViewName(Constants.Pages.HOME_USER);
            return modelAndView;
        }
        modelAndView.setViewName(Constants.Pages.REGISTRATION);
        modelAndView.getModelMap().addAttribute(USER_FORM_ATTRIBUTE, new NewUserForm());
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.REGISTER, method = RequestMethod.POST)
    public ModelAndView registerUser(
            @ModelAttribute(USER_FORM_ATTRIBUTE)
            final NewUserForm newUserForm,
            final BindingResult bindingResult)
    {
        final ModelAndView modelAndView = new ModelAndView();
        ValidationUtils.invokeValidator(registrationValidator, newUserForm, bindingResult);

        if (bindingResult.hasErrors())
        {
            modelAndView.getModelMap().addAttribute(USER_FORM_ATTRIBUTE, newUserForm);
            modelAndView.setViewName(Constants.Pages.REGISTRATION);
        }
        else
        {
            userFacade.createUser(newUserForm);
            modelAndView.setViewName(Constants.Pages.REGISTRATION_SUCCESS);
        }

        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.REGISTRATION_SUCCESS, method = RequestMethod.GET)
    public ModelAndView showSuccessfulRegistration()
    {
        final ModelAndView modelAndView = new ModelAndView();
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
        {
            modelAndView.setViewName(Constants.Pages.HOME_USER);
            return modelAndView;
        }
        modelAndView.setViewName(Constants.Pages.REGISTRATION_SUCCESS);
        return modelAndView;
    }
}
