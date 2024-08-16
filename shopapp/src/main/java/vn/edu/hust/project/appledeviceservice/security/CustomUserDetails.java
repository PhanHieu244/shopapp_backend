package vn.edu.hust.project.appledeviceservice.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.port.IRolePort;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {
    private final UserEntity userEntity;
    private final IUserPort userPort;

    private final IRolePort rolePort;

    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(UserEntity userEntity, IUserPort userPort, IRolePort rolePort) {
        this.userEntity = userEntity;
        this.userPort = userPort;
        this.rolePort = rolePort;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var role = rolePort.getRoleById(userEntity.getRoleId());
        return Collections.singleton(new SimpleGrantedAuthority(role.getCode()));
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return String.valueOf(userEntity.getId());
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
}
