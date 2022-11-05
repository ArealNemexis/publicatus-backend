package dev.arealnemexis.publicatusnotes.domain;

import dev.arealnemexis.publicatusnotes.datasource.dtos.response.NoteResponseDto;

import javax.persistence.*;

@Entity
@Table(name = "tb_note")
public class NoteEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "priority")
    private PriorityEnum priority = PriorityEnum.LOW;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserEntity user;
    

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }
}
