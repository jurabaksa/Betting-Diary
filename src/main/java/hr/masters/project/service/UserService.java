package hr.masters.project.service;

import hr.masters.project.model.UserModel;

import java.util.Optional;

public interface UserService
{
    UserModel getById(long id);

    Optional<UserModel> getByUsername(String username);

    Optional<UserModel> getByEmail(String email);

    UserModel saveUser(UserModel user);

    UserModel updateUser(UserModel user);

    void deleteUser(long id);
}