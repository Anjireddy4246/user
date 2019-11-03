package com.ts.user.repository.v1;

import com.ts.user.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT * FROM User WHERE loginId=:loginId", nativeQuery = true)
    User getByLoginId(@Param("loginId") String loginId);
}