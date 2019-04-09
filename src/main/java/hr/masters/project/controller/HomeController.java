package hr.masters.project.controller;

import hr.masters.project.util.Constants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{

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

    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @RequestMapping(Constants.Fragments.HOME_USER)
    public ModelAndView displayAuthenticatedHome()
    {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
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