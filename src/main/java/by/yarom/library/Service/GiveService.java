package by.yarom.library.Service;

import by.yarom.library.Entity.Give;

import java.text.ParseException;
import java.util.List;

public interface GiveService {

    void addGive(Give give);

    void deleteGive(Give give);

    void updateGive(Give give);

    Give getGiveById(int id);

    void returnGive(String returnBookId, boolean returnBook, String action, int idReader);

    void returnGiveAll(String action, int idReader);

    List<Give> giveList();

    List<Give> giveListByFinished(boolean finish);

    List<Give> giveListByOrderId(int idOrder, int idReader);

    List<Give> giveListByReaderByBooksNotFinished(String firstName, String lastName, String middleName);

    int[] giveStatistic(int year) throws ParseException;

}
