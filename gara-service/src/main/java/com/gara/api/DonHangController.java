package com.gara.api;

import com.gara.dto.ResDonHangDto;
import com.gara.model.DonHangModel;
import com.gara.service.DonHangService;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/donhang")
@AllArgsConstructor
public class DonHangController {
    private static Logger logger = LoggerFactory.getLogger(DonHangController.class);
    @Autowired
    private DonHangService donHangService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        try {
            logger.info("#donhang - Start - id :" + id);
            List<DonHangModel> listDonHang = new ArrayList<DonHangModel>();
            DonHangModel donHang = donHangService.getDonHang(id);
            if (donHang == null) {
                return ResponseEntity.notFound().build();
            }
            listDonHang.add(donHang);
            ResDonHangDto resDonHangDto = ResDonHangDto.builder()
                    .code(200)
                    .message("Success")
                    .data(listDonHang)
                    .build();

            return ResponseEntity.ok().body(resDonHangDto);
        } catch (Exception e) {
            logger.info("request getDonHang: ", e);
            throw e;
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAll() {
        try {
            logger.info("#donhang - Start:");
            List<DonHangModel> listDonHang = donHangService.getDanhSachDonHang();
            ResDonHangDto resDonHangDto = ResDonHangDto.builder()
                    .code(200)
                    .message("Success")
                    .data(listDonHang)
                    .build();
            logger.info("#donhang - Response:" + resDonHangDto.toString());
            return ResponseEntity.ok().body(resDonHangDto);
        } catch (Exception e) {
            logger.info("request getDonHang: ", e);
            throw e;
        }
    }

}
