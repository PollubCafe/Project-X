package org.projectX.notes.categories.service;


import org.projectX.notes.categories.model.Category;
import org.projectX.notes.model.NoteCore;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Tomek on 2017-04-20.
 */
public interface CategoryService {

    Category createCategory(Category category);

    Category getCategoryById(Long id);

    Category updateCategory(Category category) throws NoResultException;

    void deleteCategory(Long id) throws NoResultException;

    Category getCategoryByName(String categoryName) throws NoResultException;

    List<Category> getAllCategories();
}