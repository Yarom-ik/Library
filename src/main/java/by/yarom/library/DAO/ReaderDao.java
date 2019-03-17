package by.yarom.library.DAO;

import by.yarom.library.Entity.Reader;

import java.util.List;

public interface ReaderDao {

    void addReader(Reader reader);

    void deleteReader(Reader reader);

    void updateReader(Reader reader);

    List<Reader> listReader(Integer page);

    Long countFindReader();

    List<Reader> listReaderByChar(String actionChar, Integer page);

    Long countFindReaderByChar(String actionChar);

    List<Reader> listReaderByName(String name, Integer page);

    Long countFindReaderByName(String name);

    Reader getReaderById(int id);

    Reader getReaderByFirsName(String firsName);

    Reader getReaderByLastName(String lastName);

    Reader getReaderByMiddleName(String middleName);
}
