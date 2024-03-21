import jakarta.persistence.*;


@Entity
@Table(name = "gb20240321.course")
public class Course {
    @Id
    @GeneratedValue(strategy = CenerationType.IDENTITY)
    private int id;
    @Column(name = "название")
    private String title;
    @Column(name = "преподаватель")
    private String nameOfTeacher;
    @Column(name = "колличество часов")
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
