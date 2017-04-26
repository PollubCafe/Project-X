package org.projectX.notes.categories.repository;

import org.projectX.notes.categories.model.Category;
import org.projectX.notes.model.NoteCore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomek on 2017-04-20.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category getCategoryByCategoryName(String categoryName);
}
