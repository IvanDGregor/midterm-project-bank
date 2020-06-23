package com.ironhack.midtermprojectbank.model.users;

import javax.persistence.*;

@Entity
public class ThirdParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hasKey;
    private String name;

    public ThirdParty(String hasKey, String name) {
        this.hasKey = hasKey;
        this.name = name;
    }

    public ThirdParty() {
    }

    public String getHasKey() {
        return hasKey;
    }

    public void setHasKey(String hasKey) {
        this.hasKey = hasKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
