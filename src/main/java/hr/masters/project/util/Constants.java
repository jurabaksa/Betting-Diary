package hr.masters.project.util;

public interface Constants
{
    interface Paths
    {
        String EMPTY = "/";

        String INDEX = "/index";

        String HOME = "/home";

        String LOGIN = "/login";

        String LOGOUT = "/logout";

        String REGISTER = "/registration";

        String REGISTRATION_SUCCESS = "/registrationSuccess";

        String FORGOT_PASSWORD = "/forgotPassword";

        String NEW_PASSWORD_SUCCESS = "/newPasswordSuccess";

        String ADD_TICKET = "/addTicket";

        String MY_TICKETS = "/myTickets";

        String TICKET_DETAILS = "/ticketDetails";

        String VISUAL_STATS = "/visualStats";

        String WINNINGS_HISTORY = "/winningsHistory";

        String PDF_EXPORT = "/pdfExport";

        String PROFILE_SETTINGS = "/profileSettings";

        String ERROR = "/error";

        String BOOTSTRAP = "/bootstrap";

        String CSS = "/css/**";

        String FONTS = "/fonts/**";

        String IMAGES = "/images/**";

        String IMG = "/img/**";

        String JS = "/js/**";

        String STYLE = "/style.css";

    }

    interface Pages
    {
        String REGISTRATION = "registration";

        String REGISTRATION_SUCCESS = "registrationSuccess";

        String LOGIN = "login";

        String FORGOT_PASSWORD = "forgotPassword";

        String NEW_PASSWORD_SUCCESS = "newPasswordSuccess";

        String ADD_TICKET = "addTicket";

        String MY_TICKETS = "myTickets";

        String TICKET_DETAILS = "ticketDetails";

        String VISUAL_STATS = "visualStats";

        String WINNINGS_HISTORY = "winningsHistory";

        String PDF_EXPORT = "pdfExport";

        String PROFILE_SETTINGS = "profileSettings";

        String HOME = "home";

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

    interface Email
    {
        String EMAIL_NAME = "betting_diary@bd.com";

        String NEW_PASSWORD_SUBJECT = "New password";

        String NEW_PASSWORD_HEADING = "Hello, per your request we provided you with new password. Your new password is: ";
    }
}