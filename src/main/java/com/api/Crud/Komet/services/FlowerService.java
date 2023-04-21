package com.api.Crud.Komet.services;

import com.api.Crud.Komet.models.FlowerModel;
import com.api.Crud.Komet.repositories.IFlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FlowerService {
    @Autowired // Inyeccion de dependencias
    IFlowerRepository flowerRepository;

    // recupera las flores y las devuelve en una lista
    public ArrayList<FlowerModel> getFlowers() {
        return (ArrayList<FlowerModel>) flowerRepository.findAll();
    }

    // guardar objeto en el repositorio
    public FlowerModel saveFlower(FlowerModel flower) {
        return flowerRepository.save(flower);
    }

    // Eliminar Flor

    public Boolean deleteFlower (Long id){
        try {
            flowerRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }




}
