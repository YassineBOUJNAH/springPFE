package com.entreprise.projet.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SupervisorRepo  extends CrudRepository<Supervisor, Long> {

    Utilisateur findByUsername(String username);

}
