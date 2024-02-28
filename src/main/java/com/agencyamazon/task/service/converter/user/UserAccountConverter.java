package com.agencyamazon.task.service.converter.user;

import com.agencyamazon.task.model.document.UserAccountDocument;
import com.agencyamazon.task.model.dto.user.CreateUserAccountDto;

public interface UserAccountConverter {

    UserAccountDocument convertToDocument(CreateUserAccountDto createUserAccountDto);

}
