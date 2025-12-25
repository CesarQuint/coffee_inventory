package czar.coffee.handler.coffee.handler.controllers;


import czar.coffee.handler.coffee.handler.dtos.LogInRequest;
import czar.coffee.handler.coffee.handler.dtos.SignUpRequest;
import czar.coffee.handler.coffee.handler.dtos.responses.AuthLogInResponse;
import czar.coffee.handler.coffee.handler.services.AuthSevice;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthSevice authSevice;

    public  AuthController(AuthSevice authSevice){
        this.authSevice = authSevice;
    }

    @PostMapping("/signup")
    public Map<String, String> signup(@Valid @RequestBody SignUpRequest request){
        Map<String,String> response = authSevice.signUp(request);
        return  response;
    }

    @PostMapping("/login")
    public AuthLogInResponse login(@Valid @RequestBody LogInRequest request) {
        AuthLogInResponse response = authSevice.login(request);
        return response;
    }

}
