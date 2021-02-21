package ru.icmit.logistics.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.icmit.logistics.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Boolean existsByUsername(String username);

    @Query("select u from User u where username = :username ")
    User findByName(@Param("username") String username);
}
