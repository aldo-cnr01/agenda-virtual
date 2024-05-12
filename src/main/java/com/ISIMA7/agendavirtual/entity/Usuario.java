package com.ISIMA7.agendavirtual.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", columnDefinition = "VARCHAR(150)", nullable = false)
    private String nombres;

    @Column(name = "ape_paterno", columnDefinition = "VARCHAR(150)", nullable = false)
    private String apePaterno;

    @Column(name = "ape_materno", columnDefinition = "VARCHAR(150)", nullable = false)
    private String apeMaterno;

    @Column(name = "edad", columnDefinition = "INT", nullable = false)
    private String edad;

    @Column(name = "email", columnDefinition = "VARCHAR(255)", nullable = false)
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;

    @ManyToMany(targetEntity = Rol.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<Rol> roles;


    public Usuario(String nombres, String apePaterno, String apeMaterno, String edad, String email, String password, Collection<Rol> roles) {
        this.nombres = nombres;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.edad = edad;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
