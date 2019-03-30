package by.yarom.library;


import by.yarom.library.Entity.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
//        System.out.println("date: " + dateFormat.format( new Date() ) );

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

//        Transaction transaction = null;
//
//           transaction =  session.beginTransaction();



//        List<Reader> readerList = session.createQuery("select r from Reader r join fetch r.orders as rr where rr.finished = false and r.active = true group by r")
//                .list();
//
//        List query = session.createQuery(" select r from Reader r join fetch r.orders as rr where rr.finished = false and r.active = true group by r ")
//                .list();
//
////        for (Reader readerLis : readerList) {
////            System.out.println(readerLis);
////        }
//
//        System.out.println(query.size());
//        for (int i=0 ; i<readerList.size(); i++){
//            System.out.println(readerList.get(i));
//        }


        File file = new File(new File("a.java").getAbsolutePath());
        System.out.println(file);

        try {
            Process runtimeProcess = Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","mysqldump --host=localhost --port=3306 --user=root --password=root --host=localhost --routines library > D:/file_name.sql"});

            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Failure!!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {

        /*NOTE: Getting path to the Jar file being executed*/
        /*NOTE: YourImplementingClass-> replace with the class executing the code*/
            CodeSource codeSource = Main.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();


        /*NOTE: Creating Database Constraints*/
            String dbName = "library";
            String dbUser = "root";
            String dbPass = "root";

        /*NOTE: Creating Path Constraints for folder saving*/
        /*NOTE: Here the backup folder is created for saving inside it*/
            String folderPath = jarDir + "\\backup";

        /*NOTE: Creating Folder if it does not exist*/
            File f1 = new File(folderPath);
            f1.mkdir();

        /*NOTE: Creating Path Constraints for backup saving*/
        /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";

        /*NOTE: Used to create a cmd command*/
//            String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " --database " + dbName + " -r " + savePath;

        /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","mysqldump --host=localhost --port=3306 --user=root --password=root --host=localhost --routines library > "+ savePath});
            int processComplete = runtimeProcess.waitFor();

        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("Backup Complete");
            } else {
                System.out.println("Backup Failure");
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
        }
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