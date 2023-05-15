package com.example.kursach.models;

//import com.example.kursach.models.enums.Role;

import com.example.kursach.models.enums.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
//@Data
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Long idUser;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userAddress")
    private String userAddress;
    @Column(name = "userPhone", unique = true)
    private String userPhone;
    @Column(name = "userEmail", unique = true)
    private String userEmail;


    @Column(name = "active")
    private boolean active;

    @Column(name = "password", length = 10000)
    private String password;

    @OneToOne//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idImg")
    private Image avatar;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Instrument> instruments = new ArrayList<>();

    private LocalDateTime dateOfCreated;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Bucket bucket;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    //Security check
    public boolean isAdmin() {return roles.contains(Role.ROLE_ADMIN);}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    public String getUserNickname(){return userName;}

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
        return active;
    }
}
