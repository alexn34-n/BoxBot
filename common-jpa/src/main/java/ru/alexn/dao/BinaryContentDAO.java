package ru.alexn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexn.entity.BinaryContent;

public interface BinaryContentDAO extends JpaRepository<BinaryContent, Long> {
}