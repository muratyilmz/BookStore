package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.model.Library;
import com.library.service.*;


@Controller
public class LibraryController {
	@Autowired
	private LibraryService libraryService;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listLibrary",libraryService.getAllBookStores());
		return "index";
		
		
		
	}
	@GetMapping("/showNewLibraryForm")
	public String showNewLibraryForm(Model model){
		Library library = new Library(); 
		model.addAttribute("library", library);
		return "new_library";
		
	}
	@PostMapping("/saveLibrary")
	public String saveLibrary(@ModelAttribute("library") Library library) {
		
		libraryService.saveLibrary(library);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id")long id, Model model){
		Library library = libraryService.getLibrary(id);
		model.addAttribute("library",library);
		return "update_library";
	}
	@GetMapping("/deleteItem/{id}")
	public String deleteItem(@PathVariable(value="id")long id) {
		this.libraryService.deleteItem(id);
		return "redirect:/";
	}
	
	
	
	
	
}
