package ru.kpfu.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.shop.model.ShippingInfo;

public interface ShippingRepository extends JpaRepository<ShippingInfo, Long> {
}
