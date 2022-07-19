package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.BukuDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.entity.Buku;
import com.kelompok2.sistemperpustakaan.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    private BukuRepository bukuRepository;

// menambahkan data buku ke data base --/buku/save
    @PostMapping("/save")
    public DefaultResponse<BukuDto> savebuku(@RequestBody BukuDto bukuDto){
        Buku buku = convertDtoToEntity(bukuDto);
        DefaultResponse<BukuDto> response = new DefaultResponse();
        Optional<Buku> optional = bukuRepository.findById(bukuDto.getIdBuku());
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
        buku.setIdBuku(dto.getIdBuku());
        buku.setJudulBuku(dto.getJudulBuku());
        buku.setPenulisBuku(dto.getPenulisBuku());
        buku.setPenerbitBuku(dto.getPenerbitBuku());
        buku.setTahunTerbit(dto.getTahunTerbit());
        buku.setLokasiRak(dto.getLokasiRak());
        buku.setJmlBuku(dto.getJmlBuku());

        return buku;
    }

// menampilkan seluruh data buku --buku/listbuku
    @GetMapping("/listbuku")
    public List<BukuDto> getListBuku(){
//        List<BukuDto> list = listData();
        List<BukuDto> list = new ArrayList();
        for(Buku buku :bukuRepository.findAll()){
            list.add(convertEntityToDto(buku));
        }
        return list;
    }
    public BukuDto convertEntityToDto(Buku entity){
        BukuDto dto = new BukuDto();
        dto.setIdBuku(entity.getIdBuku());
        dto.setJudulBuku(entity.getJudulBuku());
        dto.setPenulisBuku(entity.getPenulisBuku());
        dto.setPenerbitBuku(entity.getPenerbitBuku());
        dto.setTahunTerbit(entity.getTahunTerbit());
        dto.setLokasiRak(entity.getLokasiRak());
        dto.setJmlBuku(entity.getJmlBuku());

        return dto;
    }
// menampilkan buku berdasarkan id --/buku/getbyid/{idbuku}
    @GetMapping("/getbyid/{idbuku}")
    public DefaultResponse<BukuDto> getByIdBuku(@PathVariable String idBuku){
        DefaultResponse<BukuDto> response = new DefaultResponse<>();
        Optional<Buku> optional = bukuRepository.findByIdBuku(idBuku);
        if(optional.isPresent()){
            response.setStatus(Boolean.TRUE);
            response.setMessage("Data Ditemukan");
        } else {
            response.setMessage("Data Tidak Ditemukan");
        }
        return response;
    }

// menghapus data buku dari database --/buku/delete/{idbuku}
    @DeleteMapping("/delete/{idbuku}")
    public DefaultResponse deleteById(@PathVariable("idBuku") String idBuku) {
        DefaultResponse df = new DefaultResponse();
        Optional<Buku> optionalBuku =bukuRepository.findById(idBuku);
        if (optionalBuku.isPresent()){
            bukuRepository.delete(optionalBuku.get());
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Tidak Ditemukan");
        }
        return df;
    }
// meng-update data buku --/buku/update/{idbuku}
    @PutMapping("/update/{idBuku}")
    public DefaultResponse update(@PathVariable("idBuku") String idBuku, @RequestBody BukuDto bukuDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Buku> optionalBuku = bukuRepository.findById(idBuku);
        Buku book = optionalBuku.get();
        if (optionalBuku.isPresent()) {
            book.setPenulisBuku(bukuDto.getPenulisBuku());
            bukuRepository.save(book);
            df.setStatus(Boolean.TRUE);
//            df.setData(bukuDto);
            df.setMessage("Data Berhasil Disimpan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Kode Sudah Terdaftar");
        }
        return df;
    }

}
