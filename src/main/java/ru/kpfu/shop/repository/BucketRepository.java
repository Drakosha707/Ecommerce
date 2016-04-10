package ru.kpfu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.shop.model.Bucket;
import ru.kpfu.shop.model.Product;
import ru.kpfu.shop.model.User;

import java.util.List;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Long>{
    Bucket findOneByProductAndUser(Product product, User user);

    List<Bucket> findAllByUser(User currentUser);
}
