package ru.kpfu.shop.service;


public interface BucketService {

    void addProduct(Long productId);

    void deleteProduct(Long productId);

    void changeNumberProduct(Long productId, Integer numberProduct);

}
