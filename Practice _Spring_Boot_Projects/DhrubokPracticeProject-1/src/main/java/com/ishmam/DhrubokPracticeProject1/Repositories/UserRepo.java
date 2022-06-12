package com.ishmam.DhrubokPracticeProject1.Repositories;

import com.ishmam.DhrubokPracticeProject1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, BigInteger> {
    Optional<User> findByemail(String email);

    List<User> findBybloodGroup(String bloodGroup);
}
