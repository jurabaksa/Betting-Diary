package hr.masters.project.service;

public interface EmailService
{
    void sendNewPassword(String userEmail, String newPassword);
}
