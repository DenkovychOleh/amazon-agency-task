package com.agencyamazon.task.repository.mongo;

import com.agencyamazon.task.model.document.UserAccountDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountMongoRepository extends MongoRepository<UserAccountDocument, String> {

    Optional<UserAccountDocument> findByEmail(String email);

}
