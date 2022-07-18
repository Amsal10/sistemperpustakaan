package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.entity.Pengembalian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PengembalianRepository extends JpaRepository<Pengembalian, String > {

    Optional<Pengembalian> findByIdpengembalian (Integer idpengembalian);
}
