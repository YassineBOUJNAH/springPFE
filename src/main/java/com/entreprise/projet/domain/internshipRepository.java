package com.entreprise.projet.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface internshipRepository extends CrudRepository< Internship , Long> {

}
