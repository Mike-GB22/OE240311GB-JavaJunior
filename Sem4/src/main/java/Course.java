import jakarta.persistence.*;


@Entity
@Table(name = "gb20240321.course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", nameOfTeacher='" + nameOfTeacher + '\'' +
                ", duration=" + duration +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNameOfTeacher(String nameOfTeacher) {
        this.nameOfTeacher = nameOfTeacher;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getNameOfTeacher() {
        return nameOfTeacher;
    }

    public int getDuration() {
        return duration;
    }
}
