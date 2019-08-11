package bo.edu.uasb.web.rest;

import bo.edu.uasb.domain.Enrollment;
import bo.edu.uasb.service.EnrollmentService;
import bo.edu.uasb.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link bo.edu.uasb.domain.Enrollment}.
 */
@RestController
@RequestMapping("/api")
public class EnrollmentResource {

    private final Logger log = LoggerFactory.getLogger(EnrollmentResource.class);

    private static final String ENTITY_NAME = "enrollment";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EnrollmentService enrollmentService;

    public EnrollmentResource(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    /**
     * {@code POST  /enrollments} : Create a new enrollment.
     *
     * @param enrollment the enrollment to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new enrollment, or with status {@code 400 (Bad Request)} if the enrollment has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/enrollments")
    public ResponseEntity<Enrollment> createEnrollment(@Valid @RequestBody Enrollment enrollment) throws URISyntaxException {
        log.debug("REST request to save Enrollment : {}", enrollment);
        if (enrollment.getId() != null) {
            throw new BadRequestAlertException("A new enrollment cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Enrollment result = enrollmentService.save(enrollment);
        return ResponseEntity.created(new URI("/api/enrollments/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /enrollments} : Updates an existing enrollment.
     *
     * @param enrollment the enrollment to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated enrollment,
     * or with status {@code 400 (Bad Request)} if the enrollment is not valid,
     * or with status {@code 500 (Internal Server Error)} if the enrollment couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/enrollments/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @Valid @RequestBody Enrollment enrollment) throws URISyntaxException {
        log.debug("REST request to update Enrollment : {}", enrollment);
        if (id == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        enrollment.setId(id);
        Enrollment result = enrollmentService.save(enrollment);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, enrollment.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /enrollments} : get all the enrollments.
     *
     * @param pageable the pagination information.
     * @param queryParams a {@link MultiValueMap} query parameters.
     * @param uriBuilder a {@link UriComponentsBuilder} URI builder.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of enrollments in body.
     */
    @GetMapping("/enrollments")
    public ResponseEntity<List<Enrollment>> getAllEnrollments(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get a page of Enrollments");
        Page<Enrollment> page = enrollmentService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /enrollments/:id} : get the "id" enrollment.
     *
     * @param id the id of the enrollment to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the enrollment, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/enrollments/{id}")
    public ResponseEntity<Enrollment> getEnrollment(@PathVariable Long id) {
        log.debug("REST request to get Enrollment : {}", id);
        Optional<Enrollment> enrollment = enrollmentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(enrollment);
    }

    /**
     * {@code DELETE  /enrollments/:id} : delete the "id" enrollment.
     *
     * @param id the id of the enrollment to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/enrollments/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        log.debug("REST request to delete Enrollment : {}", id);
        enrollmentService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
