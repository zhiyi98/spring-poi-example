package com.example.poi.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.TABLE;

@Entity
public class GoodsDetail {
    
    @Id
    @GeneratedValue(strategy = TABLE, generator = "GOODS_DETAILS_SEQ")
    @TableGenerator(
        name="GOODS_DETAILS_GEN",
        table="GOODS_DETAILS_ID_GEN",
        pkColumnName="GOODS_DETAILS_GEN_KEY",
        valueColumnName="GOODS_DETAILS_GEN_VALUE",
        pkColumnValue="GOODS_DETAILS_ID",
        allocationSize=1)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "INTRODUCE")
    private String introduce;
    
    @Column(name = "IMAGE")
    private String image;
    
    @Column(name = "STOCK")
    private Long stock;
    
    @Version
    private Long version;
}
