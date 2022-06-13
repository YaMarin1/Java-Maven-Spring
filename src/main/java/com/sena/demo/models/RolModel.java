package com.sena.demo.models;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombrerol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

}
