package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
	@Query(value = "SELECT * FROM bookstore WHERE MATCH (isbn,book,publisher,writer) against (?1)",
			nativeQuery = true)
	
	public List<Library> search(String keyword);
	

	

}
