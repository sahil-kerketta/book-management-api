package jsp.springboot.SpringBoot_Crud.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.SpringBoot_Crud.DTO.ResponseStructure;
import jsp.springboot.SpringBoot_Crud.Entity.Book;
import jsp.springboot.SpringBoot_Crud.Repository.BookRepo;
import jsp.springboot.SpringBoot_Crud.Sevice.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private BookService bookService;
	
	//to save a record------------------------------------------------------------------------------------
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.saveBook(book),HttpStatus.CREATED);
	}
	
	//to save an array of object or multiple object ------------------------------------------------------
	@PostMapping("/saveAll")
	public ResponseEntity<ResponseStructure<List<Book>>> saveAllBook(@RequestBody List<Book> book) {
		return new ResponseEntity<>(bookService.saveAllBook(book),HttpStatus.CREATED);
	}
	
	
	//to get a record by the id -------------------------------------------------------------------------
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Book>> fetchById(@PathVariable Integer id){
		return new ResponseEntity<>(bookService.fetchById(id),HttpStatus.OK);
	}
	
	//to find all the records ---------------------------------------------------------------------------
	@GetMapping("/getAll")
	public ResponseEntity<ResponseStructure<List<Book>>> getAll(){
		return new ResponseEntity<>(bookService.fetchAll(),HttpStatus.OK);
	}
	
	//to update all fields-------------------------------------------------------------------------------
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Book>> updateRecord(@RequestBody Book book){
		return new ResponseEntity<>(bookService.updateRecord(book),HttpStatus.CREATED);
		
	}
	
	
//	@PatchMapping("/patch/{id}")
//	public ResponseStructure<Book> patchRecord(@RequestBody Book book, @PathVariable Integer id){
//		Optional<Book> opt = bookRepo.findById(id);
//		ResponseStructure<Book> res = new ResponseStructure<Book>();
//		
//		if(opt.isPresent()) {
//			res.setStatusCode(HttpStatus.OK.value());
//			res.setMessage("Record updated successfully");
//			res.setData(opt.get());
//			
//			return res;
//		} else {
//			res.setStatusCode(HttpStatus.NOT_FOUND.value());
//			res.setMessage("No record available to update");
//			res.setData(null);
//			
//			return res;
//		}
//	}
	
	
	//to delete a single record---------------------------------------------------------------------------
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Book>> deleteBook(@PathVariable Integer id){
		return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.OK);
	}
	
	//to delete all records----------------------------------------------------------------
	@DeleteMapping("/deleteAll")
	public ResponseStructure<String> deleteAll(){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("All data deleted successfully");
		bookRepo.deleteAll();
		
		return res;
	}
	
	@GetMapping("/author/{author}")
	public ResponseEntity<ResponseStructure<List<Book>>> getByAuthor(@PathVariable String author){
		List<Book> books = bookRepo.findByAuthor(author);
		ResponseStructure<List<Book>> res = new ResponseStructure<List<Book>>();
		
		if(books.isEmpty())
			throw new RuntimeException("Book with author " + author + " not available");
		
		else {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Book with author " + author + " retrieved");
			res.setData(books);
			
			return new ResponseEntity<>(res,HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/year/{year}")
	public ResponseEntity<ResponseStructure<String>> existByPublishedYear(@PathVariable Integer publishedYear){
		Boolean books = bookRepo.existsByPublishedYear(publishedYear);
		ResponseStructure<String> res = new ResponseStructure<>();
		
		if(books) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Records available for the year: " + publishedYear);
			res.setData("book fetched successfully based on the published year");
			
			return new ResponseEntity<>(res,HttpStatus.OK);
		}
		else {
			throw new RuntimeException("No records available");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

