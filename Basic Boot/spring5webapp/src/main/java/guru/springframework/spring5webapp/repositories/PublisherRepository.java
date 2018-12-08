package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kmartin62
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
