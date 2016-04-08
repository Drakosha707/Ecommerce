package ru.kpfu.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.shop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByLogin(String login);
}
