package com.gara.dto;

import com.gara.model.DonHangModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ResDonHangDto extends Response {
    private List<DonHangModel> data;
}
