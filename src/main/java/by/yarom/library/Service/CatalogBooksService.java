package by.yarom.library.Service;

import by.yarom.library.Entity.CatalogBooks;

import java.util.List;

public interface CatalogBooksService {

    List<CatalogBooks> listCatalogBooks(Integer page);

    Long countFindBook();

    void addCatalogBook(CatalogBooks catalogBooks);

    void updateBook(CatalogBooks catalogBooks);

    void deleteBook(int id);

    CatalogBooks getBookById(int id);

    List<CatalogBooks> listBooksByChar(String s, Integer page);

    Long countFindBookByChar(String s);

    List<CatalogBooks> listBooksByParam(String name, String param, Integer page);

    Long countFindBookByParam(String name, String param);

    CatalogBooks getCatalogBookByInvNum(int invNum);
}
