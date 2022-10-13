package com.backapiboats.repository.crudrepository;

import com.backapiboats.model.ScoreModel;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<ScoreModel, Integer> {
}
