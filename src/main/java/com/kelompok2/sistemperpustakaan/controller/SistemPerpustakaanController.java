package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.LoginDto;
import com.kelompok2.sistemperpustakaan.model.entity.Buku;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import com.kelompok2.sistemperpustakaan.repository.BukuRepository;
import com.kelompok2.sistemperpustakaan.repository.PustakawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pustakawan")
public class SistemPerpustakaanController {

    @Autowired
    private PustakawanRepository pustakawanRepository;

    @Autowired
    private BukuRepository bukuRepository;
    //komentar
//    nambah komentar


    @PostMapping("/login")
    public DefaultResponse loginPustakawan(@RequestBody LoginDto loginDto){

        Optional<Pustakawan> optionalPustakawan = pustakawanRepository.findByUsernamepustakawanAndPasswordpustakawan(loginDto.getUname(), loginDto.getPass());

        DefaultResponse df = new DefaultResponse();

        if(optionalPustakawan.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Login berhasil");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Maaf username dan password salah");
        }

        return df;
    }

    @GetMapping("/byid/{idbuku}/namabuku/{namabuku}")
    public DefaultResponse getByIdBuku(@PathVariable String idbuku, @PathVariable String namabuku){

        DefaultResponse df = new DefaultResponse();
        Optional<Buku> optionalBuku = bukuRepository.findById(idbuku);
        if(optionalBuku.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data ditemukan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data tidak ada");
        }
        return df;
    }


}