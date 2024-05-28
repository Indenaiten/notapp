package org.codenaiten.notapp.infraestructure.rest.api;

import org.codenaiten.notapp.application.dto.SignupDto;
import org.codenaiten.notapp.application.request.SignupRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthRestController {

    @PostMapping("/signup")
    SignupDto signup( @RequestBody final SignupRequest request );

}
