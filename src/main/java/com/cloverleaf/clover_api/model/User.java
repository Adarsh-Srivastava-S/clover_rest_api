package com.cloverleaf.clover_api.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotEmpty
    @Column(unique = true)
    @Size(min=4,message = "Username must be min of 4 characters")
    private String userName;
    @NotEmpty
//    @Size(min=3,max = 10,message = "Password must be min of 3 chars and max of 10 chars !!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message = "Password must be min of 8 chars and combination of Capital,Small,Special letter !!")
    private String password;
    @Email(message = "Email address is not valid !!")
    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String gender;

    private String dob;

    private Long phoneNo;

    private String address;
    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user",referencedColumnName = "userId"),
    inverseJoinColumns = @JoinColumn(name="role",referencedColumnName = "id"))
    private Set<Role> roles=new HashSet<>();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
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
