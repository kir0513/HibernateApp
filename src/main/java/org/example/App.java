package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //подключаем конфигурацию из файла hibernate.properties используя класс Configuration и передаем ему наш класс
        // который является сущностью (Entity)
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        //Сщздаем SessionFactory
        //SessionFactory sessionFactory = configuration.buildSessionFactory();
        //получаем сессию для работы с hibernate
       // Session session = sessionFactory.getCurrentSession();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            System.out.println(person.getName());
            System.out.println(person.getAge());
            session.getTransaction().commit();
        }// finally {
        //    sessionFactory.close();
       // }
        //
    }
}
