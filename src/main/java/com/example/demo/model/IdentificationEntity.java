package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "identification_entity")
public class IdentificationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @OneToOne
    private UserEntity user;
    private String hash;

    public IdentificationEntity() {
        super();
    }

    public IdentificationEntity(UserEntity user, String hash) {
        this.user = user;
        this.hash = hash;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
