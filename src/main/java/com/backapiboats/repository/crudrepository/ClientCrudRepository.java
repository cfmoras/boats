package com.backapiboats.repository.crudrepository;

import com.backapiboats.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<ClientModel, Integer> {

}
