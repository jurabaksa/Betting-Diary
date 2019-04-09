package hr.masters.project.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountDetailsModel extends UserModel implements UserDetails
{
    public AccountDetailsModel(final UserModel user)
    {
        super(user);
    }

    @Override
    public String getUsername()
    {
        return super.getUsername();
    }

    @Override
    public String getPassword()
    {
        return super.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(getRole().getRole()));
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}