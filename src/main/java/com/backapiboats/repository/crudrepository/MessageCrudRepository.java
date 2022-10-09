package com.backapiboats.repository.crudrepository;

import com.backapiboats.model.MessageModel;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<MessageModel, Integer> {
}
