package org.example;

import org.example.confi.FactoryConfiguration;
import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
//        Person person=session.get(Person.class ,1);
//        System.out.println(person.getId());
//        System.out.println(person.getIdCard());

//-------------------------------all person---------------------------
       /* NativeQuery query = session.createNativeQuery("select * from person");
        query.addEntity(Person.class);
        List<Person> list = query.list();
        for (Person person : list) {
            System.out.println(person);
        }

        */

        NativeQuery query=session.createNativeQuery("select * from Person where name=?1");
        query.addEntity(Person.class);
        query.setParameter(1,"Shehan");
        Person person=(Person) query.uniqueResult();
        System.out.println(person);

//        Query query=session.createQuery("select id,name from Person where id=?1");
//        query.setParameter(1,1);
//        Person person=(Person) query.uniqueResult();
//        System.out.println(person.getId()+","+person.getName());

//-------------------------------insert--------------------------------
//        NativeQuery  query = session.createNativeQuery("insert into Person (id,address,name) values(?1,?2,?3)");
//        query.setParameter(1,6);
//        query.setParameter(2,"Kalutara");
//        query.setParameter(3,"Devid");
//        query.executeUpdate();



//---------------------------update-----------------------------------
       /* NativeQuery query1 = session.createNativeQuery("update Person set address=?1 where id = ?2");
        query1.setParameter(1,"Kandy");
        query1.setParameter(2,4);
        query1.executeUpdate();

        */

//---------------------------delete----------------------------------
       /* Query query3=session.createQuery("delete from Person where id=:id");
        query3.setParameter("id",2);
        query3.executeUpdate();

        */

//-----------------------join query----------------------------------
      /* NativeQuery query5=session.createNativeQuery("select p.id,p.name from IdCard ic inner join Person p on ic.id = p.id");
        List<Object[]> list=query5.list();
        for (Object[] arr : list) {
            int id = (int) arr[0];
            String personName = (String) arr[1];
            System.out.println(personName + ", " + id);
        }

       */

//-------------------------order by---------------------------------
       /* NativeQuery query6=session.createNativeQuery("from Person p order by p.id desc");
        List<Person> perlist=query6.list();
        for (Person person:perlist){
            System.out.println(person.getId()+","+person.getAddress()+","+person.getName());
        }

        */


        transaction.commit();
        session.close();
    }
}