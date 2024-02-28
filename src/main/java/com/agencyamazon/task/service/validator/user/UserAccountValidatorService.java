package com.agencyamazon.task.service.validator.user;

import com.agencyamazon.task.model.dto.user.CreateUserAccountDto;

public interface UserAccountValidatorService {

    void validate(CreateUserAccountDto createUserAccountDto);

}
