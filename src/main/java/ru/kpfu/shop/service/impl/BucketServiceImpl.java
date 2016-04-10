package ru.kpfu.shop.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.shop.model.Bucket;
import ru.kpfu.shop.model.Product;
import ru.kpfu.shop.model.User;
import ru.kpfu.shop.repository.BucketRepository;
import ru.kpfu.shop.repository.ProductRepository;
import ru.kpfu.shop.repository.UserRepository;
import ru.kpfu.shop.service.BucketService;
import ru.kpfu.shop.util.SecurityUtils;

@Service
public class BucketServiceImpl implements BucketService{

    @Autowired
    BucketRepository bucketRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void addProduct(Long productId) {
        User user = userRepository.findOne(SecurityUtils.getCurrentUser().getId());
        Product product = productRepository.findOne(productId);
        Bucket bucket = bucketRepository.findOneByProductAndUser(product, user);
        if (bucket == null) {
            bucket = new Bucket();
            bucket.setNumberProduct(1);
            bucket.setUser(user);
            bucket.setProduct(product);
        }else{
            bucket.setNumberProduct(bucket.getNumberProduct() + 1);
        }

        bucketRepository.save(bucket);
    }

    @Override
    @Transactional
    public void deleteProduct(Long productId) {
        bucketRepository.delete(productId);
    }

    @Override
    @Transactional
    public void changeNumberProduct(Long bucketId, Integer numberProduct) {
        Bucket bucket = bucketRepository.findOne(bucketId);
        bucket.setNumberProduct(numberProduct);
        bucketRepository.save(bucket);
    }


}
