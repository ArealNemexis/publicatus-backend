package dev.arealnemexis.publicatusnotes.datasource.dtos.request;

import dev.arealnemexis.publicatusnotes.domain.NoteEntity;
import dev.arealnemexis.publicatusnotes.domain.PriorityEnum;

public class CreateNoteDto {
    private String title;
    private String message;
    private PriorityEnum priority = PriorityEnum.LOW;

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

    public NoteEntity toNoteEntity() {
        NoteEntity note = new NoteEntity();

        note.setTitle(this.getTitle());
        note.setMessage(this.getMessage());
        note.setPriority(this.getPriority());


        return note;
    }
}
