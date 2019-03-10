package by.yarom.library.Service;

import by.yarom.library.Entity.Category;

import java.util.List;

public interface CategoryService {

    void addCategory(Category category);

    void deleteCategory(Category category);

    void editCategory(Category category);

    Category getCategory(int id);

    List<Category> categoryList();

    Category getCategoryByName(String name);
}
