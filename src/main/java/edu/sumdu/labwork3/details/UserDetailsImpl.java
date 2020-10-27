package edu.sumdu.labwork3.details;

import edu.sumdu.labwork3.model.User;
import edu.sumdu.labwork3.model.UserRole;
import edu.sumdu.labwork3.service.UserRoleService;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {

    private final UserRoleService userRoleService;
    final static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);
    private final User user;

    public UserDetailsImpl(UserRoleService userRoleService, User user) {
        this.userRoleService = userRoleService;
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<UserRole> userRoles = userRoleService.getByUsername(user.getUsername());
        Set<GrantedAuthority> roles = new HashSet<>();
        for (UserRole userRole : userRoles) {
            roles.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
