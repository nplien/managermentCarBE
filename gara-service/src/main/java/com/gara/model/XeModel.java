package com.gara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class XeModel {
    private String bienSo;
    private String tenXe;
    private String nhanHieu;
    private String tinhTrang;
    private String mauSac;
    private String thongSoKyThuat;
    private String maGara;
    private String maKH;
}
