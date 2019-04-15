package hr.masters.project.facades.impl;

import hr.masters.project.facades.UserFacade;
import hr.masters.project.forms.NewUserForm;
import hr.masters.project.model.UserModel;
import hr.masters.project.repository.RoleRepository;
import hr.masters.project.service.UserService;
import hr.masters.project.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeImpl implements UserFacade
{
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createUser(final NewUserForm newUserForm)
    {
        final UserModel newUser = new UserModel();
        newUser.setUsername(newUserForm.getUsername());
        newUser.setPassword(newUserForm.getPassword());
        newUser.setEmail(newUserForm.getEmail());
        newUser.setRole(roleRepository.findByRole(Constants.Roles.USER));
        userService.saveUser(newUser);
    }
}
