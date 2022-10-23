package ru.alexn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexn.entity.RawData;

public interface RawDataDAO extends JpaRepository<RawData,Long> {
}
