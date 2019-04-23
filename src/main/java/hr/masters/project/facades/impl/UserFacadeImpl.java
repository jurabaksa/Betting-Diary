package hr.masters.project.facades.impl;

import hr.masters.project.facades.UserFacade;
import hr.masters.project.forms.NewUserForm;
import hr.masters.project.model.UserModel;
import hr.masters.project.repository.RoleRepository;
import hr.masters.project.service.EmailService;
import hr.masters.project.service.UserService;
import hr.masters.project.util.Constants;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeImpl implements UserFacade
{
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void createUser(final NewUserForm newUserForm)
    {
        final UserModel newUser = new UserModel();
        newUser.setUsername(newUserForm.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(newUserForm.getPassword()));
        newUser.setEmail(newUserForm.getEmail());
        newUser.setRole(roleRepository.findByRole(Constants.Roles.USER));
        userService.saveUser(newUser);
    }

    @Override
    public void changePassword(final NewUserForm newUserForm)
    {
        final UserModel user = userService.findByEmail(newUserForm.getEmail()).get();
        final String generatedPassword = generateRandomPassword();
        user.setPassword(bCryptPasswordEncoder.encode(generatedPassword));
        emailService.sendNewPassword(user.getEmail(), generatedPassword);
        userService.saveUser(user);
    }

    private String generateRandomPassword()
    {
        final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        return RandomStringUtils.random(10, characters);
    }
}