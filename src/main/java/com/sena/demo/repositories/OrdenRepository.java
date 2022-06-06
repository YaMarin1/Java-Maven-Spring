package com.sena.demo.repositories;


import com.sena.demo.models.OrdenModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrdenRepository extends CrudRepository<OrdenModel, Long> {
    public abstract ArrayList<OrdenModel> findByDocumento(Long documento);
}
