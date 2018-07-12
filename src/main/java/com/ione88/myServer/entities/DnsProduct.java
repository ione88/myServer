package com.ione88.myServer.entities;

import javax.persistence.*;

@Entity
@Table(name = "dns_product")
public class DnsProduct {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    //Код товара – уникальное поле, целое
    private Integer code;
    //Наименование - строка
    private String name;
    //Цена - целое
    private Integer price;
    //Описание – строка
    private String description;
    // GSON строка с параметрами.
    private String parametrsJson;
    //Url - строка
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParametrsJson() {
        return parametrsJson;
    }

    public void setParametrsJson(String parametrsJson) {
        this.parametrsJson = parametrsJson;
    }
}