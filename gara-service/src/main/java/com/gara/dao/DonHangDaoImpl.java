package com.gara.dao;


import com.gara.model.DonHangModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class DonHangDaoImpl implements DonHangDao {

    private static final Logger logger = LogManager.getLogger(DonHangDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public DonHangModel getDonHang(String id) {
        DonHangModel donhang = null;
        try {
            String sql = "SELECT * " +
                    "FROM don_hang " +
                    "WHERE id = ? ";

            donhang = jdbcTemplate.queryForObject(sql,new Object[]{id},
                    (rs, rowNum) -> {
                        DonHangModel item = DonHangModel.builder()
                                .id(rs.getInt("id"))
                                .maDonHang(rs.getString("ma_don_hang"))
                                .bienSo(rs.getString("bien_so"))
                                .ngayVao(rs.getDate("ngay_vao"))
                                .ngayRa(rs.getDate("ngay_ra"))
                                .thanhToan(rs.getInt("thanh_toan"))
                                .maPhuTung(rs.getString("ma_phu_tung"))
                                .maDichVu(rs.getString("ma_dich_vu"))
                                .build();
                        return item;
                    });
        } catch (Exception ex) {
            logger.error("getDonHang error", ex.getMessage());
        }
        return donhang;
    }

    @Override
    public List<DonHangModel> getDanhSachDonHang() {
        try {
            String sql = "SELECT * " +
                    "FROM don_hang " +
                    "ORDER BY ngay_ra DESC ";

            return jdbcTemplate.query(sql,
                    (rs, rowNum) -> {
                        DonHangModel items = DonHangModel.builder()
                                .id(rs.getInt("id"))
                                .maDonHang(rs.getString("ma_don_hang"))
                                .bienSo(rs.getString("bien_so"))
                                .ngayVao(rs.getDate("ngay_vao"))
                                .ngayRa(rs.getDate("ngay_ra"))
                                .thanhToan(rs.getInt("thanh_toan"))
                                .maPhuTung(rs.getString("ma_phu_tung"))
                                .maDichVu(rs.getString("ma_dich_vu"))
                                .build();
                        return items;
                    });
        } catch (Exception ex) {
            logger.error("getDanhSachDonHang error", ex.getMessage());
        }
        return new ArrayList<>();
    }
}