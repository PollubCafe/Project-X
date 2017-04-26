package org.projectX.notes.categories.service;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.projectX.notes.categories.model.Category;
import org.projectX.notes.categories.repository.CategoryRepository;
import org.projectX.notes.model.NoteCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Tomek on 2017-04-20.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public Category createCategory(Category category){
        Category createdCategory = categoryRepository.save(category);
        return createdCategory;
    }

    @Override
    public Category getCategoryById(Long id) {
        Category foundCategory = categoryRepository.findOne(id);
        return foundCategory;
    }

    @Override
    public Category updateCategory(Category category) throws NoResultException {
        Category foundCategory = categoryRepository.findOne(category.getId());
        if(foundCategory == null){
            throw new NoResultException("No such category");
        }
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategory(Long id) throws NoResultException {

    }

    @Override
    @Transactional
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.getCategoryByCategoryName(categoryName);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
