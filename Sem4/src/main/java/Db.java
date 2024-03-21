import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Db {
    private static final String URL = "jdbc:mysql://db4free.net:3306";
    private static final String USER = "gb20240321root";
    private static final String PASSWORD = "gb20240321pass";

    public static void con() {
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure()
//                .build();
//        SessionFactory sessionFactory = new MetadataSources(registry)
//                .buildMetadata().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        Course course1 = new Course("Java", "Ivanov", 1000);
//
//        session.beginTransaction();
//        session.save(course1);
//        session.getTransaction().commit();
//        session.close();
        Connector connector = new Connector();
        //�������
        insertCourses(connector, generateListOfCourses());

        //������� ���� � ����������
        getCourses(connector).stream().forEach(System.out::println);

        //������� ������ ��������
        System.out.println(getCourseById(connector, 1));

        //�����������
        updateCourses(connector, 1, new Course("Java", "Ivanov", 1000));

        //��������

    }
    public static List<Course> generateListOfCourses(){
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Java", "Ivanov", 1000));
        courses.add(new Course("MySQL", "Petrov", 100));
        courses.add(new Course("Hibernate", "Sidorov", 100));
        courses.add(new Course("Docker", "Pushkin", 100));
        return courses;
    }

    public static void insertCourses(Connector connector, List<Course> courses){
        Session session = connector.getSesion();
        session.getTransaction();
        for(Course course: courses){
            session.save(course);
        }
        session.beginTransaction().commit();
        session.close();
    }

    public static List<Course> getCourses(Connector connector){
        List<Course> courses = null;
        try(Session session = connector.getSesion()){
            courses = session.createQuery("FROM course", Course.class).getResultList();
        } catch (Exception e){
            System.out.println("--- getCourses ---");
            e.printStackTrace();
        }
        return courses;
    }

    public static void updateCourses(Connector connector, int id, Course courseNew){
        Course courseOld = getCourseById(connector, id);
        try(Session session = connector.getSesion()){
            courseOld.setTitle(courseNew.getTitle());
            courseOld.setNameOfTeacher(courseOld.getNameOfTeacher());
            courseOld.setDuration(courseNew.getDuration());

        } catch (Exception e){
            System.out.println("--- updateCourses ---");
            e.printStackTrace();
        }
    }

    public static Course getCourseById (Connector connector, int id){
        try(Session session = connector.getSesion()){
            String hql = "FROM course where id = :id";
            Query<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("id", id);
            Course course = query.getSingleResult();
            return course;
        } catch (Exception e){
            System.out.println("--- getCourseById ---");
            e.printStackTrace();
        }
        return null;
    }

}
