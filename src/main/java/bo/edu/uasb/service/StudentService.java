package bo.edu.uasb.service;

import bo.edu.uasb.domain.Student;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Student}.
 */
public interface StudentService {

    /**
     * Save a student.
     *
     * @param student the entity to save.
     * @return the persisted entity.
     */
    Student save(Student student);

    /**
     * Get all the students.
     *
     * @return the list of entities.
     */
    List<Student> findAll();


    /**
     * Get the "id" student.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Student> findOne(Long id);

    /**
     * Delete the "id" student.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    /**
     * Partial save a student.
     *
     * @param student the entity to save.
     * @return the persisted entity.
     */
    Student partialSave(Student student);
}
