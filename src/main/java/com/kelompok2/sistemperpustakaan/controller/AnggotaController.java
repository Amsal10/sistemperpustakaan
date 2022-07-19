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
    AnggotaRepository anggotaRepository;

    // Input Data diri Anggota
    @PostMapping("/save")
    public DefaultResponse<AnggotaDto> savadataanggota(@RequestBody AnggotaDto anggotaDto){
        Anggota anggota = convertDtoToEntity(anggotaDto);
        DefaultResponse<AnggotaDto> response = new DefaultResponse<>();
        Optional<Anggota> optional = anggotaRepository.findByIdanggota(anggotaDto.getIdanggota());
        if(optional.isPresent()){
            response.setStatus(Boolean.FALSE);
            response.setMessage("Error, Data Sudah Tersedia");
        } else {
            anggotaRepository.save(anggota);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Data Anggota Berhasil disimpan");
        }

        return response;
    }

    @GetMapping("/getbyname/{idAnggota}")
    public DefaultResponse<AnggotaDto> getByIdAnggota(@PathVariable Integer idanggota) {
        DefaultResponse<AnggotaDto> response = new DefaultResponse<>();
        Optional<Anggota> optional = anggotaRepository.findByIdanggota(idanggota);
        if (optional.isPresent()) {
            response.setMessage("Data Ditemukan");
            response.setStatus(Boolean.TRUE);
            response.setData(convertEntityToDto(optional.get()));
        } else {
            response.setMessage("Data Tidak Ditemukan");
            response.setStatus(Boolean.FALSE);
        }
        return response;
    }
    
    // menampilkan data mahasisiwa dalam database
    @GetMapping("/listanggota")
    public List<AnggotaDto> getListAnggota(){
        List<AnggotaDto> list = new ArrayList();
        for(Anggota m : anggotaRepository.findAll()){
            list.add(convertEntityToDto(m));
        }

        return list;
    }

    public Anggota convertDtoToEntity(AnggotaDto anggotaDto){
        Anggota anggota = new Anggota();

        anggota.setIdanggota(anggotaDto.getIdanggota());
        anggota.setUsername(anggotaDto.getUsername());
        anggota.setNamaanggota(anggotaDto.getNamaanggota());
        anggota.setJkanggota(anggotaDto.getJkanggota());
        anggota.setPekerjaan(anggotaDto.getPekerjaan());
        anggota.setAlamatanggota(anggotaDto.getAlamatanggota());
        anggota.setNohpanggota(anggotaDto.getNohpanggota());
        anggota.setPasswordanggota(anggotaDto.getPasswordanggota());
        anggota.setStatusanggota(anggotaDto.getStatusanggota());

     return anggota;
    }

    public AnggotaDto convertEntityToDto(Anggota entity){
        AnggotaDto dto = new AnggotaDto();

        dto.setIdanggota(entity.getIdanggota());
        dto.setUsername(entity.getUsername());
        dto.setNamaanggota(entity.getNamaanggota());
        dto.setJkanggota(entity.getJkanggota());
        dto.setPekerjaan(entity.getPekerjaan());
        dto.setAlamatanggota(entity.getAlamatanggota());
        dto.setNohpanggota(entity.getNohpanggota());
        dto.setPasswordanggota(entity.getPasswordanggota());
        dto.setStatusanggota(entity.getStatusanggota());

        return dto;
    }
}
