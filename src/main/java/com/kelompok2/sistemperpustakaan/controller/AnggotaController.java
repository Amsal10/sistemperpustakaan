package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.AnggotaDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.entity.Anggota;
import com.kelompok2.sistemperpustakaan.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/anggota")
public class AnggotaController {

    @Autowired
    AnggotaRepository anggotaRepositoryr;

    @PostMapping("/save")
    public DefaultResponse<AnggotaDto> savadataanggota(@RequestBody AnggotaDto anggotaDto){
        Anggota anggota = convertDtoToEntity(anggotaDto);
        DefaultResponse<AnggotaDto> response = new DefaultResponse<>();
        Optional<Anggota> optional = anggotaRepositoryr.findByIdAnggota(anggotaDto.getIdAnggota());
        if(optional.isPresent()){
            response.setStatus(Boolean.FALSE);
            response.setMessage("Error, Data Sudah Tersedia");
        } else {
            anggotaRepositoryr.save(anggota);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Data Anggota Berhasil disimpan");
        }

        return response;
    }

    public Anggota convertDtoToEntity(AnggotaDto anggotaDto){
        Anggota anggota = new Anggota();

        anggota.setIdAnggota(anggotaDto.getIdAnggota());
        anggota.setNamaAnggota(anggotaDto.getNamaAnggota());
        anggota.setJkAnggota(anggotaDto.getJkAnggota());
        anggota.setPekerjaan(anggotaDto.getPekerjaan());
        anggota.setAlamatAnggota(anggotaDto.getAlamatAnggota());
        anggota.setNoHpAnggota(anggotaDto.getNoHpAnggota());
        anggota.setPasswordAnggota(anggotaDto.getPasswordAnggota());
        anggota.setStatusAnggota(anggotaDto.getStatusAnggota());

     return anggota;
    }

    public Anggota convertEntityToDto(Anggota entity){
        Anggota dto = new Anggota();

        dto.setIdAnggota(entity.getIdAnggota());
//        dto.setNamaAnggota(entity.getNamaAnggota());



        return dto;
    }
}
