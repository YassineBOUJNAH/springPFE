package com.entreprise.projet.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface reportRepository extends CrudRepository< report, Long> {

    //List<report> findAllByInternshipId(Long id) ;

}
