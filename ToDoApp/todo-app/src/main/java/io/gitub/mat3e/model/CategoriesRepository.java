package io.gitub.mat3e.model;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepository {
    List<Category> findAll();
    Optional<Category> findById(Integer id);
    Category save(Category entity);
}
