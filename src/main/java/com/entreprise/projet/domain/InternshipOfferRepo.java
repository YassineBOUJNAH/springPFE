package com.entreprise.projet.domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface InternshipOfferRepo extends CrudRepository<InternshipOffer, Long> {
    List<InternshipOffer> findByStudentId(Long studentId) ;
    List<InternshipOffer> findByState(String state);

}
