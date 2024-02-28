package com.agencyamazon.task.service.authentication;

import com.agencyamazon.task.model.dto.authentication.AuthenticationRequestDto;
import com.agencyamazon.task.model.dto.authentication.AuthenticationResponseDto;
import com.agencyamazon.task.model.dto.user.CreateUserAccountDto;

public interface AuthenticationService {

    void register(CreateUserAccountDto createUserAccountDto);

    AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto);

}
