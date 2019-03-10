package by.yarom.library.backetBook;

import by.yarom.library.Entity.CatalogBooks;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Scope("session")
public class BasketBook {

        private int readerId;

     private Map<Integer, Integer> booksBasket = new LinkedHashMap<>();

    public Map<Integer, Integer> getBooksBasket() {
        return booksBasket;
    }
    public void addToBasket (int id, int count){
        if (booksBasket.containsKey(id)){
        }else {
            booksBasket.put(id, count);
        }
    }

    public void deleteAll(){
        booksBasket.clear();
        readerId = 0;
    }

    public void editBasket(int id,int col){
        booksBasket.replace(id, col);
    }



    public void delBasketBook (int id, int count){
        Iterator<Map.Entry<Integer,Integer>> iter = booksBasket.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer,Integer> entry = iter.next();
            if(id == (entry.getKey())){
                iter.remove();
            }
        }

    }

    public BasketBook() {
    }



    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }
}
