package hr.masters.project.facades;

import hr.masters.project.forms.NewUserForm;

public interface UserFacade
{
    void createUser(NewUserForm newUserForm);

    void changePassword(NewUserForm newUserForm);
}