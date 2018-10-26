package springmvc.mvctest.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import springmvc.mvctest.rest.entity.Book;
import springmvc.mvctest.rest.exception.BookNotFoundException;
import springmvc.mvctest.rest.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/{bno}", method = RequestMethod.GET)
	public @ResponseBody Book getBookByBno(@PathVariable("bno") Integer bno) {
		Book bookByBno = bookService.getBookByBno(bno);
		if (bookByBno == null) {
			throw new BookNotFoundException(bno);
		}
		return bookByBno;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Book> getBooks() {
		return bookService.getBooks();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}


}
