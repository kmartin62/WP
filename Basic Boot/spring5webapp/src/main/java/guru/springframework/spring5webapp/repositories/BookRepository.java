package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kmartin62
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
