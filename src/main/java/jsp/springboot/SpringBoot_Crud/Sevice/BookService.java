package jsp.springboot.SpringBoot_Crud.Sevice;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.SpringBoot_Crud.DTO.ResponseStructure;
import jsp.springboot.SpringBoot_Crud.Entity.Book;
import jsp.springboot.SpringBoot_Crud.Exception.IdNotFoundException;
import jsp.springboot.SpringBoot_Crud.Exception.RecordNotFoundException;
import jsp.springboot.SpringBoot_Crud.Repository.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	public ResponseStructure<Book> saveBook(Book book){
		ResponseStructure<Book> res = new ResponseStructure<Book>();
		res.setStatusCode(HttpStatus.CREATED.value());
		res.setMessage("Book added successfully.");
		res.setData(bookRepo.save(book));
		return res;
	}
	
	public ResponseStructure<List<Book>> saveAllBook(List<Book> book){
		ResponseStructure<List<Book>> res = new ResponseStructure<List<Book>>();
		res.setStatusCode(HttpStatus.CREATED.value());
		res.setMessage("Books added successfully.");
		res.setData(bookRepo.saveAll(book));
		return res;
	}
	
	public ResponseStructure<Book> fetchById(Integer id){
		Optional<Book> opt = bookRepo.findById(id);
		ResponseStructure<Book> res = new ResponseStructure<Book>();
		if(opt.isEmpty()) 
			throw new IdNotFoundException("Book with id: "+id+" not available.");
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Book with id: "+id+" fetched successfully.");
		res.setData(opt.get());
		return res;
	}
	
	public ResponseStructure<List<Book>> fetchAll(){
		List<Book> books = bookRepo.findAll();
		ResponseStructure<List<Book>> res = new ResponseStructure<List<Book>>();
		if(books.isEmpty())
			throw new RecordNotFoundException("No Data To Fetch.");
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Record fetched successfully");
		res.setData(books);
		return res;
	}
	
	public ResponseStructure<Book> updateRecord(Book book){
		ResponseStructure<Book> res = new ResponseStructure<Book>();
		if(book.getId() == null) 
			throw new IdNotFoundException("No such ID to update.");
		
		Book existingBook = bookRepo.findById(book.getId()).orElseThrow(() -> new RecordNotFoundException("No record with ID: "+book.getId()+" found."));
		
		existingBook.setTitle(book.getTitle());
	    existingBook.setAuthor(book.getAuthor());
	    existingBook.setGenre(book.getGenre());
	    existingBook.setPrice(book.getPrice());
	    existingBook.setPublishedYear(book.getPublishedYear());
	    existingBook.setAvailability(book.getAvailability());

	    Book updatedBook = bookRepo.save(existingBook);

	    res.setStatusCode(HttpStatus.OK.value());
	    res.setMessage("Record updated successfully");
	    res.setData(updatedBook);

	    return res;
	}
	
	public ResponseStructure<Book> deleteBook(Integer id){
		ResponseStructure<Book> res = new ResponseStructure<Book>();
		
		Optional<Book> opt = bookRepo.findById(id);
		
		if(opt.isEmpty()) 
			throw new RecordNotFoundException("No record found to delete");
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Record with id: "+id+" deleted successfully.");

		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
