package com.ucc.Demo.Backend.Model.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table (name = "pet")

public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String humanId;
    private Boolean isLinked;
    private String description;



    //muchas pets tienen un user
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "users")
    private User user;

    public Pet() {}


    public Pet(Long id, String name, String humanId, Boolean isLinked, String description ) {
        this.id = id;
        this.name = name;
        this.humanId = humanId;
        this.isLinked = isLinked;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHumanId() {
        return humanId;
    }

    public void setHumanId(String humanId) {
        this.humanId = humanId;
    }

    public Boolean getLinked() {
        return isLinked;
    }

    public void setLinked(Boolean linked) {
        isLinked = linked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }






}
