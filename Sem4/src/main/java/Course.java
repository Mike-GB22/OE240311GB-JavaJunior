import jakarta.persistence.*;


@Entity
@Table(name = "gb20240321.course")
public class Course {
    @Id
    @GeneratedValue(strategy = CenerationType.IDENTITY)
    private int idCourse;
    @Column(name = "��������")
    private String name;
    @Column(name = "�������������")
    private String nameOfTeacher;
    @Column(name = "����������� �����")
    private int countHours;
}
