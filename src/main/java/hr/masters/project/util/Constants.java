package hr.masters.project.util;

public interface Constants
{
    interface Paths
    {
        String EMPTY = "/";

        String INDEX = "/index";

        String HOME_USER = "/home";

        String LOGIN = "/login";

        String LOGOUT = "/logout";

        String REGISTER = "/register";

        String FORGOT = "/forgot";

        String ERROR = "/error";

        String BOOTSTRAP = "/bootstrap";

    }

    interface Pages
    {
        String HOME_GUEST = "homeGuest";

        String HOME_USER = "homeUser";

        String BOOTSTRAP = "bootstrap";

        String ERROR = "error";

    }

    interface Roles
    {
        String ROLE_ADMIN = "ROLE_ADMIN";

        String ROLE_USER = "ROLE_USER";

        String ADMIN = "ADMIN";

        String USER = "USER";
    }

    interface Exceptions
    {
        String NOUSERNAME = "Username not found!";
    }
}