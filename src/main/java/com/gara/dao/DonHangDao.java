package com.gara.dao;


import com.gara.model.DonHangModel;

import java.util.List;

public interface DonHangDao {
    DonHangModel getDonHang(String id);
    List<DonHangModel> getDanhSachDonHang();
}
