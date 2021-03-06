package hr.masters.project.model;

import javax.persistence.*;

@Entity
@Table(name = "roles", schema = "nova")
public class RoleModel
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String role;

    public RoleModel()
    {

    }

    public RoleModel(final String name)
    {
        this.role = name;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getRole()
    {
        return this.role;
    }

    public void setRole(final String role)
    {
        this.role = role;
    }
}