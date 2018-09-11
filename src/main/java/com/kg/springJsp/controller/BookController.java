package com.kg.springJsp.controller;


import com.kg.springJsp.model.Book;
import com.kg.springJsp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @RequestMapping("/")
    String index(){
        return "index";
    }
    @RequestMapping(value="/books", method=RequestMethod.GET)
    public String book(Model model)
    {
        Iterable<Book> books= bookRepository.findAll();
       for (Book b : books) 
       {
           System.out.println("Books"+b);
       }
        model.addAttribute("books",books);
		return "books";
        // ModelAndView modelAndView = new ModelAndView();
        // modelAndView.setViewName("BooksList");
        // return modelAndView;
    }
    @RequestMapping("book/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "booksForm";
    }
    @RequestMapping(value = "book/add", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute Book book,Model model)
    {
        bookRepository.save(book); 
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}
