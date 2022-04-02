package com.hanclouds.model.carmanage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @program: card-management-service
 * @description:
 * @author: hyShuDai
 * @create: 2022/2/24 10:40
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CardInfoDto {
    private Integer id;
    private String operatorName;
    private String msisdn;
    private String iccid;
    private String imsi;
    private Date openDate;
    private Date activeDate;
    private String comment;
    private String cardStatus;
    private String belongArea;
    private String netType;
    private String offeringId;
    private String offeringName;
    private String offeringCost;
}
