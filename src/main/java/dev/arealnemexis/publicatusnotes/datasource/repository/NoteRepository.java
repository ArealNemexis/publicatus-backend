package dev.arealnemexis.publicatusnotes.datasource.repository;

import dev.arealnemexis.publicatusnotes.domain.NoteEntity;
import dev.arealnemexis.publicatusnotes.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    public List<NoteEntity> getNoteEntitiesByUser(UserEntity user);
}
