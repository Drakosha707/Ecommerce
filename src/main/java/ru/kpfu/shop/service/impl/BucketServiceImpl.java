package ru.kpfu.shop.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.shop.model.Bucket;
import ru.kpfu.shop.repository.BucketRepository;
import ru.kpfu.shop.repository.ProductRepository;
import ru.kpfu.shop.service.BucketService;
import ru.kpfu.shop.util.SecurityUtils;

@Service
public class BucketServiceImpl implements BucketService{

    @Autowired
    BucketRepository bucketRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional
    public void addProduct(Long productId) {
        Bucket bucket = new Bucket();
        bucket.setNumberProduct(1);
        bucket.setUser(SecurityUtils.getCurrentUser());
        bucket.setProduct(productRepository.findOne(productId));
        bucketRepository.save(bucket);
    }

    @Override
    @Transactional
    public void deleteProduct(Long productId) {
        bucketRepository.delete(productId);
    }

    @Override
    @Transactional
    public void changeNumberProduct(Long productId, Integer numberProduct) {
        Bucket bucket = bucketRepository.findOne(productId);
        bucket.setNumberProduct(numberProduct);
        bucketRepository.save(bucket);
    }


}
