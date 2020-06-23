package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
