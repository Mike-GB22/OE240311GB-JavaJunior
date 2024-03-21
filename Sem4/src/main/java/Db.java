import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class Db {
    private static final String URL = "jdbc:mysql://db4free.net:3306";
    private static final String USER = "gb20240321root";
    private static final String PASSWORD = "gb20240321pass";

    public static void con(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Course course1 = new Course("Java", "Ivanov", 1000);


    }
}
