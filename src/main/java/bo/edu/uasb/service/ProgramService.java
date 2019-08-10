package bo.edu.uasb.service;

import bo.edu.uasb.domain.Program;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Program}.
 */
public interface ProgramService {

    /**
     * Save a program.
     *
     * @param program the entity to save.
     * @return the persisted entity.
     */
    Program save(Program program);

    /**
     * Get all the programs.
     *
     * @return the list of entities.
     */
    List<Program> findAll();


    /**
     * Get the "id" program.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Program> findOne(Long id);

    /**
     * Delete the "id" program.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
