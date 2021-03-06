package ca.mcgill.ecse321.cooperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;

@Service
public class EmployerService {
	
	@Autowired
	EmployerRepository employerRepository;

	/**
	 * create a employer
	 * throws exception if any of the parameter is null
	 * return the saved employer
	 * 
	 * @param userEmail
	 * @param userPassword
	 * @param companyName
	 * @return Employer
	 */
	@Transactional
	public Employer createEmployer(String userEmail, String userPassword, String companyName) {
		Employer e = new Employer();
		
		if (userEmail == null || userEmail.trim().length() == 0) {
			throw new IllegalArgumentException("Email cannot be empty!");
		}
		if (userPassword == null || userPassword.trim().length() == 0) {
			throw new IllegalArgumentException("Password cannot be empty!");
		}
	    if (companyName == null || companyName.trim().length() == 0) {
			throw new IllegalArgumentException("Company name cannot be empty!");
		}
	    
	    e.setEmail(userEmail);
		e.setPassword(userPassword);
		e.setName(companyName);
		Employer eReturn = employerRepository.save(e);
		
		return eReturn;
	}
	
	/**
	 * get an employer by the id
	 * throws exception if the employer with the id is not found in the database
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public Employer getEmployerById(int id) {
	    
		Employer e = employerRepository.findById(id);
		
		if(e == null) {
			throw new IllegalArgumentException("there is no such employer");
		}
		return e;
	}
	
	
	/**
	 * get an employer by email
	 * throws exception if the employer with the email is not found in the database
	 * 
	 * @param email
	 * @return
	 */
	@Transactional
	public Employer getEmployerByEmail(String email) {
		
		if (email==null) {
	        throw new IllegalArgumentException("email cannot be empty!");
		}
		
		if (email.length() < 5) {
	        throw new IllegalArgumentException("invalid email");
		} 
		
		Employer e = employerRepository.findByEmail(email);
		
		if(e == null) {
			throw new IllegalArgumentException("there is no such employer");
		}
		
		return e;
	}
	
	/**
	 * delete an employer by the id
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteEmployer(int id) {
		employerRepository.deleteById(id);
	}
	
	/**
	 * get all employers in the database
	 * 
	 * @return
	 */
	@Transactional
	public List<Employer> getAllEmployers() {
		return toList(employerRepository.findAll());
	}
	
	/**
	 * convert iterable to a List
	 * @param iterable
	 * @return
	 */
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

}
