package ir.imorate.jobify.entity.security;

import ir.imorate.jobify.entity.security.enums.RoleType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
@Setter
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true, length = 16)
    @Enumerated(EnumType.STRING)
    private RoleType type;

    @Column(name = "description", nullable = false, length = 16)
    private String description;

}