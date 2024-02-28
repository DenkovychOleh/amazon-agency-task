package com.agencyamazon.task.service.converter.user;

import com.agencyamazon.task.model.document.UserAccountDocument;
import com.agencyamazon.task.model.dto.user.CreateUserAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAccountConverterDefault implements UserAccountConverter {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAccountDocument convertToDocument(CreateUserAccountDto createUserAccountDto) {
        UserAccountDocument userAccount = new UserAccountDocument();
        userAccount.setEmail(createUserAccountDto.getEmail());
        userAccount.setName(createUserAccountDto.getName());
        userAccount.setPassword(passwordEncoder.encode(createUserAccountDto.getPassword()));
        return userAccount;
    }

}
