package com.example.barbearia_pai.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@EqualsAndHashCode()
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String nome;

    @Enumerated(EnumType.STRING)
    private UserRole role;


    public User(RegisterDTO dto) {
        this.login = dto.login();
        this.nome = dto.nome();
        this.password = dto.password();
        this.role = dto.role();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return  List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public User(String login, String password, String nome, UserRole role) {
        this.login = login;
        this.password = password;
        this.nome = nome;
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public User (String login, String password, UserRole role){
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public User(){

    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public UserRole getRole() {
        return role;
    }

    @Override
    public String getUsername() {
        return login;
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

    public String getPassword() {
        return password;
    }
}
