package by.yarom.library.Service.impl;

import by.yarom.library.DAO.GiveDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GiveServiceImplTest {


    @Mock
    private GiveDao giveDao;


    @Test
    public void giveList() throws Exception {
        assertNotNull(giveDao.giveList());
    }

    @Test
    public void giveStatistic() throws Exception {

        int year = 2018;
        Calendar calendar = Calendar.getInstance();
        int mount = (calendar.get(Calendar.MONTH) + 1);
        int yearNow = (calendar.get(Calendar.YEAR));
        if (year != yearNow) {
            mount = 12;
        }
        assertEquals(12, mount);

        String startedDate = year + "-01-01 00:00:00";
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date startDate = format.parse(startedDate);

        Date d = format.parse("2018-01-01 00:00:00");
        assertEquals(d, startDate);

    }

}