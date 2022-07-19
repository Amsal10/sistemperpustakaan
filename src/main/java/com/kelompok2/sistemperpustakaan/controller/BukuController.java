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
//    contoh
    @PostMapping("/save")
    public DefaultResponse<BukuDto> savebuku(@RequestBody BukuDto bukuDto){
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
        dto.setIdbuku(entity.getIdbuku());
        dto.setJudulbuku(entity.getJudulbuku());
        dto.setPenulisbuku(entity.getPenulisbuku());
        dto.setPenerbitbuku(entity.getPenerbitbuku());
        dto.setTahunterbit(entity.getTahunterbit());
        dto.setLokasirak(entity.getLokasirak());
        dto.setJmlbuku(entity.getJmlbuku());

        return dto;
    }
// menampilkan buku berdasarkan id --/buku/getbyid/{idbuku}
    @GetMapping("/getbyid/{idbuku}")
    public DefaultResponse<BukuDto> getByIdBuku(@PathVariable String idbuku){
        DefaultResponse<BukuDto> response = new DefaultResponse<>();
        Optional<Buku> optional = bukuRepository.findByIdbuku(idbuku);
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
    public DefaultResponse deleteById(@PathVariable("idbuku") String idbuku) {
        DefaultResponse df = new DefaultResponse();
        Optional<Buku> optionalBuku =bukuRepository.findById(idbuku);
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

    @PutMapping("/update/{idbbuku}")
    public DefaultResponse update(@PathVariable("idbuku") String idbuku, @RequestBody BukuDto bukuDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Buku> optionalBuku = bukuRepository.findById(idbuku);
        Buku book = optionalBuku.get();
        if (optionalBuku.isPresent()) {
            book.setPenulisbuku(bukuDto.getPenulisbuku());
            bukuRepository.save(book);
            df.setStatus(Boolean.TRUE);
//            df.setData(bukuDto);
            df.setMessage("Data Berhasil Disimpan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Kode Icdx Sudah Terdaftar");
        }
        return df;
    }

}
