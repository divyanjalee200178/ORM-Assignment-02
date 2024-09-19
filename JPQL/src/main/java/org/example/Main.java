package org.example;

import org.example.confi.FactoryConfiguration;
import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//-----------------insert----------------------------
       /* Query query=session.createQuery("insert into Person(id,address,name) values (?1,?2,?3)");
        query.setParameter(1,5);
        query.setParameter(2,"Galle");
        query.setParameter(3,"Shehan");
        query.executeUpdate();

        */


//-----------------update----------------------------
       //can't apply


//-----------------join queries----------------------------
       /* Query query=session.createQuery("select distinct p from Person p inner join p.idCard ic ");
        List<Person> list=query.list();
        System.out.println(list);

        */

//-----------------join queries with where clause----------------------------
        Query query=session.createQuery("select distinct p from Person p inner join p.idCard ic where ic.id=1");
        List<Person> list=query.list();
        for (Person person:list){
            System.out.println(person.getId()+","+person.getAddress()+","+person.getName());
        }


        transaction.commit();
        session.close();
    }
}