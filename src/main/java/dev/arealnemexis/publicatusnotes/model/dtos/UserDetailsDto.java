package dev.arealnemexis.publicatusnotes.model.dtos;

import dev.arealnemexis.publicatusnotes.model.entity.UserEntity;

public class UserDetailsDto {
    private Long id;
    private String name;
    private String email;

    public UserDetailsDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDetailsDto(UserEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
