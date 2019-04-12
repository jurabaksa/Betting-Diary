package hr.masters.project.controller;

import hr.masters.project.service.UserService;
import hr.masters.project.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = Constants.Fragments.HOME)
    public ModelAndView authenticateUser()
    {
        final ModelAndView modelAndView = new ModelAndView();
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
        {
            modelAndView.setViewName(Constants.Pages.HOME_USER);
            return modelAndView;
        }

        modelAndView.setViewName(Constants.Pages.HOME_GUEST);
        return modelAndView;
    }

    @RequestMapping(Constants.Fragments.HOME_USER)
    public ModelAndView displayAuthenticatedHome()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.HOME_USER);
        return modelAndView;
    }

    @RequestMapping(Constants.Fragments.LOGOUT)
    public ModelAndView logout()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.HOME_GUEST);
        return modelAndView;
    }

    @RequestMapping(Constants.Fragments.BOOTSTRAP)
    public ModelAndView displayBootstrapDesign()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.BOOTSTRAP);
        return modelAndView;
    }
}