package com.library.service;

import java.util.List;

import com.library.model.Library;

public interface LibraryService {
	List<Library> getAllBookStores();
	void saveLibrary(Library library);
	Library getLibrary(long id);
	void deleteItem(long id);
	
	
	
}
