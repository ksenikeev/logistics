package ru.icmit.logistics.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.icmit.logistics.domain.User;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoggedInUser implements UserDetails {
    private final String displayName;
    private String username;
    private String password;
    private String salt;
    private final Set<GrantedAuthority> roles = new HashSet<>();

    public String getDisplayName() {
        return displayName;
    }

    public LoggedInUser(User user, List<String> userRoles) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.salt = user.getSalt();
        this.displayName = user.getUsername();

        userRoles.forEach(role -> {
            roles.add(new SimpleGrantedAuthority(role));
        } );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public String getPassword() {
        System.out.println("getPassword");return password;
    }

    public String getSalt() {
        return salt;
    }
}
