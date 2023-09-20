package io.gitub.mat3e.adapter;

import io.gitub.mat3e.model.CategoriesRepository;
import io.gitub.mat3e.model.Category;
import io.gitub.mat3e.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SqlCategoriesRepository extends CategoriesRepository, JpaRepository<Category,Integer> {

    @Override
    @Query("select distinct c from Category c join fetch c.products")
    List<Category> findAll();
}
