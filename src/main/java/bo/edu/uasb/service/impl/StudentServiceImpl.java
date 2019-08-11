package bo.edu.uasb.service.impl;

import bo.edu.uasb.service.StudentService;
import bo.edu.uasb.domain.Student;
import bo.edu.uasb.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Student}.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Save a student.
     *
     * @param student the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Student save(Student student) {
        log.debug("Request to save Student : {}", student);
        return studentRepository.save(student);
    }

    /**
     * Get all the students.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        log.debug("Request to get all Students");
        return studentRepository.findAll();
    }


    /**
     * Get one student by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findOne(Long id) {
        log.debug("Request to get Student : {}", id);
        return studentRepository.findById(id);
    }

    /**
     * Delete the student by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Student : {}", id);
        studentRepository.deleteById(id);
    }
    
    /**
     * Save a student.
     *
     * @param student the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Student partialSave(Student partialStudent) {
        log.debug("Request to save Student : {}", partialStudent);
        Optional<Student> student = studentRepository.findById(partialStudent.getId());

        if (partialStudent.getName() == null) {
        	partialStudent.setName(student.get().getName());
        }
        if (partialStudent.getSurname() == null) {
        	partialStudent.setSurname(student.get().getSurname());
        }
        if (partialStudent.getAddress() == null) {
        	partialStudent.setAddress(student.get().getAddress());
        }
        if (partialStudent.getTelephone() == null) {
        	partialStudent.setTelephone(student.get().getTelephone());
        }
        
        return studentRepository.save(partialStudent);
    }
}
