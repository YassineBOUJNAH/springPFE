package com.entreprise.projet.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface PostRepository extends CrudRepository < Post , Long > {

 List<Post> findAllBySupervisor_idOrderByPostedAtDesc(Long id) ;


 }
