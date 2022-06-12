package com.sena.demo.repositories;
import com.sena.demo.models.OrdenModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrdenRepository extends CrudRepository<OrdenModel, Long> {
    public abstract ArrayList<OrdenModel> findByDocumento(Long documento);
}