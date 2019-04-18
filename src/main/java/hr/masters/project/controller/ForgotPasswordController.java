package hr.masters.project.controller;

import hr.masters.project.model.UserModel;
import hr.masters.project.repository.UserRepository;
import hr.masters.project.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ForgotPasswordController
{
    private static final String EMAIL_ATTRIBUTE = "Email";

    @Autowired
    private UserRepository userRepository;

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
        modelAndView.getModelMap().addAttribute(EMAIL_ATTRIBUTE, "email");

        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.FORGOT, method = RequestMethod.POST)
    public ModelAndView generateNewPassword(
            @ModelAttribute(EMAIL_ATTRIBUTE)
            final String email,
            final BindingResult bindingResult)
    {
        final ModelAndView modelAndView = new ModelAndView();
        final Optional<UserModel> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent())
        {
            modelAndView.setViewName(Constants.Pages.FORGOT_PASSWORD);
        }

        else
        {
            modelAndView.setViewName(Constants.Pages.FORGOT_PASSWORD);
            modelAndView.getModelMap().addAttribute(EMAIL_ATTRIBUTE, email);
        }
        return modelAndView;
    }
}
