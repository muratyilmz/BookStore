package com.library.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Library;
import com.library.repository.LibraryRepository;
import java.util.*;

@Service
public class LibraryServiceImp implements LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public List<Library> getAllBookStores() {
	return libraryRepository.findAll();
	}
	
	@Override
	public void saveLibrary(Library library) {
		this.libraryRepository.save(library);
		
	}
	@Override
	public Library getLibrary(long id) {
		Optional<Library> optional = libraryRepository.findById(id);
		Library library = null;
		if(optional.isPresent()) {
			library = optional.get();			
		}
		else {
			System.out.println("Book not found for id :"+id);
		}
		return library;
	
	}
	@Override
	public void deleteItem(long id) {
		this.libraryRepository.deleteById(id);
		
	}
	
	public List<Library> search(String keyword){
		return libraryRepository.search(keyword);
		
		
		
	}
	
	

}
