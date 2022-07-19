package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.entity.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnggotaRepository extends JpaRepository<Anggota, Long> {

    Optional<Anggota> findByIdAnggota(Integer idAnggota);
//    List<Anggota> findAnggotaList(Integer idAnggota);




}