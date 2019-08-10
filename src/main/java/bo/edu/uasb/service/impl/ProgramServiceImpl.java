package bo.edu.uasb.service.impl;

import bo.edu.uasb.service.ProgramService;
import bo.edu.uasb.domain.Program;
import bo.edu.uasb.repository.ProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Program}.
 */
@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {

    private final Logger log = LoggerFactory.getLogger(ProgramServiceImpl.class);

    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    /**
     * Save a program.
     *
     * @param program the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Program save(Program program) {
        log.debug("Request to save Program : {}", program);
        return programRepository.save(program);
    }

    /**
     * Get all the programs.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Program> findAll() {
        log.debug("Request to get all Programs");
        return programRepository.findAll();
    }


    /**
     * Get one program by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Program> findOne(Long id) {
        log.debug("Request to get Program : {}", id);
        return programRepository.findById(id);
    }

    /**
     * Delete the program by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Program : {}", id);
        programRepository.deleteById(id);
    }
}
