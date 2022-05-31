package com.gara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DonHangModel {
    private Integer id;
    private String maDonHang;
    private String bienSo;
    private Date ngayRa;
    private Date ngayVao;
    private Integer thanhToan;
    private String maPhuTung;
    private String maDichVu;
}
