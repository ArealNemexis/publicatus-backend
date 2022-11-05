package dev.arealnemexis.publicatusnotes.datasource.dtos.response;

import dev.arealnemexis.publicatusnotes.domain.PriorityEnum;

public class NoteResponseDto {
    public Long id;
    public String title;
    public String message;
    public PriorityEnum priority;

    public NoteResponseDto(Long id, String title, String message, PriorityEnum priority) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
