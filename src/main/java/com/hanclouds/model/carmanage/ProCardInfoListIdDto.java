package com.hanclouds.model.carmanage;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProCardInfoListIdDto {
    private String operatorName;
    private String msisdn;
    private String iccid;
    private String imsi;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date openDate;
    private Date activeDate;
    private String comment;
    private String cardStatus;
    private String belongArea;
    private String netType;
    private String offeringId;
    private String proKey;
    private BigDecimal saleCharges;
    private Double saleYears;
    private Double triffcUse;
    private Double triffcAll;
    private Date dueTime;
    private String offeringName;
    private String offeringCost;
    private String proName;
    private String triffcUseStr;
    private String triffcAllStr;
    private String dueTimeStr;
}
