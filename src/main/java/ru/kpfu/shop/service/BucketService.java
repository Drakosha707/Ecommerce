package ru.kpfu.shop.service;


public interface BucketService {

    void addProduct(Long productId);

    void deleteProduct(Long productId);

    void changeNumberProduct(Long bucketId, Integer numberProduct);

}
