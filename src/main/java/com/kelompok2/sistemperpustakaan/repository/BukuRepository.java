package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BukuRepository extends JpaRepository<Buku, Long> {

    Optional<Buku> findByIdBuku (Integer idBuku);

    Optional<Buku> findByJudulBuku(String judulBuku);

    @Query(value = "SELECT * FROM data_buku Where judul_buku LIKE %?1%", nativeQuery = true)
    List<Buku> search (String search);

}
