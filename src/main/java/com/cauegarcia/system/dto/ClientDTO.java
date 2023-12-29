package com.cauegarcia.system.dto;

import com.cauegarcia.system.entities.User;

public class ClientDTO {

    private Long id;
    private String name;

    public ClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDTO(User client) {
        id = client.getId();
        name = client.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
