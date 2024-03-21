import org.hibernate.Session;

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
        insertCourses(connector);
        getCourses(connector).stream().forEach(System.out::println);

    }

    public static void insertCourses(Connector connector){
        Session session = connector.getSesion();
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Java", "Ivanov", 1000));
        courses.add(new Course("MySQL", "Petrov", 100));
        courses.add(new Course("Hibernate", "Sidorov", 100));
        courses.add(new Course("Docker", "Pushkin", 100));

        session.getTransaction();
        for(Course course: courses){
            session.save(course);
        }
        session.beginTransaction().commit();
        session.close();
    }

    public static List<Course> getCourses(Connector connector){
        List<Course> courses;
        try(Session session = connector.getSesion()){
            courses = session.createQuery("FROM course", Course.class).getResultList();
        } catch (Exception e){
            System.out.println("--- getCourses ---");
            e.printStackTrace();
        }
        return courses;
    }
}
