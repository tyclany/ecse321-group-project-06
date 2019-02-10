package ca.mcgill.ecse321.cooperator.repository;


import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.entity.AcademicManager;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AcademicManagerRepository extends CrudRepository<AcademicManager, Integer> {
	
	
		
	
	
}
