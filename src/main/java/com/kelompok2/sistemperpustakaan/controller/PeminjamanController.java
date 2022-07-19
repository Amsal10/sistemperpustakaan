package com.kelompok2.sistemperpustakaan.controller;


import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.PeminjamanDto;
import com.kelompok2.sistemperpustakaan.model.entity.Peminjaman;
import com.kelompok2.sistemperpustakaan.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {

    @Autowired
    PeminjamanRepository peminjamanRepository;

    @PostMapping("/save")
    public DefaultResponse<PeminjamanDto> createDataPeminjaman(@RequestBody PeminjamanDto pemDto){
        Peminjaman peminjaman = convertDtoToEntity(pemDto);
        DefaultResponse<PeminjamanDto> resPem = new DefaultResponse<>();
        Optional<Peminjaman> opt = peminjamanRepository.findByIdpeminjaman(pemDto.getIdpeminjaman());
        if(opt.isPresent()){
            resPem.setStatus(Boolean.FALSE);
            resPem.setMessage("Data yang anda masuka sudah Terisi");
        }
        else{
            resPem.setStatus(Boolean.TRUE);
            resPem.setMessage("Terima kasih, data anda sudah tersimpan");
        }
    return resPem;
    }
    public Peminjaman convertDtoToEntity(PeminjamanDto peminjamanDto){
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setIdanggota(peminjamanDto.getIdanggota());
        peminjaman.setIdbuku(peminjamanDto.getIdbuku());
        peminjaman.setIdpeminjaman(peminjamanDto.getIdpeminjaman());
        peminjaman.setIdpetugas(peminjamanDto.getIdpetugas());
        peminjaman.setTglpinjam(peminjamanDto.getTglpinjam());
        peminjaman.setTglkembali(peminjamanDto.getTglkembali());
        return peminjaman;
    }

    public PeminjamanDto convertEntityToDto(Peminjaman entity){
        PeminjamanDto dto = new PeminjamanDto();
        dto.setIdanggota(entity.getIdanggota());
        dto.setIdbuku(entity.getIdbuku());
        dto.setIdpeminjaman(entity.getIdpeminjaman());
        dto.setIdpetugas(entity.getIdpetugas());
        dto.setTglpinjam(entity.getTglpinjam());
        dto.setTglkembali(entity.getTglkembali());
        return dto;
    }
}
