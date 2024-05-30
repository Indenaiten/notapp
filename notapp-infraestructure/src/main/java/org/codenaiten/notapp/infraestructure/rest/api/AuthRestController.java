package org.codenaiten.notapp.infraestructure.rest.api;

import org.codenaiten.notapp.application.dto.SignupDto;
import org.codenaiten.notapp.application.request.LoginRequest;
import org.codenaiten.notapp.application.request.SignupRequest;
import org.codenaiten.notapp.infraestructure.rest.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthRestController {

    @PostMapping("/signup")
    ApiResponse<SignupDto> signup(@RequestBody final SignupRequest request );

    @PostMapping("/login")
    ApiResponse<Void> login(@RequestBody final LoginRequest request );

}
