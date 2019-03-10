package by.yarom.library.Service.impl;

import by.yarom.library.DAO.CategoryDao;
import by.yarom.library.Entity.Category;
import by.yarom.library.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryDao.deleteCategory(category);
    }

    @Override
    public void editCategory(Category category) {
        categoryDao.editCategory(category);
    }

    @Override
    public Category getCategory(int id) {
        return categoryDao.getCategory(id);
    }

    @Override
    public List<Category> categoryList() {
        return categoryDao.categoryList();
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryDao.getCategoryByName(name);
    }
}
