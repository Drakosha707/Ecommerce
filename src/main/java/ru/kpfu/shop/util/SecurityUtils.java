package ru.kpfu.shop.util;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.kpfu.shop.model.User;


public class SecurityUtils {

    public static User getCurrentUser() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

}
