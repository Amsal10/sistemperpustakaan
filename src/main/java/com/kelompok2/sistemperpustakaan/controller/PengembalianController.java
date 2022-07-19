package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.PengembalianDto;
import com.kelompok2.sistemperpustakaan.model.dto.PustakawanDto;
import com.kelompok2.sistemperpustakaan.model.entity.Pengembalian;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import com.kelompok2.sistemperpustakaan.repository.PengembalianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pengembalian")
public class PengembalianController {

    @Autowired
    private PengembalianRepository pengembalianRepository;

    @PostMapping("/save")
    public DefaultResponse<PengembalianDto> savePengembalian(@RequestBody PengembalianDto pengembalianDto){
        Pengembalian pengembalian = convertDtoToEntity(pengembalianDto);
        DefaultResponse<PengembalianDto> response = new DefaultResponse();
        Optional<Pengembalian> optionalPengembalian = pengembalianRepository.findById(pengembalianDto.getIdPengembalian());
        if(optionalPengembalian.isPresent()){
            response.setStatus(Boolean.FALSE);
            response.setMessage("Error, data sudah tersedia");
        } else {
            pengembalianRepository.save(pengembalian);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Data berhasil ditambahkan");
        }
        return response;
    }

    public Pengembalian convertDtoToEntity(PengembalianDto dto){
        Pengembalian pengembalian = new Pengembalian();
        pengembalian.setIdPengembalian(dto.getIdPengembalian());
        pengembalian.setTglKembali(dto.getTglKembali());
        pengembalian.setJatuhTempo(dto.getJatuhTempo());
        pengembalian.setTotalDenda(dto.getTotalDenda());
        pengembalian.setIdPustakawan(dto.getIdPustakawan());
        pengembalian.setIdAnggota(dto.getIdAnggota());
        pengembalian.setIdBuku(dto.getIdBuku());

        return pengembalian;
    }

//    @GetMapping("/list")
//    public List<PengembalianDto> getListPengembalian(){
//        List<PengembalianDto> list = new ArrayList();
//        for(Pengembalian pengembalian :pengembalianRepository.findAll()){
//            list.add(convertEntityToDto(pengembalian));
//        }
//        return list;
//    }
//    public PengembalianDto convertEntityToDto(Pengembalian entity){
//        PengembalianDto dto = new PengembalianDto();
//        dto.setIdPengembalian(entity.getIdPengembalian());
//        dto.setTglKembali(entity.getTglKembali());
//        dto.setJatuhTempo(entity.getJatuhTempo());
//        dto.setTotalDenda(entity.getTotalDenda());
//        dto.setIdPustakawan(entity.getIdPustakawan());
//        dto.setIdAnggota(entity.getIdAnggota());
//        dto.setIdBuku(entity.getIdBuku());
//        return dto;
//    }
}
