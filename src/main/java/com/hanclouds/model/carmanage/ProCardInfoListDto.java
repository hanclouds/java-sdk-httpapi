package com.hanclouds.model.carmanage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: card-management-service
 * @description:
 * @author: hyShuDai
 * @create: 2022/2/28 17:13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProCardInfoListDto extends ProCardInfo {
    private String offeringName;
    private String offeringCost;
    private String proName;
    private String triffcUseStr;
    private String triffcAllStr;
    private String dueTimeStr;
}
