import jakarta.persistence.*;


@Entity
@Table(name = "gb20240321.course")
public class Course {
    @Id
    @GeneratedValue(strategy = CenerationType.IDENTITY)
    private int idCourse;
    @Column(name = "название")
    private String name;
    @Column(name = "преподаватель")
    private String nameOfTeacher;
    @Column(name = "колличество часов")
    private int countHours;
}
