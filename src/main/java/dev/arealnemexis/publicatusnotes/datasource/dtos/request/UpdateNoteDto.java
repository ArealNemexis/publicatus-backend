package dev.arealnemexis.publicatusnotes.datasource.dtos.request;

import dev.arealnemexis.publicatusnotes.domain.PriorityEnum;

public class UpdateNoteDto {
    private String title;
    private String message;
    private PriorityEnum priority;

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
