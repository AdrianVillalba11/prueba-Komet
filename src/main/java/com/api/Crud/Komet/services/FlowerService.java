package com.api.Crud.Komet.services;

import com.api.Crud.Komet.models.FlowerModel;
import com.api.Crud.Komet.repositories.IFlowerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    // Retornar flores con precio mayor a n
    public ArrayList<FlowerModel> getFlowersG() {
        ArrayList<FlowerModel> all = (ArrayList<FlowerModel>) flowerRepository.findAll();
       ArrayList<FlowerModel> m=new ArrayList<>();
        for (int i=0;i<all.size();i++){
            if(all.get(i).getPrice() >20){
                m.add(all.get(i));
            }
        }
        return m;

    }
    // obtener por el nombre
    public List getName(String name) throws JsonProcessingException {

        ArrayList<FlowerModel> all = (ArrayList<FlowerModel>) flowerRepository.findAll();
        ArrayList<FlowerModel> names=new ArrayList<>(); // lista vacia de flores
        ObjectMapper objectMapper = new ObjectMapper();// de json a string
        JsonNode rootNode = objectMapper.readTree(name);
        String jsonString = rootNode.get("name").asText();
        for (int i=0;i<all.size();i++){

            if(all.get(i).getName().equals(jsonString)){

                names.add(all.get(i)); // agregs a la lista vaxia
            }

        }
        return names;



    }

    // ordenar e impirmir

    public ArrayList<String> getFlowersConcat() {
        ArrayList<FlowerModel> all = (ArrayList<FlowerModel>) flowerRepository.findAll();
        ArrayList<String> name=new ArrayList<>(); // lista vacia de strings
        for (int i=0;i<all.size();i++){
            name.add(all.get(i).getName()+"-kometsales "+all.get(i).getPrice());

        }
        Collections.sort(name);
        return name;

    }




}
