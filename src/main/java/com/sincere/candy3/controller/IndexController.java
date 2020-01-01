package com.sincere.candy3.controller;

import com.sincere.candy3.model.Pet;
import com.sincere.candy3.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private PetService petService;

    @GetMapping("index")
    public List<Pet> index(HttpServletRequest request) {
        List<Pet> allPets = petService.getAllPets();
        System.out.println(allPets);
        return allPets;
    }
    @GetMapping("testSelect")
    public List<Pet> testSelect(HttpServletRequest request) throws SQLException {
        List<Pet> result = petService.testSelect();
        System.out.println(result);
        return result;
    }

    @GetMapping("testInsert")
    public List<Pet> testInsert(HttpServletRequest request) throws SQLException {
        List<Pet> result = petService.testInsert();
        System.out.println(result);
        return result;
    }

    @GetMapping("testUpdate")
    public List<Pet> testUpdate(HttpServletRequest request) throws SQLException {
        List<Pet> result = petService.testUpdate();
        System.out.println(result);
        return result;
    }

    @GetMapping("testDelete")
    public List<Pet> testDelete(HttpServletRequest request) throws SQLException {
        List<Pet> result = petService.testDelete();
        System.out.println(result);
        return result;
    }
}
