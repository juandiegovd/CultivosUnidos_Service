package org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TS_USUARIO")
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "nombre_usuario", unique = true)
    private String username;

    @Column(name = "credenciales_acceso")
    private String password;

    @Column(name = "state")
    private Boolean state;

    @Column(name = "rol")
    private String role;
}
