package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.LoginDto;
import com.kelompok2.sistemperpustakaan.model.entity.Admin;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import com.kelompok2.sistemperpustakaan.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public DefaultResponse loginAdmin(@RequestBody LoginDto loginDto) {
        Optional<Admin> optionalAdmin = adminRepository.findByUsernameAdminAndPasswordAdmin(loginDto.getUname(), loginDto.getPass());
        DefaultResponse df = new DefaultResponse();
        if (optionalAdmin.isPresent()) {
            df.setStatus(Boolean.TRUE);
            df.setMessage("Login berhasil");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Maaf username dan password salah");
        }
        return df;
    }
}
