package ru.kpfu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.shop.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
