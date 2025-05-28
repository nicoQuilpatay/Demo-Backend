package com.ucc.Demo.Backend.Model.entities;
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

    public Pet() {}


    public Pet(Long id, String name, String humanId, Boolean isLinked, String description, String qrCode) {
        this.id = id;
        this.name = name;
        this.humanId = humanId;
        this.isLinked = isLinked;
        this.description = description;
        this.qrCode = qrCode;
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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    private String qrCode;





}
