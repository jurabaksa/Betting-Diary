package hr.masters.project.controller;

import hr.masters.project.facades.UserFacade;
import hr.masters.project.forms.NewUserForm;
import hr.masters.project.util.Constants;
import hr.masters.project.validators.ForgotPasswordValidator;
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
public class ForgotPasswordController
{
    private static final String EMAIL_ATTRIBUTE = "EmailForm";

    @Autowired
    private ForgotPasswordValidator forgotPasswordValidator;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = Constants.Paths.FORGOT_PASSWORD, method = RequestMethod.GET)
    public ModelAndView displayForgotPasswordForm()
    {
        final ModelAndView modelAndView = new ModelAndView();

        if (checkIfAuthenticated(modelAndView))
        {
            return modelAndView;
        }

        modelAndView.setViewName(Constants.Pages.FORGOT_PASSWORD);
        modelAndView.getModelMap().addAttribute(EMAIL_ATTRIBUTE, new NewUserForm());
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.FORGOT_PASSWORD, method = RequestMethod.POST)
    public ModelAndView getNewPassword(
            @ModelAttribute(EMAIL_ATTRIBUTE)
            final NewUserForm emailForm,
            final BindingResult bindingResult)
    {
        final ModelAndView modelAndView = new ModelAndView();
        ValidationUtils.invokeValidator(forgotPasswordValidator, emailForm, bindingResult);

        if (bindingResult.hasErrors())
        {
            modelAndView.getModelMap().addAttribute(EMAIL_ATTRIBUTE, emailForm);
            modelAndView.setViewName(Constants.Pages.FORGOT_PASSWORD);
        }
        else
        {
            userFacade.changePassword(emailForm);
            modelAndView.setViewName(Constants.Pages.NEW_PASSWORD_SUCCESS);
        }
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.NEW_PASSWORD_SUCCESS, method = RequestMethod.GET)
    public ModelAndView displaySuccessfulPasswordChangeMessage()
    {
        final ModelAndView modelAndView = new ModelAndView();

        if (checkIfAuthenticated(modelAndView))
        {
            return modelAndView;
        }

        modelAndView.setViewName(Constants.Pages.NEW_PASSWORD_SUCCESS);
        return modelAndView;
    }

    private boolean checkIfAuthenticated(final ModelAndView modelAndView)
    {
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
        {
            modelAndView.setViewName(Constants.Pages.HOME);
            return true;
        }
        return false;
    }

}
