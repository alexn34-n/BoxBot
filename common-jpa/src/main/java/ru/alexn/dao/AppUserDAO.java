package ru.alexn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexn.entity.AppUser;

public interface AppUserDAO extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByTelegramId(Long id);
}
