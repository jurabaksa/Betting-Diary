package hr.masters.project.controller;

import hr.masters.project.facades.UserFacade;
import hr.masters.project.forms.ProfileSettingsForm;
import hr.masters.project.util.Constants;
import hr.masters.project.validators.ProfileSettingsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileSettingsController
{
    private static final String PROFILE_SETTINGS_FORM = "ProfileSettingsForm";
    private static final String USER_ATTRIBUTE = "user";

    @Autowired
    private ProfileSettingsValidator profileSettingsValidator;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = Constants.Paths.PROFILE_SETTINGS, method = RequestMethod.GET)
    public ModelAndView displayProfileSettings()
    {
        final ModelAndView modelAndView = new ModelAndView();
        final ProfileSettingsForm profileSettingsForm = userFacade.populateProfileSettingsForm();
        modelAndView.setViewName(Constants.Pages.PROFILE_SETTINGS);
        modelAndView.getModelMap().addAttribute(PROFILE_SETTINGS_FORM, profileSettingsForm);
        modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.retrieveLoggedUser());
        return modelAndView;
    }

    @RequestMapping(value = Constants.Paths.PROFILE_SETTINGS, method = RequestMethod.POST)
    public ModelAndView changeProfileSettings(
            @ModelAttribute(PROFILE_SETTINGS_FORM)
            final ProfileSettingsForm profileSettingsForm,
            final BindingResult bindingResult)
    {
        final ModelAndView modelAndView = new ModelAndView();
        ValidationUtils.invokeValidator(profileSettingsValidator, profileSettingsForm, bindingResult);

        if (bindingResult.hasErrors())
        {
            modelAndView.getModelMap().addAttribute(PROFILE_SETTINGS_FORM, profileSettingsForm);
            modelAndView.setViewName(Constants.Pages.PROFILE_SETTINGS);
        }
        else
        {
            userFacade.changeProfileSettings(profileSettingsForm);
            modelAndView.getModelMap().addAttribute(PROFILE_SETTINGS_FORM, profileSettingsForm);
            modelAndView.setViewName(Constants.Pages.PROFILE_SETTINGS);
        }
        modelAndView.getModelMap().addAttribute(USER_ATTRIBUTE, userFacade.retrieveLoggedUser());
        return modelAndView;
    }
}
