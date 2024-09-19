package org.example.confi;



import org.example.entity.IdCard;
import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    //public Session getSession;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(IdCard.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration==null)?factoryConfiguration= new FactoryConfiguration():factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
