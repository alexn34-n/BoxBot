package ru.alexn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexn.entity.AppDocument;
import ru.alexn.entity.AppPhoto;

public interface AppPhotoDAO extends JpaRepository<AppPhoto, Long> {
}