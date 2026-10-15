package jsp.springboot.SpringBoot_Crud.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.SpringBoot_Crud.DTO.ResponseStructure;
import jsp.springboot.SpringBoot_Crud.Entity.Book;
import jsp.springboot.SpringBoot_Crud.Sevice.BookService;

@RestController
@RequestMapping("/api/records")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//to save a record------------------------------------------------------------------------------------
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.saveBook(book),HttpStatus.CREATED);
	}
	
	//to save an array of object or multiple object -----------------------------------------------------
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
	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<Book>>> fetchAll(){
		return new ResponseEntity<>(bookService.fetchAll(),HttpStatus.OK);
	}
	
	//to update all fields-------------------------------------------------------------------------------
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Book>> updateRecord(@RequestBody Book book){
		return new ResponseEntity<>(bookService.updateRecord(book),HttpStatus.CREATED);
	}
	
	//to delete a single record---------------------------------------------------------------------------
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Book>> deleteBook(@PathVariable Integer id){
		return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.OK);
	}
	
	//to delete all records------------------------------------------------------------------------------
	@DeleteMapping("/deleteAll")
	public ResponseEntity<ResponseStructure<String>> deleteAll(){
		return new ResponseEntity<>(bookService.deleteAll(),HttpStatus.OK);
	}
	
	//to fetch records with author name-------------------------------------------------------------------
	@GetMapping("/author/{author}")
	public ResponseEntity<ResponseStructure<List<Book>>> getByAuthor(@PathVariable String author){
		return new ResponseEntity<>(bookService.findByAuthor(author),HttpStatus.OK);
	}	
}

