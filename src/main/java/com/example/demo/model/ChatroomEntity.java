package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chatroom_entity")
public class ChatroomEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @ManyToMany
    private List<UserEntity> users;

    private String name;
    private String link;

    public ChatroomEntity() {
        super();
    }

    public ChatroomEntity(List<UserEntity> users, String name) {
        this.users = users;
        this.name = name;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getLink() {
        return "/chatroom/" + id;
    }

    public boolean addUser(UserEntity user){
        if (!users.contains(user) && user != null) {
            users.add(user);
            return true;
        }
        return false;
    }

    public boolean removeUser(UserEntity user){
        if (users.contains(user) && user != null) {
            users.add(user);
            return true;
        }
        return false;
    }
}
