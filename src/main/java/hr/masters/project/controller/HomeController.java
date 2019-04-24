package hr.masters.project.controller;

import hr.masters.project.facades.UserFacade;
import hr.masters.project.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
    private static final String USER_ATTRIBUTE = "user";

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(Constants.Paths.HOME)
    public ModelAndView displayAuthenticatedHome()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.HOME);
        modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.getLoggedUser().getUsername());
        return modelAndView;
    }

    @RequestMapping(Constants.Paths.BOOTSTRAP)
    public ModelAndView displayBootstrapDesignSample()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.BOOTSTRAP);
        return modelAndView;
    }
}