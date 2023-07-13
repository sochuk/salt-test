package com.salt.salttest.repository;

import com.salt.salttest.model.Konsumen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KonsumenRepo extends JpaRepository<Konsumen, Long> {
    Optional<Konsumen> findByNama(String nama);
    List<Konsumen> findAllByOrderByIdDesc();
}
