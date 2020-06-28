package com.ironhack.midtermprojectbank.repository;

import com.ironhack.midtermprojectbank.model.users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long> {
    @Query(value = "SELECT third_party.hash_key, third_party.name, third_party.id, user.password, user.username FROM third_party JOIN user ON third_party.id = user.id WHERE hash_key = :hashKey", nativeQuery = true)
    ThirdParty findByHashKey(String hashKey);
}
