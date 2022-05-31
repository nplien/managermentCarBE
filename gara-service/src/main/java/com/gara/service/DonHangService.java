package com.gara.service;


import com.gara.dto.ResDonHangDto;
import com.gara.model.DonHangModel;

import java.util.List;

public interface DonHangService {
    List<DonHangModel> getDanhSachDonHang();
    DonHangModel getDonHang(String id);
}
