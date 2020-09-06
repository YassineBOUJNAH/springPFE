package com.entreprise.projet.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Utilisateur, Long> { 
    Utilisateur findByUsername(String username);
}