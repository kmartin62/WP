package test1.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import test1.demo.model.StudyProgram;

/**
 * Created by @kmartin62
 */
public interface StudyProgramRepository extends CrudRepository<StudyProgram, Long> {
}
