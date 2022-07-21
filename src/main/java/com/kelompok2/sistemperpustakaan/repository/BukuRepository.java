package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BukuRepository extends JpaRepository<Buku, Long> {

    Optional<Buku> findByIdBuku (Integer idBuku);

}
