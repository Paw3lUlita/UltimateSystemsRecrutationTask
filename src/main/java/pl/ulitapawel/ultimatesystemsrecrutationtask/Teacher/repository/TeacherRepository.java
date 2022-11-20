package pl.ulitapawel.ultimatesystemsrecrutationtask.Teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.ulitapawel.ultimatesystemsrecrutationtask.Student.model.Student;
import pl.ulitapawel.ultimatesystemsrecrutationtask.Teacher.model.Teacher;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByNameContains(String name);

    Teacher findBySurnameContains(String Surname);

    Teacher findByNameContainsAndSurnameContains(String name, String Surname);

    @Query("SELECT s FROM Student s JOIN Teacher t WHERE t.id = :teacherId")
    List<Student> findAllStudentsForTeacher(long teacherId);

}