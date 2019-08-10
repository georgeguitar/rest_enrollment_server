package bo.edu.uasb.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Enrollment.
 */
@Entity
@Table(name = "enrollment")
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "year", length = 60, nullable = false)
    private String year;

    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "period", length = 60, nullable = false)
    private String period;

    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "level", length = 60, nullable = false)
    private String level;

    @NotNull
    @Column(name = "date_enrollment", nullable = false)
    private LocalDate dateEnrollment;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("enrollments")
    private Student student;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("enrollments")
    private Program program;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public Enrollment year(String year) {
        this.year = year;
        return this;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPeriod() {
        return period;
    }

    public Enrollment period(String period) {
        this.period = period;
        return this;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getLevel() {
        return level;
    }

    public Enrollment level(String level) {
        this.level = level;
        return this;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public LocalDate getDateEnrollment() {
        return dateEnrollment;
    }

    public Enrollment dateEnrollment(LocalDate dateEnrollment) {
        this.dateEnrollment = dateEnrollment;
        return this;
    }

    public void setDateEnrollment(LocalDate dateEnrollment) {
        this.dateEnrollment = dateEnrollment;
    }

    public Student getStudent() {
        return student;
    }

    public Enrollment student(Student student) {
        this.student = student;
        return this;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public Enrollment program(Program program) {
        this.program = program;
        return this;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Enrollment)) {
            return false;
        }
        return id != null && id.equals(((Enrollment) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
            "id=" + getId() +
            ", year='" + getYear() + "'" +
            ", period='" + getPeriod() + "'" +
            ", level='" + getLevel() + "'" +
            ", dateEnrollment='" + getDateEnrollment() + "'" +
            "}";
    }
}
