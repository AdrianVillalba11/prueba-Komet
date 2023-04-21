package com.api.Crud.Komet.repositories;

import com.api.Crud.Komet.models.FlowerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlowerRepository extends JpaRepository <FlowerModel, Long> {

}
