package by.yarom.library.DAO;

import by.yarom.library.Entity.Give;

import java.util.Date;
import java.util.List;

public interface GiveDao {

    void addGive(Give give);

    void deleteGive(Give give);

    void updateGive(Give give);

    Give getGiveById(int id);

    List<Give> giveList();

    List<Give> giveListByFinished(boolean finish);

    List<Give> giveListByOrderId(int idOrder, int idReader);

    List<Give> giveListByOrderIdByFinished(int idOrder, int idReader, boolean finish);

    List<Give> giveListByReaderByBooksNotFinished(String firstName, String lastName, String middleName);

    long giveStatistic(Date startDate, Date endDate);
}
