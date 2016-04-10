package ru.kpfu.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.shop.model.Bucket;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Long>{

}
