package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.entity.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, String > {

    Optional<Peminjaman> findByIdPeminjaman(Integer idPeminjaman);
}
