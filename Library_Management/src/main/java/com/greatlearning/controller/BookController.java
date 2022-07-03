package com.greatlearning.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.entity.Book;
import com.greatlearning.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/list")
	public String listBooks(Model model) {

		List<Book> books = bookService.findAll();

		model.addAttribute("Books", books);

		return "list-Books";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Book book = new Book();
		model.addAttribute("Book", book);
		return "Book-form";
	}

	@RequestMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int id, Model model) {
		Book book = bookService.findById(id).get();
		model.addAttribute("Book", book);
		return "Book-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("category") String category, @RequestParam("author") String author) {

		Book book = new Book();

		if (id != 0) {

			// book=bookService.findById(id);

			book = bookService.findById(id).get();

			book.setName(name);
			book.setCategory(category);
			book.setAuthor(author);

		} else {

			book = new Book(name, category, author);

		}

		bookService.save(book);

		return "redirect:/books/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("bookId") int id) {

		bookService.deleteById(id);

		return "redirect:/books/list";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("name") String name, @RequestParam("author") String author, Model model) {

		if (name.trim().isEmpty() && author.trim().isEmpty()) {
			return "redirect:/books/list";
		} else {
			List<Book> books = bookService.searchBy(name, author);

			model.addAttribute("Books", books);

			return "list-Books";
		}

	}

	@RequestMapping(value = "403")
	public ModelAndView accessDenied(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();

		if (principal != null) {

			modelAndView.addObject("msg",
					"Hello" + principal.getName() + "You dont have permission to access this page");

		} else {

			modelAndView.addObject("msg", "You dont have permission to access this page");

		}

		modelAndView.setViewName("403");
		return modelAndView;

	}

}
