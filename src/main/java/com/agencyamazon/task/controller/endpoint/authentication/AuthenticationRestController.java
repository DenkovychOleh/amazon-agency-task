package com.agencyamazon.task.controller.endpoint.authentication;

import com.agencyamazon.task.model.dto.authentication.AuthenticationRequestDto;
import com.agencyamazon.task.model.dto.authentication.AuthenticationResponseDto;
import com.agencyamazon.task.model.dto.user.CreateUserAccountDto;
import com.agencyamazon.task.service.authentication.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/api/v1/authentication")
@RestController
public class AuthenticationRestController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid CreateUserAccountDto createUserAccountDto) {
        authenticationService.register(createUserAccountDto);
    }

    @PostMapping("/login")
    public AuthenticationResponseDto login(@RequestBody @Valid AuthenticationRequestDto authenticationRequestDto) {
        return authenticationService.login(authenticationRequestDto);
    }

}
