package jsp.springboot.SpringBoot_Crud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jsp.springboot.SpringBoot_Crud.Entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	List<Book> findByAuthor(String author);
	
	Boolean existsByPublishedYear(Integer publishedYear);
}
