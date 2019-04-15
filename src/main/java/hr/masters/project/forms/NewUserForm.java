package hr.masters.project.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewUserForm
{
    @NotNull(message = "{message.emptyField}")
    @NotBlank(message = "{message.emptyField}")
    private String username;

    @NotNull(message = "{message.emptyField")
    @NotBlank(message = "{message.emptyField}")
    @Email(message = "{registration.mail}")
    private String email;

    @NotNull(message = "{message.emptyField}")
    @NotBlank(message = "{message.emptyField}")
    private String password;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }
}
