package com.backapiboats.repository.crudrepository;

import com.backapiboats.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryModel, Integer> {
}
