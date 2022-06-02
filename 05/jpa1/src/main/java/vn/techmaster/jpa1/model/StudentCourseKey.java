package vn.techmaster.jpa1.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;


@Embeddable
@Data
public class StudentCourseKey implements Serializable {

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourseKey that = (StudentCourseKey) o;

        if (!studentId.equals(that.studentId)) return false;
        return courseId.equals(that.courseId);
    }

    @Override
    public int hashCode() {
        int result = studentId.hashCode();
        result = 31 * result + courseId.hashCode();
        return result;
    }
}
