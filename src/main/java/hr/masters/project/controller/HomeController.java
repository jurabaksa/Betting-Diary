package hr.masters.project.controller;

import hr.masters.project.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
    @RequestMapping(Constants.Paths.HOME_USER)
    public ModelAndView displayAuthenticatedHome()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.HOME_USER);
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