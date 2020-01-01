package com.sincere.candy3.dao;

import com.sincere.candy3.model.Pet;

import java.sql.SQLException;
import java.util.List;

public interface PetDao {
    List<Pet> getAllPetsFromDB();

    List<Pet> testSelectFromDB() throws SQLException;

    List<Pet> testInsertFromDB() throws SQLException;

    List<Pet> testUpdateFromDB() throws SQLException;

    List<Pet> testDeleteFromDB() throws SQLException;
}
