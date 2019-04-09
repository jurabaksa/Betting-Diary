package hr.masters.project.service.impl;

import hr.masters.project.model.UserModel;
import hr.masters.project.repository.UserRepository;
import hr.masters.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel findById(final long id)
    {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserModel> findByUsername(final String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserModel findByEmail(final String email)
    {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserModel saveUser(final UserModel user)
    {
        return userRepository.save(user);
    }

    @Override
    public UserModel updateUser(final UserModel user)
    {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(final long id)
    {
        final UserModel user = userRepository.findById(id);
        userRepository.delete(user);
    }
}