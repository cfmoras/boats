package com.backapiboats.repository.crudrepository;

import com.backapiboats.model.AdminModel;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<AdminModel, Integer> {
}
