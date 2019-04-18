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
public class AccountController
{
    private static final String USER_FORM_ATTRIBUTE = "NewUserForm";

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private RegistrationValidator registrationValidator;

    //LOGIN GET
    @RequestMapping(value = { Constants.Paths.LOGIN, Constants.Paths.INDEX, Constants.Paths.EMPTY })
    public ModelAndView authenticateUser()
    {
        final ModelAndView modelAndView = new ModelAndView();
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
        {
            modelAndView.setViewName(Constants.Pages.HOME_USER);
            return modelAndView;
        }
        modelAndView.setViewName(Constants.Pages.LOGIN);
        return modelAndView;
    }

    //REGISTRATION GET
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

    //REGISTRATION POST
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

    //SUCCESSFUL REGISTRATION GET
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

    //FORGOT PASSWORD GET
    @RequestMapping(value = Constants.Paths.FORGOT, method = RequestMethod.GET)
    public ModelAndView showForgotPasswordForm()
    {
        final ModelAndView modelAndView = new ModelAndView();
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
        {
            modelAndView.setViewName(Constants.Pages.HOME_USER);
            return modelAndView;
        }
        modelAndView.setViewName(Constants.Pages.FORGOT_PASSWORD);
        return modelAndView;
    }

    //FORGOT PASSWORD POST
    @RequestMapping(value = Constants.Paths.FORGOT, method = RequestMethod.POST)
    public ModelAndView generateNewPassword()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.LOGIN);
        return modelAndView;
    }

    @RequestMapping(Constants.Paths.LOGOUT)
    public ModelAndView logoutUser()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.LOGIN);
        return modelAndView;
    }

}