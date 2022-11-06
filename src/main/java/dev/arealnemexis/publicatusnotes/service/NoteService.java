package dev.arealnemexis.publicatusnotes.service;

import dev.arealnemexis.publicatusnotes.datasource.dtos.request.UpdateNoteDto;
import dev.arealnemexis.publicatusnotes.datasource.dtos.response.NoteResponseDto;
import dev.arealnemexis.publicatusnotes.datasource.mapper.NoteMapper;
import dev.arealnemexis.publicatusnotes.datasource.repository.NoteRepository;
import dev.arealnemexis.publicatusnotes.domain.NoteEntity;
import dev.arealnemexis.publicatusnotes.domain.UserEntity;
import dev.arealnemexis.publicatusnotes.exception.NotFoundNoteException;
import dev.arealnemexis.publicatusnotes.exception.UnautorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;


    public void saveNote(NoteEntity note) {
        noteRepository.save(note);
    }

    public List<NoteResponseDto> getNotes(UserEntity user) {
        return noteRepository
                .getNoteEntitiesByUser(user)
                .stream()
                .map(NoteMapper.INSTANCE::noteEntityToNoteResponseDto)
                .collect(Collectors.toList());
    }

    public void updateNote(Long userId, Long idNote, UpdateNoteDto dto) throws NotFoundNoteException, UnautorizedException {
        NoteEntity note = noteRepository.findById(idNote).orElseThrow(NotFoundNoteException::new);

        if (!Objects.equals(note.getUser().getId(), userId)){
            throw new UnautorizedException();
        }

        NoteMapper.INSTANCE.updateNoteFromDto(dto, note);

        noteRepository.save(note);
    }

    public void deleteNote(Long userId, Long idNote) throws NotFoundNoteException, UnautorizedException{
        NoteEntity note = noteRepository.findById(idNote).orElseThrow(NotFoundNoteException::new);

        if (!Objects.equals(note.getUser().getId(), userId)){
            throw new UnautorizedException();
        }

        noteRepository.deleteById(idNote);
    }


}
