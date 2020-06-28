package com.ironhack.midtermprojectbank.model.users;

import javax.persistence.*;

@Entity
public class ThirdParty extends User{

    private String hashKey;
    private String name;

    public ThirdParty(String hashKey, String name) {
        this.hashKey = hashKey;
        this.name = name;
    }

    public ThirdParty() {
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hasKey) {
        this.hashKey = hasKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
