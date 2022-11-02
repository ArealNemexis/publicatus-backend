package dev.arealnemexis.publicatusnotes.repository;

import dev.arealnemexis.publicatusnotes.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity getByEmail(String email);
}
