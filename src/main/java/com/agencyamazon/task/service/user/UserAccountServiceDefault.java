package com.agencyamazon.task.service.user;

import com.agencyamazon.task.exception.DataNotFoundException;
import com.agencyamazon.task.model.document.UserAccountDocument;
import com.agencyamazon.task.model.dto.user.CreateUserAccountDto;
import com.agencyamazon.task.repository.mongo.UserAccountMongoRepository;
import com.agencyamazon.task.service.converter.user.UserAccountConverter;
import com.agencyamazon.task.service.validator.user.UserAccountValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAccountServiceDefault implements UserAccountService {

    private final UserAccountMongoRepository userAccountMongoRepository;

    private final UserAccountValidatorService userAccountValidatorService;

    private final UserAccountConverter userAccountConverter;

    @Override
    public void create(CreateUserAccountDto createUserAccountDto) {
        userAccountValidatorService.validate(createUserAccountDto);

        UserAccountDocument userAccountDocument = userAccountConverter.convertToDocument(createUserAccountDto);

        userAccountMongoRepository.save(userAccountDocument);
    }

    @Override
    public UserAccountDocument findByEmail(String email) {
        return userAccountMongoRepository.findByEmail(email)
                .orElseThrow(() -> new DataNotFoundException(UserAccountDocument.Fields.email));
    }

}
