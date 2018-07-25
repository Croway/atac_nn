package com.croway.atacnn.repository;

import org.springframework.data.repository.CrudRepository;

import com.croway.atacnn.model.NNModel;

public interface NNModelRepository extends CrudRepository<NNModel, Double> {

}
