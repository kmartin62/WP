package com.martin.studentsapi.studentsapi.repositories;

import com.martin.studentsapi.studentsapi.models.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @kmartin62
 */
public interface StudentRepository extends CrudRepository<Student, String> {
}
