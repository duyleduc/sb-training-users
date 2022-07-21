package com.training.user.security;

import com.training.user.entities.role.Role;
import com.training.user.entities.role.RoleName;
import com.training.user.entities.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserPrincipal implements UserDetails {

    private String accountNumber;
    private String firstName;
    private String lastName;
    private String phone;

    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;


    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String accountNumber, String firstName, String lastName, String phone, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        if(authorities == null){
            authorities = null;
        }
        else {
            this.authorities = new ArrayList<>(authorities);
        }
    }

    public static UserPrincipal create(User user){
//        List<Role> roles = new ArrayList<>();
//        roles.add(new Role(RoleName.ROLE_USER));
//        user.setRoles(roles);

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

        return new UserPrincipal(user.getAccountNumber(), user.getFirstName(),user.getLastName(),user.getPhone(), user.getEmail(), user.getPassword(),authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
