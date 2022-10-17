package com.example.poi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.TABLE;

@Entity
@Table(name = "GOODS")
@DynamicInsert
@DynamicUpdate
public class Goods {
    
    @Id
    @GeneratedValue(strategy = TABLE, generator = "GOODS_SEQ")
    @TableGenerator(
        name="GOODS_GEN",
        table="GOODS_ID_GEN",
        pkColumnName="GOODS_GEN_KEY",
        valueColumnName="GOODS_GEN_VALUE",
        pkColumnValue="GOODS_ID",
        allocationSize=1)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @OneToOne
    @JoinColumn(name = "GOODS_DETAIL_ID")
    private GoodsDetail goodsDetail;
    
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "UPDATE_TIME")
    private Date updateTime;
    
    @Version
    private Long version;
    
    
    
}
