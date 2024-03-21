import jakarta.persistence.*;


@Entity
@Table(name = "gb20240321.course")
public class Course {
    @Id
    @GeneratedValue(strategy = CenerationType.IDENTITY)
    private int id;
    @Column(name = "��������")
    private String title;
    @Column(name = "�������������")
    private String nameOfTeacher;
    @Column(name = "����������� �����")
    private int duration;

    public Course(String title, String nameOfTeacher, int duration){
        this.title = title;
        this.nameOfTeacher = nameOfTeacher;
        this.duration = duration;
    }

    public Course(){
        super();
    }
}
