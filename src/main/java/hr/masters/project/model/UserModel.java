package hr.masters.project.model;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "betting_diary_db")
public class UserModel
{
    @Id
    private String username;
    private String email;
    private String password;
    private String name;
    private String surname;
    private int balance;
    private boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleModel role;

    public UserModel()
    {

    }

    public UserModel(final UserModel user)
    {
        this.username = user.getUsername();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.balance = user.getBalance();
        this.role = user.getRole();
        this.enabled = false;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return this.surname;
    }

    public void setSurname(final String surname)
    {
        this.surname = surname;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public int getBalance()
    {
        return this.balance;
    }

    public void setBalance(final int balance)
    {
        this.balance = balance;
    }

    public RoleModel getRole()
    {
        return this.role;
    }

    public void setRole(final RoleModel role)
    {
        this.role = role;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(final boolean enabled)
    {
        this.enabled = enabled;
    }
}