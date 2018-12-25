package test1.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import test1.demo.model.Student;

/**
 * Created by @kmartin62
 */
public interface StudentRepository extends CrudRepository<Student, String> {
//    void delete(Optional<Student> byId);
}
