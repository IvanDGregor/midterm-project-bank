package com.ironhack.midtermprojectbank.model.users;

public class ThirdParty {

    private String hasKey;
    private String name;

    public ThirdParty(String hasKey, String name) {
        this.hasKey = hasKey;
        this.name = name;
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
