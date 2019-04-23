package hr.masters.project.facades;

import hr.masters.project.forms.NewUserForm;
import hr.masters.project.forms.ProfileSettingsForm;
import hr.masters.project.model.UserModel;

public interface UserFacade
{
    void createUser(NewUserForm newUserForm);

    void changePassword(NewUserForm newUserForm);

    UserModel getLoggedUser();

    ProfileSettingsForm populateProfileSettingsForm();

    void changeProfileSettings(ProfileSettingsForm profileSettingsForm);
}