package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.entity.Anggota;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnggotaRepository extends JpaRepository<Anggota, Long> {

    Optional<Anggota> findByIdAnggota(Integer idAnggota);
    Optional<Anggota> findByUserNameAndPasswordAnggota (String uname, String pass);




}
