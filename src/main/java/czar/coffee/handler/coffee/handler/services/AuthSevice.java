package czar.coffee.handler.coffee.handler.services;


import czar.coffee.handler.coffee.handler.controllers.exceptions.DuplicateUserException;
import czar.coffee.handler.coffee.handler.dtos.LogInRequest;
import czar.coffee.handler.coffee.handler.dtos.SignUpRequest;
import czar.coffee.handler.coffee.handler.entities.User;
import czar.coffee.handler.coffee.handler.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthSevice {

    private final UsersRepository usersRepository;
    private  final PasswordEncoder passwordEncoder;
    private final  JwtService jwtService;

    public AuthSevice(UsersRepository usersRepository, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public Map<String,String> signUp (SignUpRequest request){

        if(usersRepository.existsByEmail(request.getEmail())){
            throw  new DuplicateUserException("The email has already been registered.");
        }

        String password = request.getPassword().trim();
        String confirm = request.getConfirmPassword().trim();

        if (!password.equals(confirm)) {
            throw new RuntimeException("Passwords do not match");
        }

        String hashedPassword = passwordEncoder.encode(password);

        User newUser = new User(
                request.getName(),
                request.getNickname(),
                request.getEmail(),
                hashedPassword
        );

        usersRepository.save(newUser);

        Map<String, String> response = new HashMap<>();
        response.put("msg", "User created");
        return response;
    }

    public String login(LogInRequest request) {

        User user = usersRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user.getEmail());
    }

}
