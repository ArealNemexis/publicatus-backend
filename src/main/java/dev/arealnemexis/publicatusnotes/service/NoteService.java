package dev.arealnemexis.publicatusnotes.service;

import dev.arealnemexis.publicatusnotes.datasource.dtos.response.NoteResponseDto;
import dev.arealnemexis.publicatusnotes.datasource.mapper.NoteMapper;
import dev.arealnemexis.publicatusnotes.datasource.repository.NoteRepository;
import dev.arealnemexis.publicatusnotes.domain.NoteEntity;
import dev.arealnemexis.publicatusnotes.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
