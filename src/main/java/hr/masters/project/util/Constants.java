package hr.masters.project.util;

public interface Constants
{
    interface Fragments
    {
        String HOME = "/";

        String HOME_USER = "/home";

        String BOOTSTRAP = "/bootstrap";

        String LOGOUT = "/logout";

    }

    interface Pages
    {
        String HOME_GUEST = "homeGuest";

        String HOME_USER = "homeUser";

        String BOOTSTRAP = "bootstrap";

    }

    interface Roles
    {
        String ROLE_ADMIN = "ROLE_ADMIN";

        String ROLE_USER = "ROLE_USER";

        String ADMIN = "ADMIN";

        String USER = "USER";

        String ANT_ADMIN = "**/admin/**";

        String ANT_USER = "**/user/**";
    }

    interface Exceptions
    {
        String NOUSERNAME = "Username not found!";
    }
}