package dev.arealnemexis.publicatusnotes.domain;

import javax.persistence.*;

@Entity
@Table(name="tb_user")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name="id_user")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public UserEntity(Long id){
        this.id = id;
    }

    public UserEntity(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public UserEntity() { }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
