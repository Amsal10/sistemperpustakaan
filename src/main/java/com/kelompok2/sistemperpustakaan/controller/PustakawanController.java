package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.BukuDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.LoginDto;
import com.kelompok2.sistemperpustakaan.model.dto.PustakawanDto;
import com.kelompok2.sistemperpustakaan.model.entity.Buku;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import com.kelompok2.sistemperpustakaan.repository.PustakawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pustakawan")
public class PustakawanController {

    @Autowired
    private PustakawanRepository pustakawanRepository;

    @PostMapping("/login")
    public DefaultResponse loginPustakawan(@RequestBody LoginDto loginDto){

        Optional<Pustakawan> optionalPustakawan = pustakawanRepository.findByUsernamePustakawanAndPasswordPustakawan(loginDto.getUname(), loginDto.getPass());

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

    @PostMapping("/save")
    public DefaultResponse<PustakawanDto> savePustakawan(@RequestBody PustakawanDto pustakawanDto){
        Pustakawan pustakawan = convertDtoToEntity(pustakawanDto);
        DefaultResponse<PustakawanDto> response = new DefaultResponse();
        Optional<Pustakawan> optionalPustakawan = pustakawanRepository.findById(pustakawanDto.getIdPustakawan());
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
        pustakawan.setIdPustakawan(dto.getIdPustakawan());
        pustakawan.setNamaPustakawan(dto.getNamaPustakawan());
        pustakawan.setJkPustakawan(dto.getJkPustakawan());
        pustakawan.setAlamatPustakawan(dto.getAlamatPustakawan());
        pustakawan.setNoHpPustakawan(dto.getNoHpPustakawan());
        pustakawan.setUsernamePustakawan(dto.getUsernamePustakawan());
        pustakawan.setPasswordPustakawan(dto.getPasswordPustakawan());
        pustakawan.setStatusPustakawan(dto.getStatusPustakawan());

        return pustakawan;
    }

    @GetMapping("/listpustakawan")
    public List<PustakawanDto> getListPustakawan(){
        List<PustakawanDto> list = new ArrayList();
        for(Pustakawan pustakawan :pustakawanRepository.findAll()){
            list.add(convertEntityToDto(pustakawan));
        }
        return list;
    }
    public PustakawanDto convertEntityToDto(Pustakawan entity){
        PustakawanDto dto = new PustakawanDto();
        dto.setIdPustakawan(entity.getIdPustakawan());
        dto.setNamaPustakawan(entity.getNamaPustakawan());
        dto.setJkPustakawan(entity.getJkPustakawan());
        dto.setAlamatPustakawan(entity.getAlamatPustakawan());
        dto.setNoHpPustakawan(entity.getNoHpPustakawan());
        dto.setUsernamePustakawan(entity.getUsernamePustakawan());
        dto.setPasswordPustakawan(entity.getPasswordPustakawan());
        dto.setStatusPustakawan(entity.getStatusPustakawan());

        return dto;
    }

}
