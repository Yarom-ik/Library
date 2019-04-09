package by.yarom.library.Service.impl;

import by.yarom.library.DAO.CatalogBooksDao;
import by.yarom.library.DAO.GiveDao;
import by.yarom.library.DAO.OrderDao;
import by.yarom.library.Entity.CatalogBooks;
import by.yarom.library.Entity.Give;
import by.yarom.library.Entity.Order;
import by.yarom.library.Service.GiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
 class GiveServiceImpl implements GiveService {

    @Autowired
    private GiveDao giveDao;

    @Autowired
    private CatalogBooksDao catalogBooksDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addGive(Give give) {
        giveDao.addGive(give);
    }

    @Override
    public void deleteGive(Give give) {
        giveDao.deleteGive(give);

    }

    @Override
    public void updateGive(Give give) {
        giveDao.updateGive(give);
    }

    @Override
    public Give getGiveById(int id) {
        return giveDao.getGiveById(id);
    }

    @Override
    public void returnGive(String returnBookId, boolean returnBook, String actionIdOrder, int idReader) {
        Give give = giveDao.getGiveById(new Integer(returnBookId));
        give.setDataReturn(new Date());
        give.setFinished(returnBook);
        CatalogBooks catalogBooks = catalogBooksDao.getCatalogBooksById(give.getCatalogBooks().getId());
        int count = catalogBooks.getCountBook();
        if (returnBook == true) {
            count++;
        }else count--;
        catalogBooks.setCountBook(count);
        catalogBooksDao.updateBook(catalogBooks);
        giveDao.updateGive(give);
        Order order = orderDao.getOrderById(new Integer(actionIdOrder));
        if (giveDao.giveListByOrderIdByFinished(new Integer(actionIdOrder),idReader,false).size() == 0){
            order.setFinished(true);
        }else {
            order.setFinished(false);
        }
        orderDao.updateOrder(order);
    }

    @Override
    public void returnGiveAll(String actionIdOrder, int idReader) {
        List<Give> giveList = giveDao.giveListByOrderId(Integer.parseInt(actionIdOrder),idReader);
        for (Give give : giveList){
            give.setFinished(true);
            give.setDataReturn(new Date());
            giveDao.updateGive(give);
        }
        Order order = orderDao.getOrderById(new Integer(actionIdOrder));
        order.setFinished(true);
        orderDao.updateOrder(order);
    }

    @Override
    public List<Give> giveList() {
        return giveDao.giveList();
    }

    @Override
    public List<Give> giveListByFinished(boolean finish) {
        return giveDao.giveListByFinished(finish);
    }

    @Override
    public List<Give> giveListByOrderId(int idOrder, int idReader) {
        return giveDao.giveListByOrderId(idOrder, idReader);
    }

    @Override
    public List<Give> giveListByReaderByBooksNotFinished(String firstName, String lastName, String middleName) {
        return giveDao.giveListByReaderByBooksNotFinished(firstName, lastName, middleName);
    }

    @Override
    public int[] giveStatistic(int year) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        System.out.println("текущий месяц "+(calendar.get(Calendar.MONTH)+1)+ " yearNow= "+calendar.get(Calendar.YEAR));
        int mount = (calendar.get(Calendar.MONTH)+1);
        int yearNow = (calendar.get(Calendar.YEAR));

        if(year!=yearNow) {
            mount=12;
        }
        int[] masGiveMounth = new int[mount];
        for (int m = 1; m <= mount; m++) {
            String startedDate = year + "-" + m + "-01 00:00:00";
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd HH:mm:ss");
            Date startDate = format.parse(startedDate);
            System.out.println("startDate " + startDate);

            Calendar calendarEnd = Calendar.getInstance();
            calendarEnd.set(Calendar.YEAR, year);
            calendarEnd.set(Calendar.MONTH, m - 1);
            String endedDate = year + "-" + m + "-" + calendarEnd.getActualMaximum(Calendar.DAY_OF_MONTH) + " 23:59:59";
            SimpleDateFormat formatEnd = new SimpleDateFormat();
            formatEnd.applyPattern("yyyy-MM-dd HH:mm:ss");
            Date endDate = formatEnd.parse(endedDate);
            System.out.println("EndDate " + endDate);

            masGiveMounth[m - 1] = (int) giveDao.giveStatistic(startDate, endDate);
        }

        return masGiveMounth;
    }
}
