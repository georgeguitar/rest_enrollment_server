package bo.edu.uasb.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import bo.edu.uasb.domain.enumeration.Semesters;

/**
 * A Program.
 */
@Entity
@Table(name = "program")
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "semesters", nullable = false)
    private Semesters semesters;

    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "title", length = 60, nullable = false)
    private String title;

    @NotNull
    @Min(value = 1)
    @Max(value = 20)
    @Column(name = "credits", nullable = false)
    private Integer credits;

    @OneToMany(mappedBy = "program")
    private Set<Enrollment> enrollments = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Program name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Semesters getSemesters() {
        return semesters;
    }

    public Program semesters(Semesters semesters) {
        this.semesters = semesters;
        return this;
    }

    public void setSemesters(Semesters semesters) {
        this.semesters = semesters;
    }

    public String getTitle() {
        return title;
    }

    public Program title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredits() {
        return credits;
    }

    public Program credits(Integer credits) {
        this.credits = credits;
        return this;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public Program enrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
        return this;
    }

    public Program addEnrollment(Enrollment enrollment) {
        this.enrollments.add(enrollment);
        enrollment.setProgram(this);
        return this;
    }

    public Program removeEnrollment(Enrollment enrollment) {
        this.enrollments.remove(enrollment);
        enrollment.setProgram(null);
        return this;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Program)) {
            return false;
        }
        return id != null && id.equals(((Program) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Program{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", semesters='" + getSemesters() + "'" +
            ", title='" + getTitle() + "'" +
            ", credits=" + getCredits() +
            "}";
    }
}
