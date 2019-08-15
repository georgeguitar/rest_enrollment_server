package bo.edu.uasb.service.impl;

import bo.edu.uasb.service.EnrollmentService;
import bo.edu.uasb.domain.Enrollment;
import bo.edu.uasb.repository.EnrollmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Enrollment}.
 */
@Service
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {

    private final Logger log = LoggerFactory.getLogger(EnrollmentServiceImpl.class);

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    /**
     * Save a enrollment.
     *
     * @param enrollment the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Enrollment save(Enrollment enrollment) {
        log.debug("Request to save Enrollment : {}", enrollment);
        return enrollmentRepository.save(enrollment);
    }

    /**
     * Get all the enrollments.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Enrollment> findAll(Pageable pageable) {
        log.debug("Request to get all Enrollments");
        return enrollmentRepository.findAll(pageable);
    }


    /**
     * Get one enrollment by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Enrollment> findOne(Long id) {
        log.debug("Request to get Enrollment : {}", id);
        return enrollmentRepository.findById(id);
    }

    /**
     * Delete the enrollment by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Enrollment : {}", id);
        enrollmentRepository.deleteById(id);
    }
    
    /**
     * Save a enrollment.
     *
     * @param enrollment the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Enrollment partialSave(Enrollment partialEnrollment) {
        log.debug("Request to save Enrollment : {}", partialEnrollment);
        
        Optional<Enrollment> enrollment = enrollmentRepository.findById(partialEnrollment.getId());
        if (partialEnrollment.getYear() == null) {
        	partialEnrollment.setYear(enrollment.get().getYear());
        }
        if (partialEnrollment.getPeriod() == null) {
        	partialEnrollment.setPeriod(enrollment.get().getPeriod());
        }
        if (partialEnrollment.getLevel() == null) {
        	partialEnrollment.setLevel(enrollment.get().getLevel());
        }
        if (partialEnrollment.getDateEnrollment() == null) {
        	partialEnrollment.setDateEnrollment(enrollment.get().getDateEnrollment());
        }
        if (partialEnrollment.getId() == null) {
        	partialEnrollment.setId(enrollment.get().getId());
        }
        if (partialEnrollment.getProgram() == null) {
        	partialEnrollment.setProgram(enrollment.get().getProgram());
        }
        if (partialEnrollment.getStudent() == null) {
        	partialEnrollment.setStudent(enrollment.get().getStudent());
        }
        
        return enrollmentRepository.save(partialEnrollment);
    }
}
