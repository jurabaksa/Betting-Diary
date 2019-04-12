package hr.masters.project.service.impl;

import hr.masters.project.model.AccountDetailsModel;
import hr.masters.project.model.UserModel;
import hr.masters.project.repository.UserRepository;
import hr.masters.project.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException
    {
        final Optional<UserModel> optionalUser = userRepository.findByUsername(username);
        if (!optionalUser.isPresent())
        {
            throw new UsernameNotFoundException(Constants.Exceptions.NOUSERNAME);
        }

        return optionalUser.map(user -> new AccountDetailsModel(user)).get();
    }
}