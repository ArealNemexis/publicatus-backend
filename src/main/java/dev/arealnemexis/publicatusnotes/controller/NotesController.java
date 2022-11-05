package dev.arealnemexis.publicatusnotes.controller;

import dev.arealnemexis.publicatusnotes.datasource.dtos.UserDetailsDto;
import dev.arealnemexis.publicatusnotes.datasource.dtos.request.CreateNote;
import dev.arealnemexis.publicatusnotes.datasource.dtos.response.DefaultResponseDto;
import dev.arealnemexis.publicatusnotes.datasource.dtos.response.NoteResponseDto;
import dev.arealnemexis.publicatusnotes.domain.NoteEntity;
import dev.arealnemexis.publicatusnotes.domain.UserEntity;
import dev.arealnemexis.publicatusnotes.security.JWTCreator;
import dev.arealnemexis.publicatusnotes.security.JWTObject;
import dev.arealnemexis.publicatusnotes.security.SecurityConfiguration;
import dev.arealnemexis.publicatusnotes.service.JwtTokenService;
import dev.arealnemexis.publicatusnotes.service.NoteService;
import dev.arealnemexis.publicatusnotes.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NotesController {
    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity<?> getNotes(@RequestHeader("Authorization") String token) {
        JWTObject jwtParsed = JWTCreator.create(token, SecurityConfiguration.PREFIX, SecurityConfiguration.KEY);
        Long userId = Long.valueOf(jwtParsed.getSubject());

        List<NoteResponseDto> notes = noteService.getNotes(new UserEntity(userId));

        return ResponseEntity.ok(notes);
    }

    @PostMapping
    public ResponseEntity<?> createNote(@RequestHeader("Authorization") String token, @RequestBody CreateNote requestBody) throws Exception {
        JWTObject jwtParsed = JWTCreator.create(token, SecurityConfiguration.PREFIX, SecurityConfiguration.KEY);
        Long userId = Long.valueOf(jwtParsed.getSubject());

        NoteEntity newNote = requestBody.toNoteEntity();
        UserEntity user = userService.findUserById(userId);
        newNote.setUser(user);

        noteService.saveNote(newNote);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
