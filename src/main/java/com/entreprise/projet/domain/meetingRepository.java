package com.entreprise.projet.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface meetingRepository extends CrudRepository< meeting ,Long> {
}
