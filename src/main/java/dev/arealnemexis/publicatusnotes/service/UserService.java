package dev.arealnemexis.publicatusnotes.service;

import dev.arealnemexis.publicatusnotes.model.dtos.UserDetailsDto;
import dev.arealnemexis.publicatusnotes.model.dtos.request.LoginDto;
import dev.arealnemexis.publicatusnotes.model.dtos.request.RegisterDto;
import dev.arealnemexis.publicatusnotes.model.entity.UserEntity;
import dev.arealnemexis.publicatusnotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(RegisterDto registerDto) throws Exception {
        String encriptedPassword = passwordEncoder.encode(registerDto.getPassword());

        UserEntity userEntity = userRepository.getByEmail(registerDto.getEmail());

        if (userEntity != null) {
            throw new Exception("Email ja cadastrado");
        }

        userEntity = new UserEntity(registerDto.getName(), encriptedPassword, registerDto.getEmail());

        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public UserDetailsDto authenticateUser(LoginDto loginDto) throws Exception {
        UserEntity userEntity = userRepository.getByEmail(loginDto.getEmail());

        if (userEntity == null) {
            throw new Exception("Não encontrei");
        }

        if (!passwordEncoder.matches(loginDto.getPassword(), userEntity.getPassword())) {
            throw new Exception("Senha nao confere");
        }

        return new UserDetailsDto(userEntity);
    }
}
