package dev.arealnemexis.publicatusnotes.service;

import dev.arealnemexis.publicatusnotes.datasource.dtos.UserDetailsDto;
import dev.arealnemexis.publicatusnotes.datasource.dtos.request.LoginDto;
import dev.arealnemexis.publicatusnotes.datasource.dtos.request.RegisterDto;
import dev.arealnemexis.publicatusnotes.domain.UserEntity;
import dev.arealnemexis.publicatusnotes.datasource.repository.UserRepository;
import dev.arealnemexis.publicatusnotes.security.JWTCreator;
import dev.arealnemexis.publicatusnotes.security.JWTObject;
import dev.arealnemexis.publicatusnotes.security.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    public String login(LoginDto loginDto) throws Exception {
        UserEntity userEntity = userRepository.getByEmail(loginDto.getEmail());

        if (userEntity == null) {
            throw new Exception("Não encontrei");
        }
        if (!passwordEncoder.matches(loginDto.getPassword(), userEntity.getPassword())) {
            throw new Exception("Senha nao confere");
        }

        JWTObject jwtObject = new JWTObject();
        jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
        jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfiguration.EXPIRATION)));
        jwtObject.setSubject(userEntity.getId().toString());
        jwtObject.setRoles("AUTHENTICATED");

        return JWTCreator.create(SecurityConfiguration.PREFIX, SecurityConfiguration.KEY, jwtObject);
    }
}
