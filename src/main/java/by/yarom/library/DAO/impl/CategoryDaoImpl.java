package by.yarom.library.DAO.impl;

import by.yarom.library.DAO.CategoryDao;
import by.yarom.library.Entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("Category")
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCategory(Category category) {
        currentSession().save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        currentSession().delete(category);
    }

    @Override
    public void editCategory(Category category) {
        currentSession().update(category);
    }

    @Override
    public Category getCategory(int id) {
        Category category = currentSession().get(Category.class, id);
        return category;
    }

    @Override
    public Category getCategoryByName(String name) {
        Category category = (Category) currentSession().createQuery("from Category c where c.categoryName =:nam")
                .setParameter("nam", name)
                .uniqueResult();
        return category;
    }


    @Override
    public List<Category> categoryList() {
        List<Category> categoryList = currentSession().createQuery("from Category ").list();
        return categoryList;
    }
}
