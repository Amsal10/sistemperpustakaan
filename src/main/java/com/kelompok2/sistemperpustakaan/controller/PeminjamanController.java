package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.DataPeminjamanAnggotaDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.PeminjamanDto;
import com.kelompok2.sistemperpustakaan.model.entity.Anggota;
import com.kelompok2.sistemperpustakaan.model.entity.Peminjaman;
import com.kelompok2.sistemperpustakaan.repository.AnggotaRepository;
import com.kelompok2.sistemperpustakaan.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
    @Autowired
    PeminjamanRepository peminjamanRepository;
    @Autowired
    AnggotaRepository anggotaRepository;

    //join table getbyidAnggota oneToOne Table
//    @GetMapping("/listPeminjaman/{idPeminjamn}")
//    public List<DataPeminjamanAnggotaDto> getListDataPeminjaman(@PathVariable Integer idPeminjamn) {
//        List<DataPeminjamanAnggotaDto> listDto = new ArrayList<>();
//        Optional<Peminjaman> optPem = peminjamanRepository.findByIdPeminjaman(idPeminjamn);
//        for(Peminjaman peminjaman : peminjamanRepository.findAll()){
////            listDto.add(convertEntityToDto(peminjaman));
//        }
//        return listDto;
//    }

    @GetMapping("/pemberitahuanPeminjaman/{idPeminjaman}")
    public DataPeminjamanAnggotaDto getListHistoryPeminjaman(@PathVariable Integer idPeminjaman) {
        Optional<Peminjaman> optPem = peminjamanRepository.findByIdPeminjaman(idPeminjaman);
        DataPeminjamanAnggotaDto dto = new DataPeminjamanAnggotaDto();
        if (optPem.isPresent()) {
            Peminjaman peminjaman = optPem.get();
            dto.setNamaAnggota(peminjaman.getAnggotaPeminjaman().getNamaAnggota());
            dto.setPekerjaan(peminjaman.getAnggotaPeminjaman().getPekerjaan());
            dto.setJudulBuku(peminjaman.getBukuPeminjaman().getJudulBuku());
            dto.setTglKembali(peminjaman.getTglKembali());
            dto.setTglPinjam(peminjaman.getTglPinjam());
            dto.setNamaPustakawan(peminjaman.getPustakawanPeminjaman().getNamaPustakawan());
            dto.setNoHpPustakawan(peminjaman.getPustakawanPeminjaman().getNoHpPustakawan());
        }
        return dto;
    }


    @PostMapping("/save")
    public DefaultResponse<PeminjamanDto> createDataPeminjaman(@RequestBody PeminjamanDto pemDto){
        Peminjaman peminjaman = convertDtoToEntity(pemDto);
        DefaultResponse<PeminjamanDto> resPem = new DefaultResponse<>();
        Optional<Peminjaman> opt = peminjamanRepository.findByIdPeminjaman(pemDto.getIdPeminjaman());
        if(opt.isPresent()){
            resPem.setStatus(Boolean.FALSE);
            resPem.setMessage("Data yang anda masuka sudah Terisi");
        }
        else{
            peminjamanRepository.save(peminjaman);
            resPem.setStatus(Boolean.TRUE);
            resPem.setMessage("Terima kasih, data anda sudah tersimpan");
        }
    return resPem;
    }
    @GetMapping("/listPeminjaman")
    public List<PeminjamanDto> getListPeminjaman(){
        List<PeminjamanDto> listPeminjaman = new ArrayList();
        for(Peminjaman peminjaman : peminjamanRepository.findAll()){
            listPeminjaman.add(convertEntityToDto(peminjaman));
        }
        return listPeminjaman;
    }

    public Peminjaman convertDtoToEntity(PeminjamanDto peminjamanDto){
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setIdAnggota(peminjamanDto.getIdAnggota());
        peminjaman.setIdBuku(peminjamanDto.getIdBuku());
        peminjaman.setIdPeminjaman(peminjamanDto.getIdPeminjaman());
        peminjaman.setIdPustakawan(peminjamanDto.getIdPustakawan());
        peminjaman.setTglPinjam(peminjamanDto.getTglPinjam());
        peminjaman.setTglKembali(peminjamanDto.getTglKembali());
        return peminjaman;
    }

    public PeminjamanDto convertEntityToDto(Peminjaman entity){
        PeminjamanDto dto = new PeminjamanDto();
        dto.setIdAnggota(entity.getIdAnggota());
        dto.setIdBuku(entity.getIdBuku());
        dto.setIdPeminjaman(entity.getIdPeminjaman());
        dto.setIdPustakawan(entity.getIdPustakawan());
        dto.setTglPinjam(entity.getTglPinjam());
        dto.setTglKembali(entity.getTglKembali());
        return dto;
    }
}
