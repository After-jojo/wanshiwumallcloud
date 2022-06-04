package com.wangc.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private String itemId;

    private String orderId;

    private String productId;

    private String productName;

    private String productImg;

    private String skuId;

    private String skuName;

    private BigDecimal productPrice;

    private Integer buyCounts;

    private BigDecimal totalAmount;

    private Date basketDate;

    private Date buyTime;

    private Integer isComment;


    public OrderItem(String itemId, String orderId, String productId, String productName, String productImg, String skuId, String skuName, double sellPrice, int cartNum, double v, Date basketDate, Date buyTime, int isComment) {
    }
}