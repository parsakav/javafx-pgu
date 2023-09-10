package com.parsakav.pgukala;

import com.parsakav.pgukala.entity.User;
import com.parsakav.pgukala.repository.UserRepository;
import com.parsakav.pgukala.repository.UserRepositoryImpl;
import com.parsakav.pgukala.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import static java.lang.System.out;

public class UserRepositoryTest {

    private static SessionFactory sessionFactory;
    private UserRepository repository = new UserRepositoryImpl();
    private Session session;

    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
        out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        out.println("SessionFactory destroyed");
    }

    @Test
    public void checkUserRepository() {

        out.println("Check save user");
        User product = new User("admin","admin","09107105933");
       int id= repository.save(product);

        Assertions.assertTrue(id > 0);
        out.println("Check exist user");

        Assertions.assertTrue(repository.exist("admin"));
        out.println("Check find user");

        Assertions.assertNotNull(repository.find("admin"));
        out.println("Check remove user");
        repository.remove("admin");
       Assertions.assertNull(repository.find("admin"));

    }


    @BeforeEach
    public void openSession() {
        session = sessionFactory.getCurrentSession();
        out.println("Session created");
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        out.println("Session closed\n");
    }
}
