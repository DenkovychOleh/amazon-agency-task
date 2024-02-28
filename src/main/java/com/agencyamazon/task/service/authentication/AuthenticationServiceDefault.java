package com.agencyamazon.task.service.authentication;

import com.agencyamazon.task.exception.UnauthenticatedException;
import com.agencyamazon.task.model.document.UserAccountDocument;
import com.agencyamazon.task.model.domain.security.jwt.JwtUtil;
import com.agencyamazon.task.model.dto.authentication.AuthenticationRequestDto;
import com.agencyamazon.task.model.dto.authentication.AuthenticationResponseDto;
import com.agencyamazon.task.model.dto.user.CreateUserAccountDto;
import com.agencyamazon.task.service.user.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceDefault implements AuthenticationService {

    private final UserAccountService userAccountService;

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    @Override
    public void register(CreateUserAccountDto createUserAccountDto) {
        userAccountService.create(createUserAccountDto);
    }

    @Override
    public AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto) {
        UserAccountDocument userAccountDocument = authenticate(authenticationRequestDto);
        return getAuthenticationResponse(userAccountDocument);
    }

    private AuthenticationResponseDto getAuthenticationResponse(UserAccountDocument userAccountDocument) {
        String token = jwtUtil.generateToken(userAccountDocument);
        return new AuthenticationResponseDto(token);
    }

    private UserAccountDocument authenticate(AuthenticationRequestDto authenticationRequestDto) {
        UserAccountDocument userAccountDocument = userAccountService.findByEmail(authenticationRequestDto.getEmail());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequestDto.getEmail(),
                            authenticationRequestDto.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new UnauthenticatedException("Account is not authenticated. Check your email and password");
        }
        return userAccountDocument;
    }

}
