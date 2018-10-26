package springmvc.mvctest.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import springmvc.mvctest.rest.entity.Book;

@Component
public class BookService {
	
	public Book getBookByBno(Integer bno){
		if(bno == 1){
			Book book = new Book();
			book.setBno(bno);
			book.setName("追风筝的人");
			return book;
		}
		return null;
	}
	
	public List<Book> getBooks(){
		List<Book> list = new ArrayList<Book>();
		Book book = new Book();
		book.setBno(001);
		book.setName("追风筝的人");
		
		Book book1 = new Book();
		book1.setBno(002);
		book1.setName("黄金时代");
		
		list.add(book);
		list.add(book1);
		return list;
	}
	
	
	public Book addBook(Book book){
		return book;
	}
}
