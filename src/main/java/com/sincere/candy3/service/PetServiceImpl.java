package com.sincere.candy3.service;

import com.sincere.candy3.dao.PetDao;
import com.sincere.candy3.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetDao petDao;

    @Override
    public List<Pet> getAllPets() {
        return petDao.getAllPetsFromDB();
    }

    @Override
    public List<Pet> testSelect() throws SQLException {
        return petDao.testSelectFromDB();
    }

    @Override
    public List<Pet> testInsert() throws SQLException {
        return petDao.testInsertFromDB();
    }

    @Override
    public List<Pet> testUpdate() throws SQLException {
        return petDao.testUpdateFromDB();
    }

    @Override
    public List<Pet> testDelete() throws SQLException {
        return petDao.testDeleteFromDB();
    }
}
