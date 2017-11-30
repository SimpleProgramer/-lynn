package com.lynn.net.mall.entity.base;

import com.wz.net.BaseCriteria;
import com.wz.net.BaseModelExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BMallGoodsExample extends BaseModelExample {
    protected List<Criteria> oredCriteria;

    public BMallGoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        super.clear();
        oredCriteria.clear();
    }

    protected abstract static class GeneratedCriteria extends BaseCriteria {

        public Criteria andIdIsNull() {
            addCriterion("mallGoods.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("mallGoods.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("mallGoods.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("mallGoods.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("mallGoods.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("mallGoods.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("mallGoods.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("mallGoods.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("mallGoods.id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("mallGoods.id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("mallGoods.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("mallGoods.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("mallGoods.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("mallGoods.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("mallGoods.goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("mallGoods.goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("mallGoods.goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("mallGoods.goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("mallGoods.goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("mallGoods.goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("mallGoods.goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("mallGoods.goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("mallGoods.goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("mallGoods.goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("mallGoods.goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("mallGoods.goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("mallGoods.goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("mallGoods.goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNull() {
            addCriterion("mallGoods.goods_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNotNull() {
            addCriterion("mallGoods.goods_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountEqualTo(Integer value) {
            addCriterion("mallGoods.goods_count =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotEqualTo(Integer value) {
            addCriterion("mallGoods.goods_count <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThan(Integer value) {
            addCriterion("mallGoods.goods_count >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("mallGoods.goods_count >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThan(Integer value) {
            addCriterion("mallGoods.goods_count <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThanOrEqualTo(Integer value) {
            addCriterion("mallGoods.goods_count <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIn(List<Integer> values) {
            addCriterion("mallGoods.goods_count in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotIn(List<Integer> values) {
            addCriterion("mallGoods.goods_count not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountBetween(Integer value1, Integer value2) {
            addCriterion("mallGoods.goods_count between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("mallGoods.goods_count not between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryIsNull() {
            addCriterion("mallGoods.surplus_repository is null");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryIsNotNull() {
            addCriterion("mallGoods.surplus_repository is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryEqualTo(Integer value) {
            addCriterion("mallGoods.surplus_repository =", value, "surplusRepository");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryNotEqualTo(Integer value) {
            addCriterion("mallGoods.surplus_repository <>", value, "surplusRepository");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryGreaterThan(Integer value) {
            addCriterion("mallGoods.surplus_repository >", value, "surplusRepository");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("mallGoods.surplus_repository >=", value, "surplusRepository");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryLessThan(Integer value) {
            addCriterion("mallGoods.surplus_repository <", value, "surplusRepository");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryLessThanOrEqualTo(Integer value) {
            addCriterion("mallGoods.surplus_repository <=", value, "surplusRepository");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryIn(List<Integer> values) {
            addCriterion("mallGoods.surplus_repository in", values, "surplusRepository");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryNotIn(List<Integer> values) {
            addCriterion("mallGoods.surplus_repository not in", values, "surplusRepository");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryBetween(Integer value1, Integer value2) {
            addCriterion("mallGoods.surplus_repository between", value1, value2, "surplusRepository");
            return (Criteria) this;
        }

        public Criteria andSurplusRepositoryNotBetween(Integer value1, Integer value2) {
            addCriterion("mallGoods.surplus_repository not between", value1, value2, "surplusRepository");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("mallGoods.class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("mallGoods.class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(String value) {
            addCriterion("mallGoods.class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(String value) {
            addCriterion("mallGoods.class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(String value) {
            addCriterion("mallGoods.class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(String value) {
            addCriterion("mallGoods.class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(String value) {
            addCriterion("mallGoods.class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(String value) {
            addCriterion("mallGoods.class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLike(String value) {
            addCriterion("mallGoods.class_id like", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotLike(String value) {
            addCriterion("mallGoods.class_id not like", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<String> values) {
            addCriterion("mallGoods.class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<String> values) {
            addCriterion("mallGoods.class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(String value1, String value2) {
            addCriterion("mallGoods.class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(String value1, String value2) {
            addCriterion("mallGoods.class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("mallGoods.create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("mallGoods.create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("mallGoods.create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("mallGoods.create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("mallGoods.create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("mallGoods.create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("mallGoods.create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("mallGoods.create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("mallGoods.create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("mallGoods.create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("mallGoods.create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("mallGoods.create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andGoodsContextIsNull() {
            addCriterion("mallGoods.goods_context is null");
            return (Criteria) this;
        }

        public Criteria andGoodsContextIsNotNull() {
            addCriterion("mallGoods.goods_context is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsContextEqualTo(String value) {
            addCriterion("mallGoods.goods_context =", value, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextNotEqualTo(String value) {
            addCriterion("mallGoods.goods_context <>", value, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextGreaterThan(String value) {
            addCriterion("mallGoods.goods_context >", value, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextGreaterThanOrEqualTo(String value) {
            addCriterion("mallGoods.goods_context >=", value, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextLessThan(String value) {
            addCriterion("mallGoods.goods_context <", value, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextLessThanOrEqualTo(String value) {
            addCriterion("mallGoods.goods_context <=", value, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextLike(String value) {
            addCriterion("mallGoods.goods_context like", value, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextNotLike(String value) {
            addCriterion("mallGoods.goods_context not like", value, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextIn(List<String> values) {
            addCriterion("mallGoods.goods_context in", values, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextNotIn(List<String> values) {
            addCriterion("mallGoods.goods_context not in", values, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextBetween(String value1, String value2) {
            addCriterion("mallGoods.goods_context between", value1, value2, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsContextNotBetween(String value1, String value2) {
            addCriterion("mallGoods.goods_context not between", value1, value2, "goodsContext");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("mallGoods.goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("mallGoods.goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("mallGoods.goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("mallGoods.goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("mallGoods.goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mallGoods.goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(BigDecimal value) {
            addCriterion("mallGoods.goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mallGoods.goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("mallGoods.goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("mallGoods.goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mallGoods.goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mallGoods.goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}