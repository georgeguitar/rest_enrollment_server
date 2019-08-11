package bo.edu.uasb.service;

import bo.edu.uasb.domain.Enrollment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Enrollment}.
 */
public interface EnrollmentService {

    /**
     * Save a enrollment.
     *
     * @param enrollment the entity to save.
     * @return the persisted entity.
     */
    Enrollment save(Enrollment enrollment);

    /**
     * Get all the enrollments.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Enrollment> findAll(Pageable pageable);


    /**
     * Get the "id" enrollment.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Enrollment> findOne(Long id);

    /**
     * Delete the "id" enrollment.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    /**
     * Partial save a enrollment.
     *
     * @param enrollment the entity to save.
     * @return the persisted entity.
     */
    Enrollment partialSave(Enrollment enrollment);
}
