package com.agencyamazon.task.model.domain.security;

import com.agencyamazon.task.model.document.UserAccountDocument;
import com.agencyamazon.task.repository.mongo.UserAccountMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceDefault implements UserDetailsService {

    private final UserAccountMongoRepository userAccountMongoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserAccountDocument userAccountDocument = userAccountMongoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return new User(userAccountDocument.getEmail(),
                userAccountDocument.getPassword(), userAccountDocument.getAuthorities());
    }
}
