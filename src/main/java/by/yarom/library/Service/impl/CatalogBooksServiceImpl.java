package by.yarom.library.Service.impl;

import by.yarom.library.DAO.CatalogBooksDao;
import by.yarom.library.Entity.CatalogBooks;
import by.yarom.library.Service.CatalogBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CatalogBooksServiceImpl implements CatalogBooksService {

    @Autowired
    private CatalogBooksDao catalogBooksDao;

    @Override
    public List<CatalogBooks> listCatalogBooks(Integer page) {
        return this.catalogBooksDao.listCatalogBooks(page);
    }

    @Override
    public Long countFindBook() {
        return catalogBooksDao.countFindBook();
    }

    @Override
    public void addCatalogBook(CatalogBooks catalogBooks) {
        catalogBooksDao.addBook(catalogBooks);

    }

    @Override
    public void updateBook(CatalogBooks catalogBooks) {
        catalogBooksDao.updateBook(catalogBooks);
    }

    @Override
    public void deleteBook(int id) {
        catalogBooksDao.deleteBook(id);
    }

    @Override
    public CatalogBooks getBookById(int id) {

       return catalogBooksDao.getCatalogBooksById(id);
    }


    @Override
    public List<CatalogBooks> listBooksByChar(String s,Integer page) {
        return this.catalogBooksDao.listBooksByChar(s, page);
    }

    @Override
    public Long countFindBookByChar(String s) {
        return catalogBooksDao.countFindBookByChar(s);
    }

    @Override
    public List<CatalogBooks> listBooksByParam(String name, String param, Integer page) {
        return this.catalogBooksDao.listBooksByParam(name, param, page);
    }

    @Override
    public Long countFindBookByParam(String name, String param) {
        return catalogBooksDao.countFindBookByParam(name,param);
    }

    @Override
    public CatalogBooks getCatalogBookByInvNum(int invNum) {
        return this.catalogBooksDao.getCatalogBookByInvNum(invNum);
    }
}
