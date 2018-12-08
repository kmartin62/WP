package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kmartin62
 */
public interface AuthorRepository extends CrudRepository<Author, Long> { //Repository t.e baza. Nasleduva od
    //CrudRepository za da gi nasledi osnovnite atributi za rabota so baza
//    public interface CrudRepository <T, ID> extends org.springframework.data.repository.Repository<T,ID> {
//        <S extends T> S save(S s);
//
//        <S extends T> java.lang.Iterable<S> saveAll(java.lang.Iterable<S> iterable);
//
//        java.util.Optional<T> findById(ID id);
//
//        boolean existsById(ID id);
//
//        java.lang.Iterable<T> findAll();
//
//        java.lang.Iterable<T> findAllById(java.lang.Iterable<ID> iterable);
//
//        long count();
//
//        void deleteById(ID id);
//
//        void delete(T t);
//
//        void deleteAll(java.lang.Iterable<? extends T> iterable);
//
//        void deleteAll();
//    }
}
