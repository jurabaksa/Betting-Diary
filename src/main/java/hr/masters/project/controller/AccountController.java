package hr.masters.project.controller;

import hr.masters.project.forms.NewUserForm;
import hr.masters.project.util.Constants;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AccountController
{
    private static final String USER_FORM_ATTRIBUTE = "NewUserForm";

    @RequestMapping(value = { Constants.Paths.LOGIN, Constants.Paths.INDEX, Constants.Paths.EMPTY })
    public ModelAndView authenticateUser()
    {
        final ModelAndView modelAndView = new ModelAndView();
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
        {
            modelAndView.setViewName(Constants.Pages.HOME_USER);
            return modelAndView;
        }
        modelAndView.setViewName(Constants.Pages.HOME_GUEST);
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.REGISTER, method = RequestMethod.POST)
    public ModelAndView registerUser(
            @Valid
            @ModelAttribute(USER_FORM_ATTRIBUTE)
            final NewUserForm newUserForm, final BindingResult bindingResult)
    {
        final ModelAndView modelAndView = new ModelAndView();

        System.out.println(newUserForm.getUsername() + " " + newUserForm.getPassword() + " " + newUserForm.getEmail());
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
        {
            modelAndView.setViewName(Constants.Pages.HOME_USER);
            return modelAndView;
        }
        modelAndView.setViewName(Constants.Pages.HOME_GUEST);
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.FORGOT, method = RequestMethod.POST)
    public ModelAndView generateNewPassword()
    {
        final ModelAndView modelAndView = new ModelAndView();
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
        {
            modelAndView.setViewName(Constants.Pages.HOME_USER);
            return modelAndView;
        }
        modelAndView.setViewName(Constants.Pages.HOME_GUEST);
        return modelAndView;
    }

    @RequestMapping(Constants.Paths.LOGOUT)
    public ModelAndView logoutUser()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.HOME_GUEST);
        return modelAndView;
    }

}