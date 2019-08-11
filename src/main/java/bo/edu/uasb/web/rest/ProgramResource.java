package bo.edu.uasb.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.uasb.domain.Program;
import bo.edu.uasb.service.ProgramService;
import bo.edu.uasb.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link bo.edu.uasb.domain.Program}.
 */
@RestController
@RequestMapping("/api")
public class ProgramResource {

    private final Logger log = LoggerFactory.getLogger(ProgramResource.class);

    private static final String ENTITY_NAME = "program";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProgramService programService;

    public ProgramResource(ProgramService programService) {
        this.programService = programService;
    }

    /**
     * {@code POST  /programs} : Create a new program.
     *
     * @param program the program to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new program, or with status {@code 400 (Bad Request)} if the program has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/programs")
    public ResponseEntity<Program> createProgram(@Valid @RequestBody Program program) throws URISyntaxException {
        log.debug("REST request to save Program : {}", program);
        if (program.getId() != null) {
            throw new BadRequestAlertException("A new program cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Program result = programService.save(program);
        return ResponseEntity.created(new URI("/api/programs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /programs/:id} : Updates an existing program.
     *
     * @param program the program to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated program,
     * or with status {@code 400 (Bad Request)} if the program is not valid,
     * or with status {@code 500 (Internal Server Error)} if the program couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/programs/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable Long id, @Valid @RequestBody Program program) throws URISyntaxException {
        log.debug("REST request to update Program : {}", program);
        if (id == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        program.setId(id); 
        Program result = programService.save(program);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, program.getId().toString()))
            .body(result);
    }

    
    /**
     * {@code Patch  /programs/:id} : Updates an existing program.
     *
     * @param program the program to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated program,
     * or with status {@code 400 (Bad Request)} if the program is not valid,
     * or with status {@code 500 (Internal Server Error)} if the program couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping("/programs/{id}")
    public ResponseEntity<Program> partialUpdateProgram(@PathVariable Long id, @Valid @RequestBody Program program) throws URISyntaxException {
        log.debug("REST request to update Program : {}", program);
        if (id == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        program.setId(id); 
        Program result = programService.partialSave(program);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, program.getId().toString()))
            .body(result);
    }    
    
    /**
     * {@code GET  /programs} : get all the programs.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of programs in body.
     */
    @GetMapping("/programs")
    public List<Program> getAllPrograms() {
        log.debug("REST request to get all Programs");
        return programService.findAll();
    }

    /**
     * {@code GET  /programs/:id} : get the "id" program.
     *
     * @param id the id of the program to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the program, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/programs/{id}")
    public ResponseEntity<Program> getProgram(@PathVariable Long id) {
        log.debug("REST request to get Program : {}", id);
        Optional<Program> program = programService.findOne(id);
        return ResponseUtil.wrapOrNotFound(program);
    }

    /**
     * {@code DELETE  /programs/:id} : delete the "id" program.
     *
     * @param id the id of the program to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/programs/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long id) {
        log.debug("REST request to delete Program : {}", id);
        programService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
