package com.library.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	public String viewHomePage(Model model,
			@Param("keyword") String keyword) {
		
		List<Library> listLibrary = libraryService.getAllBookStores();
		model.addAttribute("listLibrary",listLibrary);
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
	@GetMapping("/search")
	public String search(@Param("keyword")String keyword, Model model ) {		
		List<Library> searchResult = libraryService.search(keyword);
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("pageTitle","Search result for '" +keyword +"'");
	    model.addAttribute("searchResult", searchResult);
		return "search_result";
	}
	
	
	
		@GetMapping("/login")
		public String login() {
			return "login";
		}
		
		@GetMapping("/detailedView/{id}")
		public String detailedView(@PathVariable (value="id")long id, Model model){
			Library library = libraryService.getLibrary(id);
			model.addAttribute("library",library);
			return "detailed_view";
		}
		
		@GetMapping("/user")
		public String userPage(Model model,
				@Param("keyword") String keyword) {
			
			List<Library> listLibrary = libraryService.getAllBookStores();
			model.addAttribute("listLibrary",listLibrary);
			return "user";
			
		}
		@GetMapping("/adminlogin")
		public String adminLogin() {
			return "adminlogin";
		}
	
	
	
}
