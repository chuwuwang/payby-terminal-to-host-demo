package com.payby.terminal.demo.http.entity.trade;

import com.payby.terminal.demo.http.entity.Money;

import java.math.BigDecimal;

public class GoodsDetail {
    private Money price;
    private String body;
    private String showUrl;
    private String goodsId;
    private String goodsName;
    private BigDecimal quantity;
    private String goodsCategory;
    private String categoriesTree;

    public GoodsDetail() {
        this.price = new Money();
        this.body = "";
        this.showUrl = "";
        this.goodsId = "";
        this.goodsName = "";
        this.quantity = BigDecimal.ZERO;
        this.goodsCategory = "";
        this.categoriesTree = "";
    }

    public void setPrice(Money price) {
        this.price = price;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }
    public void setCategoriesTree(String categoriesTree) {
        this.categoriesTree = categoriesTree;
    }

    public Money getPrice() {
        return price;
    }
    public String getBody() {
        return body;
    }
    public String getShowUrl() {
        return showUrl;
    }
    public String getGoodsId() {
        return goodsId;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public BigDecimal getQuantity() {
        return quantity;
    }
    public String getGoodsCategory() {
        return goodsCategory;
    }
    public String getCategoriesTree() {
        return categoriesTree;
    }

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "price=" + price +
                ", body='" + body + '\'' +
                ", showUrl='" + showUrl + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", quantity=" + quantity +
                ", goodsCategory='" + goodsCategory + '\'' +
                ", categoriesTree='" + categoriesTree + '\'' +
                '}';
    }
}
