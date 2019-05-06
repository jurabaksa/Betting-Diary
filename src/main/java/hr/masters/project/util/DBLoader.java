package hr.masters.project.util;

import hr.masters.project.model.RoleModel;
import hr.masters.project.model.UserModel;
import hr.masters.project.repository.RoleRepository;
import hr.masters.project.repository.UserRepository;
import hr.masters.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class DBLoader
{
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @PostConstruct
    public void initializeTestUsers()
    {
        final RoleModel adminRole = createRole(Constants.Roles.ADMIN);
        final RoleModel userRole = createRole(Constants.Roles.USER);
        createUser(
                "Ime",
                "Prezime",
                "admin",
                encodePassword("admin1"),
                "admin@mail.hr",
                0,
                adminRole
        );
    }

    @Transactional
    public RoleModel createRole(final String rolename)
    {
        RoleModel role = roleRepository.findByRole(rolename);
        if (ObjectUtils.isEmpty(role))
        {
            role = new RoleModel(rolename);
            role.setRole(rolename);
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    public void createUser(
            final String name,
            final String surname,
            final String username,
            final String password,
            final String email,
            final int balance,
            final RoleModel role)
    {

        UserModel user = null;
        if (userRepository.findByUsername(username).isPresent())
        {
            user = userRepository.findByUsername(username).get();
        }

        if (ObjectUtils.isEmpty(user))
        {
            user = new UserModel();
            user.setUsername(username);
            user.setPassword(password);
            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setRole(role);
            user.setBalance(balance);
            userService.saveUser(user);
        }
    }

    private String encodePassword(final String rawPassword)
    {
        return bCryptPasswordEncoder.encode(rawPassword);
    }
}
