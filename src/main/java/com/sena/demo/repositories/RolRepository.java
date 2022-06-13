package com.sena.demo.repositories;

import com.sena.demo.models.RolModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RolRepository extends CrudRepository<RolModel, Long> {
}
