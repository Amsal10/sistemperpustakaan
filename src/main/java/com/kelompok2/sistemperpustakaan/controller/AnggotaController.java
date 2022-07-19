package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.AnggotaDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.entity.Anggota;
import com.kelompok2.sistemperpustakaan.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anggota")
public class AnggotaController {

    @Autowired
    AnggotaRepository anggotaRepositoryr;

    // Input Data diri Anggota
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
    // menampilkan data mahasisiwa dalam database
    @GetMapping("/listanggota")
    public List<AnggotaDto> getListAnggota(){
//        List<AnggotaDto> list = listData();
        List<AnggotaDto> list = new ArrayList();
        for(Anggota m :anggotaRepositoryr.findAll()){
            list.add(convertEntityToDto(m));
        }

        return list;
    }



    public Anggota convertDtoToEntity(AnggotaDto anggotaDto){
        Anggota anggota = new Anggota();

        anggota.setIdAnggota(anggotaDto.getIdAnggota());
        anggota.setUserName(anggotaDto.getUserName());
        anggota.setNamaAnggota(anggotaDto.getNamaAnggota());
        anggota.setJkAnggota(anggotaDto.getJkAnggota());
        anggota.setPekerjaan(anggotaDto.getPekerjaan());
        anggota.setAlamatAnggota(anggotaDto.getAlamatAnggota());
        anggota.setNoHpAnggota(anggotaDto.getNoHpAnggota());
        anggota.setPasswordAnggota(anggotaDto.getPasswordAnggota());
        anggota.setStatusAnggota(anggotaDto.getStatusAnggota());

     return anggota;
    }

    public AnggotaDto convertEntityToDto(Anggota entity){
        AnggotaDto dto = new AnggotaDto();

        dto.setIdAnggota(entity.getIdAnggota());
        dto.setUserName(entity.getUserName());
        dto.setNamaAnggota(entity.getNamaAnggota());
        dto.setJkAnggota(entity.getJkAnggota());
        dto.setPekerjaan(entity.getPekerjaan());
        dto.setAlamatAnggota(entity.getAlamatAnggota());
        dto.setNoHpAnggota(entity.getNoHpAnggota());
        dto.setPasswordAnggota(entity.getPasswordAnggota());
        dto.setStatusAnggota(entity.getStatusAnggota());

        return dto;
    }
}
