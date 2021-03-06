package com.censos.api.controller;

import java.util.Collections;

import com.censos.api.entity.Role;
import com.censos.api.entity.StringResponse;
import com.censos.api.entity.User;
import com.censos.api.payload.LoginDTO;
import com.censos.api.payload.SignUpDTO;
import com.censos.api.payload.UserDTO;
import com.censos.api.repository.RoleRepository;
import com.censos.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<UserDTO> authenticateUser(@RequestBody LoginDTO loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepository
                .findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getPassword()).get();
        UserDTO userDTO = new UserDTO(user.getName(), user.getUsername(), user.getEmail());

        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<StringResponse> registerUser(@RequestBody SignUpDTO signUpDto) {

        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            return new ResponseEntity<StringResponse>(new StringResponse("Nome de usu??rio j?? utilizado!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<StringResponse>(new StringResponse("Email j?? utilizado!"),
                    HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<StringResponse>(new StringResponse("Usu??rio registrado com sucesso!"), HttpStatus.OK);

    }

    @GetMapping(value = "/logout")
    public ResponseEntity<StringResponse> logout() {
        return new ResponseEntity<StringResponse>(new StringResponse("Logout conclu??do com sucesso!"), HttpStatus.OK);
    }
}