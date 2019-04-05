//package by.yarom.library;
//
//
//import by.yarom.library.Entity.Give;
//import by.yarom.library.Entity.Reader;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
//
//
//import javax.swing.*;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URISyntaxException;
//import java.security.CodeSource;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//
//public class Main {
//
//    public static void main(String[] args) {
//
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
////        System.out.println("date: " + dateFormat.format( new Date() ) );
//
////        CatalogBooks catalogBooks = new CatalogBooks();
////        catalogBooks.setName("literetyra");
////        catalogBooks.setAuthor("pushkin");
////        catalogBooks.setYear(1993);
////        catalogBooks.setInvNum(111);
////
////        CatalogBooks catalogBooks2 = new CatalogBooks();
////        catalogBooks2.setName("literetyra2");
////        catalogBooks2.setAuthor("pushkin2");
////        catalogBooks2.setYear(1993);
////        catalogBooks2.setInvNum(111);
////
////         Map<CatalogBooks, Integer> booksBacket = new LinkedHashMap<>();
////
////
////        booksBacket.put(catalogBooks, 1);
////        booksBacket.put(catalogBooks2, 1);
////
////
////
////
////        System.out.println(booksBacket);
////
////
////        Iterator<Map.Entry<CatalogBooks,Integer>> iter = booksBacket.entrySet().iterator();
////        while (iter.hasNext()) {
////            Map.Entry<CatalogBooks,Integer> entry = iter.next();
////            if(catalogBooks.equals(entry.getKey())){
////                iter.remove();
////            }
////        }
////        System.out.println(booksBacket);
//
//
////        List<Reader> readerList = session.createQuery("select r from Reader r join fetch r.orders as rr where rr.finished = false and r.active = true group by r")
////                .list();
////
////        List query = session.createQuery(" select r from Reader r join fetch r.orders as rr where rr.finished = false and r.active = true group by r ")
////                .list();
////
//////        for (Reader readerLis : readerList) {
//////            System.out.println(readerLis);
//////        }
////
////        System.out.println(query.size());
////        for (int i=0 ; i<readerList.size(); i++){
////            System.out.println(readerList.get(i));
////        }
//
//
//
//        //Query query = session.createQuery("from Role where title ='admin'");
//
////               List<Role> user1 = query.getResultList();
////               for (Role empl : user1) {
////                   System.out.println(empl.getTitle()+" "+empl.getUser().getFirstname());
////                   //System.out.println("Address from employee entity: " + empl.getAddress().getAdId());
////
////               }
//
//
////               transaction.commit();
////
////            session.close();
////            sessionFactory.close();
////
//
//
//
//
////        for(Object []obj: products) {
////            System.out.println(obj[0].toString());
////        }
////   }
////        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
////        Session session = sessionFactory.openSession();
////        List<> products = null;
////
////        try {
////            session.beginTransaction();
////
////                      Query query = session.createQuery("FROM Currency");
////            products = query.list();
////
////
////            session.getTransaction().commit();
////        } catch(Exception e) {
////            session.getTransaction().rollback();
////            e.printStackTrace();
////        } finally {
////            session.close();
////            sessionFactory.close();
////        }
////
////        for(Currency product: products) {
////            System.out.println(product.getFullName());
////        }
////
////    }
//}}