package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
