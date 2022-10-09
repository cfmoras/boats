package com.backapiboats.repository.crudrepository;

import com.backapiboats.model.BoatModel;
import org.springframework.data.repository.CrudRepository;

public interface BoatCrudRepository extends CrudRepository<BoatModel, Integer> {

}
