package com.api.Crud.Komet.controllers;


import com.api.Crud.Komet.models.FlowerModel;
import com.api.Crud.Komet.services.FlowerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @GetMapping
    public ArrayList<FlowerModel> getFlowers(){
        return this.flowerService.getFlowers();
    }

    @PostMapping
    public FlowerModel saveFlower(@RequestBody FlowerModel flower){
        return this.flowerService.saveFlower(flower);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.flowerService.deleteFlower(id);
        if (ok){
            return "La Flor con el Id " + id + "fue borrada";
        } else {
            return "Error, La flor con el id " + id + "no pudo ser borrada";
        }
    }
    @GetMapping(path = "/greater")
    public ArrayList<FlowerModel> getFlowersG(){
        return this.flowerService.getFlowersG();
    }

    @PutMapping
    public List getName(@RequestBody String name) throws JsonProcessingException {

        return this.flowerService.getName(name);
    }

    @GetMapping("/name")
    public ArrayList<String> getConcat(){
        return this.flowerService.getFlowersConcat();
    }




}
