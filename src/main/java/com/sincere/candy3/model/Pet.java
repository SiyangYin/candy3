package com.sincere.candy3.model;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Pet {
    private String name;
    private String owner;
    private String species;
    private String sex;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birth;
    @Temporal(TemporalType.TIMESTAMP)
    private Date death;
    @Id
    private int id;

    public Pet(String name, String owner, String species, String sex, Date birth, Date death, int id) {
        this.name = name;
        this.owner = owner;
        this.species = species;
        this.sex = sex;
        this.birth = birth;
        this.death = death;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", species='" + species + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", death=" + death +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
