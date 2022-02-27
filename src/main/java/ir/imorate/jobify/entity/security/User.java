package ir.imorate.jobify.entity.security;

import ir.imorate.jobify.entity.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 32, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 128)
    @ToString.Exclude
    private String password;

    @Column(name = "email", nullable = false, length = 32, unique = true)
    private String email;

    @Column(name = "account_non_expired")
    private Boolean accountNonExpired = Boolean.TRUE;

    @Column(name = "account_non_locked")
    private Boolean accountNonLocked = Boolean.TRUE;

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired = Boolean.TRUE;

    @Column(name = "enabled")
    private Boolean enabled = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private Set<Role> roles;

}