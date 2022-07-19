//package com.training.user.security;
//
//import com.training.user.entities.user.User;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//@AllArgsConstructor
//@Getter
//public class UserPrincipal implements UserDetails {
//
//    private String accountNumber;
//    private String firstName;
//    private String lastName;
//    private String phone;
//
//    @JsonIgnore
//    private String email;
//    @JsonIgnore
//    private String password;
//
////    private Collection<? extends GrantedAuthority> authorities;
//
//    public static UserPrincipal create(User user){
//        return new UserPrincipal(user.getAccountNumber(), user.getFirstName(),user.getLastName(),user.getPhone(), user.getEmail(), user.getPassword());
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
