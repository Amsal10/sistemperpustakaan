package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.PengembalianDto;
import com.kelompok2.sistemperpustakaan.model.dto.PustakawanDto;
import com.kelompok2.sistemperpustakaan.model.entity.Pengembalian;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import com.kelompok2.sistemperpustakaan.repository.PengembalianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Optional<Pengembalian> optionalPengembalian = pengembalianRepository.findById(pengembalianDto.getIdpengembalian());
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
        pengembalian.setIdpengembalian(dto.getIdpengembalian());
        pengembalian.setTglkembali(dto.getTglkembali());
        pengembalian.setJatuhtempo(dto.getJatuhtempo());
        pengembalian.setTotaldenda(dto.getTotaldenda());
        pengembalian.setIdpustakawan(dto.getIdpustakawan());
        pengembalian.setIdanggota(dto.getIdanggota());
        pengembalian.setIdbuku(dto.getIdbuku());

        return pengembalian;
    }
}
