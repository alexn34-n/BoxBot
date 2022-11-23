package ru.alexn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexn.entity.AppDocument;

public interface AppDocumentDAO extends JpaRepository<AppDocument, Long> {
}