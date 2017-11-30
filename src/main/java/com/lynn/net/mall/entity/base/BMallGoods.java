package com.lynn.net.mall.entity.base;

import com.wz.net.BaseModel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BMallGoods extends BaseModel<String> implements Serializable {
    private String id;

    private String goodsName;

    private Integer goodsCount;

    private Integer surplusRepository;

    private String classId;

    private Date createDate;

    private String goodsContext;

    private BigDecimal goodsPrice;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getSurplusRepository() {
        return surplusRepository;
    }

    public void setSurplusRepository(Integer surplusRepository) {
        this.surplusRepository = surplusRepository;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getGoodsContext() {
        return goodsContext;
    }

    public void setGoodsContext(String goodsContext) {
        this.goodsContext = goodsContext == null ? null : goodsContext.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsCount=").append(goodsCount);
        sb.append(", surplusRepository=").append(surplusRepository);
        sb.append(", classId=").append(classId);
        sb.append(", createDate=").append(createDate);
        sb.append(", goodsContext=").append(goodsContext);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}