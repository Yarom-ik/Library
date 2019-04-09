package by.yarom.library;


import by.yarom.library.Config.HibernateConfig;
import by.yarom.library.Entity.Give;
import by.yarom.library.Entity.Reader;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import javax.imageio.spi.ServiceRegistry;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        System.out.println("date: " + dateFormat.format( new Date() ) );

        SessionFactory sessionFactory =
                new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        int mount = 3;
        int year = 2019;

        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
        System.out.println("текущий месяц "+(calendar.get(Calendar.MONTH)+1));

        String startedDate=year+"-"+mount+"-01 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date startDate= format.parse(startedDate);
        System.out.println("startDate "+startDate);

        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.set(Calendar.YEAR, year);
        calendarEnd.set(Calendar.MONTH, mount-1);
        String endedDate=year+"-"+mount+"-"+calendarEnd.getActualMaximum(Calendar.DAY_OF_MONTH)+" 23:59:59";
        SimpleDateFormat formatEnd = new SimpleDateFormat();
        formatEnd.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date endDate= formatEnd.parse(endedDate);
        System.out.println("EndDate "+endDate);





        long c = (Long) session.createQuery("select count (*) from Give where order.data between :startDate and :endDate")
                .setParameter("startDate",  startDate)
                .setParameter("endDate", endDate)
                .uniqueResult();

        System.out.println("- " + c);

//               List<Role> user1 = query.getResultList();
//               for (Role empl : user1) {
//                   System.out.println(empl.getTitle()+" "+empl.getUser().getFirstname());
//                   //System.out.println("Address from employee entity: " + empl.getAddress().getAdId());
//
//               }


//               transaction.commit();
//
            session.close();
            sessionFactory.close();
//




//        for(Object []obj: products) {
//            System.out.println(obj[0].toString());
//        }
//   }
//        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
//        Session session = sessionFactory.openSession();
//        List<> products = null;
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
}}