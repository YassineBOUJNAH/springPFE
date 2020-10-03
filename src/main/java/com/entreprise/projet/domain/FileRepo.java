package com.entreprise.projet.domain;

import org.springframework.data.repository.CrudRepository;

public interface FileRepo extends CrudRepository< FileStorage , Long > {
    
}
