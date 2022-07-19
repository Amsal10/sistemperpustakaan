package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.BukuDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.PustakawanDto;
import com.kelompok2.sistemperpustakaan.model.entity.Buku;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import com.kelompok2.sistemperpustakaan.repository.PustakawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pustakawan")
public class PustakawanController {

    @Autowired
    private PustakawanRepository pustakawanRepository;

    @PostMapping("/save")
    public DefaultResponse<PustakawanDto> savePustakawan(@RequestBody PustakawanDto pustakawanDto){
        Pustakawan pustakawan = convertDtoToEntity(pustakawanDto);
        DefaultResponse<PustakawanDto> response = new DefaultResponse();
        Optional<Pustakawan> optionalPustakawan = pustakawanRepository.findById(pustakawanDto.getIdpustakawan());
        if(optionalPustakawan.isPresent()){
            response.setStatus(Boolean.FALSE);
            response.setMessage("Error, data sudah tersedia");
        } else {
            pustakawanRepository.save(pustakawan);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Data berhasil ditambahkan");
        }
        return response;
    }

    public Pustakawan convertDtoToEntity(PustakawanDto dto){
        Pustakawan pustakawan = new Pustakawan();
        pustakawan.setIdpustakawan(dto.getIdpustakawan());
        pustakawan.setNamapustakawan(dto.getNamapustakawan());
        pustakawan.setJkpustakawan(dto.getJkpustakawan());
        pustakawan.setAlamatpustakawan(dto.getAlamatpustakawan());
        pustakawan.setNohppustakawan(dto.getNohppustakawan());
        pustakawan.setUsernamepustakawan(dto.getUsernamepustakawan());
        pustakawan.setPasswordpustakawan(dto.getPasswordpustakawan());
        pustakawan.setStatuspustakawan(dto.getStatuspustakawan());

        return pustakawan;
    }

}
