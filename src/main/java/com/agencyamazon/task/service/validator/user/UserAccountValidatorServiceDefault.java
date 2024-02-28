package com.agencyamazon.task.service.validator.user;

import com.agencyamazon.task.exception.DuplicateDataException;
import com.agencyamazon.task.model.dto.user.CreateUserAccountDto;
import com.agencyamazon.task.repository.mongo.UserAccountMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAccountValidatorServiceDefault implements UserAccountValidatorService {

    private final UserAccountMongoRepository userAccountMongoRepository;


    @Override
    public void validate(CreateUserAccountDto createUserAccountDto) {
        validateEmail(createUserAccountDto.getEmail());
    }

    private void validateEmail(String email) {
        if (userAccountMongoRepository.findByEmail(email).isPresent()) {
            throw new DuplicateDataException(CreateUserAccountDto.Fields.email);
        }
    }
}
