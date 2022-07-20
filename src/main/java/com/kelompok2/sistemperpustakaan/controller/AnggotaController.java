package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.AnggotaDto;
import com.kelompok2.sistemperpustakaan.model.dto.DataDto;
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

    // Insert Data diri Anggota
    @PostMapping("/save")
    public DefaultResponse<AnggotaDto> savaDataAnggota(@RequestBody AnggotaDto anggotaDto){
        Anggota anggota = convertDtoToEntity(anggotaDto);
        DefaultResponse<AnggotaDto> response = new DefaultResponse<>();
        Optional<Anggota> optional = anggotaRepository.findByIdAnggota(anggotaDto.getIdAnggota());
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
// mencari data anggota sesuai Id
    @GetMapping("/getbyid/{idAnggota}")
    public DataDto<AnggotaDto> getByIdAnggota(@PathVariable Integer idAnggota) {
        DataDto<AnggotaDto> data = new DataDto<>();
        Optional<Anggota> opt = anggotaRepository.findByIdAnggota(idAnggota);
        if (opt.isPresent()) {
            data.setMessage("Data Ditemukan");
            data.setData(convertEntityToDto(opt.get()));
        } else {
            data.setMessage("Data Tidak Ditemukan");
        }
        return data;
    }

    // menampilkan data mahasisiwa dalam database
    @GetMapping("/listanggota")
    public List<AnggotaDto> getListAnggota(){
        List<AnggotaDto> list = new ArrayList();
        for(Anggota anggota : anggotaRepository.findAll()){
            list.add(convertEntityToDto(anggota));
        }
        return list;
    }

    @PutMapping("/updateAnggota/{idAnggota}")
    public DefaultResponse updateAnggota(@PathVariable("idAnggota") Integer idAnggota, @RequestBody AnggotaDto anggotaDto) {
        DefaultResponse defResA = new DefaultResponse();
        Optional<Anggota> optAng = anggotaRepository.findByIdAnggota(idAnggota);
        Anggota objAng = optAng.get();
        if (optAng.isPresent()) {

            objAng.setUserName(anggotaDto.getUserName());
            objAng.setNoHpAnggota(anggotaDto.getNoHpAnggota());
            objAng.setJkAnggota(anggotaDto.getJkAnggota());
            objAng.setStatusAnggota(anggotaDto.getStatusAnggota());
            objAng.setAlamatAnggota(anggotaDto.getAlamatAnggota());
            objAng.setNamaAnggota(anggotaDto.getNamaAnggota());
            objAng.setPekerjaan(anggotaDto.getPekerjaan());
            objAng.setPasswordAnggota(anggotaDto.getPasswordAnggota());

            anggotaRepository.save(objAng);
            defResA.setStatus(Boolean.TRUE);
            defResA.setMessage("Data Berhasil Disimpan");
        } else {
            defResA.setStatus(Boolean.FALSE);
            defResA.setMessage("Kode Sudah Terdaftar");
        }
        return defResA;
    }
    @DeleteMapping("/delete/{idAnggota}")
    public DefaultResponse deleteIdAnggota(@PathVariable("idAnggota") Integer idAnggota) {
        DefaultResponse df = new DefaultResponse();
        Optional<Anggota> optAg =anggotaRepository.findByIdAnggota(idAnggota);
        if (optAg.isPresent()){
            anggotaRepository.delete(optAg.get());
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data idAnggota Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Tidak Ditemukan");
        }
        return df;
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
