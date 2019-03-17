package by.yarom.library.Service.impl;


import by.yarom.library.DAO.ReaderDao;
import by.yarom.library.Entity.Reader;
import by.yarom.library.Service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReaderServiceImpl implements ReaderService{

    @Autowired
    private ReaderDao readerDao;

    @Override
    public void addReader(Reader reader) {
        readerDao.addReader(reader);
    }

    @Override
    public void deleteReader(Reader reader) {
        readerDao.deleteReader(reader);

    }

    @Override
    public void updateReader(Reader reader) {
        readerDao.updateReader(reader);

    }

    @Override
    public List<Reader> listReader(Integer page) {
        return readerDao.listReader(page);
    }

    @Override
    public Long countFindReader() {
        return readerDao.countFindReader();
    }

    @Override
    public List<Reader> listReaderByChar(String actionChar, Integer page) {
        return readerDao.listReaderByChar(actionChar, page);
    }

    @Override
    public Long countFindReaderByChar(String actionChar) {
        return readerDao.countFindReaderByChar(actionChar);
    }

    @Override
    public List<Reader> listReaderByName(String name, Integer page) {
        return readerDao.listReaderByName(name, page);
    }

    @Override
    public Long countFindReaderByName(String name) {
        return readerDao.countFindReaderByName(name);
    }

    @Override
    public Reader getReaderById(int id) {
        return readerDao.getReaderById(id);
    }

    @Override
    public Reader getReaderByFirsName(String firsName) {
        return readerDao.getReaderByFirsName(firsName);
    }

    @Override
    public Reader getReaderByLastName(String lastName) {
        return readerDao.getReaderByLastName(lastName);
    }

    @Override
    public Reader getReaderByMiddleName(String middleName) {
        return readerDao.getReaderByMiddleName(middleName);
    }
}
