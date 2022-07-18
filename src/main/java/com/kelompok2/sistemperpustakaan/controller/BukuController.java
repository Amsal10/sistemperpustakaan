package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.BukuDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.entity.Buku;
import com.kelompok2.sistemperpustakaan.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    private BukuRepository bukuRepository;

// menambahkan data buku ke data base --/buku/save
    @PostMapping("/save")
    public DefaultResponse<BukuDto> savemahasiswa(@RequestBody BukuDto bukuDto){
        Buku buku = convertDtoToEntity(bukuDto);
        DefaultResponse<BukuDto> response = new DefaultResponse();
        Optional<Buku> optional = bukuRepository.findById(bukuDto.getIdbuku());
        if(optional.isPresent()){
            response.setStatus(Boolean.FALSE);
            response.setMessage("Error, Data Sudah Tersedia");
        } else {
            bukuRepository.save(buku);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Berhasil Simpan Data");
        }

        return response;
    }
    public Buku convertDtoToEntity(BukuDto dto){
        Buku buku = new Buku();
        buku.setIdbuku(dto.getIdbuku());
        buku.setJudulbuku(dto.getJudulbuku());
        buku.setPenulisbuku(dto.getPenulisbuku());
        buku.setPenerbitbuku(dto.getPenerbitbuku());
        buku.setTahunterbit(dto.getTahunterbit());
        buku.setLokasirak(dto.getLokasirak());
        buku.setJmlbuku(dto.getJmlbuku());

        return buku;
    }

    public Buku convertEntityToDto(Buku entity){
        Buku dto = new Buku();
        dto.setIdbuku(entity.getIdbuku());
        dto.setJudulbuku(entity.getJudulbuku());
        dto.setPenulisbuku(entity.getPenulisbuku());
        dto.setPenerbitbuku(entity.getPenerbitbuku());
        dto.setTahunterbit(entity.getTahunterbit());
        dto.setLokasirak(entity.getLokasirak());
        dto.setJmlbuku(entity.getJmlbuku());

        return dto;
    }



}
