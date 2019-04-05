package by.yarom.library.backup;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;

import java.io.IOException;

public class Backup {

    final static Logger logger = Logger.getLogger(Backup.class);

    public static void backupSQL(String fileDirectory) throws InterruptedException, IOException {

            String dbName = "library";
            String dbUser = "root";
            String dbPass = "root";

            Process runtimeProcess = Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","mysqldump --host=localhost --port=3306 --user="+dbUser+" --password="+dbPass+" --host=localhost --routines "+dbName+" > "+fileDirectory});
            int processComplete = runtimeProcess.waitFor();

        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("statusBackup Восстановление завершено успешно");
            } else {
                logger.error("Ошибка выполнения запроса на резервное копирование ");
                throw new InterruptedException("Ошибка выполнения запроса на резервное копирование");
            }
    }

    public static void backupRestoneSQL(Model model, String fileDirectory) throws IOException, InterruptedException {

            String dbName = "library";
            String dbUser = "root";
            String dbPass = "root";

            Process runtimeProcess = Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","mysql --user="+dbUser+" --password="+dbPass+" "+dbName+" < "+fileDirectory});
            int processComplete = runtimeProcess.waitFor();

        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                model.addAttribute("statusBackup","Восстановление завершено, база данных возвращена к исходному состоянию");
            } else {
                model.addAttribute("statusBackupError","Ошибка восстановления базы данных");
            }
    }
}
