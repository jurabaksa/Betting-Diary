package hr.masters.project.service;

import hr.masters.project.model.UserModel;

import java.util.Optional;

public interface UserService
{
    UserModel findById(long id);

    Optional<UserModel> findByUsername(String username);

    UserModel findByEmail(String email);

    UserModel saveUser(UserModel user);

    UserModel updateUser(UserModel user);

    void deleteUser(long id);
}