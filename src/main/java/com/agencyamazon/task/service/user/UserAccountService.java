package com.agencyamazon.task.service.user;

import com.agencyamazon.task.model.document.UserAccountDocument;
import com.agencyamazon.task.model.dto.user.CreateUserAccountDto;

public interface UserAccountService {

    void create(CreateUserAccountDto createUserAccountDto);

    UserAccountDocument findByEmail(String email);

}
