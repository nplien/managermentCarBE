package com.gara.service;

import com.gara.dao.DonHangDao;
import com.gara.model.DonHangModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonHangServiceImpl implements DonHangService {

    @Autowired
    private DonHangDao donHangDao;

    @Override
    public List<DonHangModel> getDanhSachDonHang() {
        List<DonHangModel> list = new ArrayList<DonHangModel>();
        list = donHangDao.getDanhSachDonHang();
        return list;
    }
    @Override
    public DonHangModel getDonHang(String id) {
        return donHangDao.getDonHang(id);
    }

}
