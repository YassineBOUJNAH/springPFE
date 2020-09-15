package com.entreprise.projet.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface internshipRepository extends CrudRepository< Internship , Long> {

     @Query(value = "SELECT * FROM internship u  WHERE u.supervisor_id = ?1 " , nativeQuery = true)
     List<Internship> findBySupervisor(Long supervisor_id) ;
}
