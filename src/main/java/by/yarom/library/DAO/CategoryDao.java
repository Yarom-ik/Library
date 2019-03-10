package by.yarom.library.DAO;

import by.yarom.library.Entity.Category;

import java.util.List;

public interface CategoryDao {

    void addCategory(Category category);

    void deleteCategory(Category category);

    void editCategory(Category category);

    Category getCategory(int id);

    Category getCategoryByName(String name);

    List<Category> categoryList();
}
