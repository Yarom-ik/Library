package by.yarom.library;


import by.yarom.library.Entity.CatalogBooks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import javax.persistence.criteria.CriteriaBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Main {

    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        System.out.println("date: " + dateFormat.format( new Date() ) );

//        CatalogBooks catalogBooks = new CatalogBooks();
//        catalogBooks.setName("literetyra");
//        catalogBooks.setAuthor("pushkin");
//        catalogBooks.setYear(1993);
//        catalogBooks.setInvNum(111);
//
//        CatalogBooks catalogBooks2 = new CatalogBooks();
//        catalogBooks2.setName("literetyra2");
//        catalogBooks2.setAuthor("pushkin2");
//        catalogBooks2.setYear(1993);
//        catalogBooks2.setInvNum(111);
//
//         Map<CatalogBooks, Integer> booksBacket = new LinkedHashMap<>();
//
//
//        booksBacket.put(catalogBooks, 1);
//        booksBacket.put(catalogBooks2, 1);
//
//
//
//
//        System.out.println(booksBacket);
//
//
//        Iterator<Map.Entry<CatalogBooks,Integer>> iter = booksBacket.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry<CatalogBooks,Integer> entry = iter.next();
//            if(catalogBooks.equals(entry.getKey())){
//                iter.remove();
//            }
//        }
//        System.out.println(booksBacket);

//        SessionFactory sessionFactory =
//                new Configuration().configure().buildSessionFactory();
//
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = null;
//
//           transaction =  session.beginTransaction();
//
//           User user = new User();
//           user.setAge(111);
//           user.setFirstname("III");
//           user.setLastname("Yaromik");
//
//           session.save(user);
//
//        Role role = new Role();
//        role.setTitle("Password");
//    role.setUser(user);
//
//        session.save(role);

//        Query<Role> query = session.createQuery("from Role where id = 2" );
//
//        Role role = query.getSingleResult();
//        //Role role = (Role) query.list().get(0);
//
//        role.setTitle("Admin");
//        session.update(role);



              //Query query = session.createQuery("from Role where title ='admin'");

//               List<Role> user1 = query.getResultList();
//               for (Role empl : user1) {
//                   System.out.println(empl.getTitle()+" "+empl.getUser().getFirstname());
//                   //System.out.println("Address from employee entity: " + empl.getAddress().getAdId());
//
//               }


//               transaction.commit();
//
//            session.close();
//            sessionFactory.close();
//




//        for(Object []obj: products) {
//            System.out.println(obj[0].toString());
//        }
   }
//        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
//        Session session = sessionFactory.openSession();
//        List<Currency> products = null;
//
//        try {
//            session.beginTransaction();
//
//                      Query query = session.createQuery("FROM Currency");
//            products = query.list();
//
//
//            session.getTransaction().commit();
//        } catch(Exception e) {
//            session.getTransaction().rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//            sessionFactory.close();
//        }
//
//        for(Currency product: products) {
//            System.out.println(product.getFullName());
//        }
//
//    }
}