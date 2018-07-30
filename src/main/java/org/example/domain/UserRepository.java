package org.example.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author caipiaoping
 * @version V1.0
 * @Description: TODO
 * @date 2018-07-31
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

}
