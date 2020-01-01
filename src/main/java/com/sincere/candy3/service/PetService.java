package com.sincere.candy3.service;

import com.sincere.candy3.model.Pet;

import java.sql.SQLException;
import java.util.List;

public interface PetService {
    List<Pet> getAllPets();

    List<Pet> testSelect() throws SQLException;

    List<Pet> testInsert() throws SQLException;

    List<Pet> testUpdate() throws SQLException;

    List<Pet> testDelete() throws SQLException;
}
