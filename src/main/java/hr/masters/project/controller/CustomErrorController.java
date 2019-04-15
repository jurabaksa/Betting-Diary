package hr.masters.project.controller;

import hr.masters.project.util.Constants;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController
{
    @RequestMapping(Constants.Paths.ERROR)
    public ModelAndView displayErrorPage()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(Constants.Pages.ERROR);
        return modelAndView;
    }

    @Override
    public String getErrorPath()
    {
        return Constants.Paths.ERROR;
    }
}