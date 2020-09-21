package com.chuan.myfinanceweb.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DataOf100ppiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataOf100ppiExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
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
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductidIsNull() {
            addCriterion("productid is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("productid is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(String value) {
            addCriterion("productid =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(String value) {
            addCriterion("productid <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(String value) {
            addCriterion("productid >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(String value) {
            addCriterion("productid >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(String value) {
            addCriterion("productid <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(String value) {
            addCriterion("productid <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLike(String value) {
            addCriterion("productid like", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotLike(String value) {
            addCriterion("productid not like", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<String> values) {
            addCriterion("productid in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<String> values) {
            addCriterion("productid not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(String value1, String value2) {
            addCriterion("productid between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(String value1, String value2) {
            addCriterion("productid not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNull() {
            addCriterion("productname is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("productname is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("productname =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("productname <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("productname >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("productname >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("productname <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("productname <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("productname like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("productname not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("productname in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("productname not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("productname between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("productname not between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceIsNull() {
            addCriterion("currentprice is null");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceIsNotNull() {
            addCriterion("currentprice is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceEqualTo(BigDecimal value) {
            addCriterion("currentprice =", value, "currentprice");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceNotEqualTo(BigDecimal value) {
            addCriterion("currentprice <>", value, "currentprice");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceGreaterThan(BigDecimal value) {
            addCriterion("currentprice >", value, "currentprice");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("currentprice >=", value, "currentprice");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceLessThan(BigDecimal value) {
            addCriterion("currentprice <", value, "currentprice");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("currentprice <=", value, "currentprice");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceIn(List<BigDecimal> values) {
            addCriterion("currentprice in", values, "currentprice");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceNotIn(List<BigDecimal> values) {
            addCriterion("currentprice not in", values, "currentprice");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("currentprice between", value1, value2, "currentprice");
            return (Criteria) this;
        }

        public Criteria andCurrentpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("currentprice not between", value1, value2, "currentprice");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1IsNull() {
            addCriterion("delivermonth1 is null");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1IsNotNull() {
            addCriterion("delivermonth1 is not null");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1EqualTo(String value) {
            addCriterion("delivermonth1 =", value, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1NotEqualTo(String value) {
            addCriterion("delivermonth1 <>", value, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1GreaterThan(String value) {
            addCriterion("delivermonth1 >", value, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1GreaterThanOrEqualTo(String value) {
            addCriterion("delivermonth1 >=", value, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1LessThan(String value) {
            addCriterion("delivermonth1 <", value, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1LessThanOrEqualTo(String value) {
            addCriterion("delivermonth1 <=", value, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1Like(String value) {
            addCriterion("delivermonth1 like", value, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1NotLike(String value) {
            addCriterion("delivermonth1 not like", value, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1In(List<String> values) {
            addCriterion("delivermonth1 in", values, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1NotIn(List<String> values) {
            addCriterion("delivermonth1 not in", values, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1Between(String value1, String value2) {
            addCriterion("delivermonth1 between", value1, value2, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth1NotBetween(String value1, String value2) {
            addCriterion("delivermonth1 not between", value1, value2, "delivermonth1");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1IsNull() {
            addCriterion("settlementprice1 is null");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1IsNotNull() {
            addCriterion("settlementprice1 is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1EqualTo(BigDecimal value) {
            addCriterion("settlementprice1 =", value, "settlementprice1");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1NotEqualTo(BigDecimal value) {
            addCriterion("settlementprice1 <>", value, "settlementprice1");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1GreaterThan(BigDecimal value) {
            addCriterion("settlementprice1 >", value, "settlementprice1");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settlementprice1 >=", value, "settlementprice1");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1LessThan(BigDecimal value) {
            addCriterion("settlementprice1 <", value, "settlementprice1");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("settlementprice1 <=", value, "settlementprice1");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1In(List<BigDecimal> values) {
            addCriterion("settlementprice1 in", values, "settlementprice1");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1NotIn(List<BigDecimal> values) {
            addCriterion("settlementprice1 not in", values, "settlementprice1");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("settlementprice1 between", value1, value2, "settlementprice1");
            return (Criteria) this;
        }

        public Criteria andSettlementprice1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settlementprice1 not between", value1, value2, "settlementprice1");
            return (Criteria) this;
        }

        public Criteria andJc1IsNull() {
            addCriterion("jc1 is null");
            return (Criteria) this;
        }

        public Criteria andJc1IsNotNull() {
            addCriterion("jc1 is not null");
            return (Criteria) this;
        }

        public Criteria andJc1EqualTo(BigDecimal value) {
            addCriterion("jc1 =", value, "jc1");
            return (Criteria) this;
        }

        public Criteria andJc1NotEqualTo(BigDecimal value) {
            addCriterion("jc1 <>", value, "jc1");
            return (Criteria) this;
        }

        public Criteria andJc1GreaterThan(BigDecimal value) {
            addCriterion("jc1 >", value, "jc1");
            return (Criteria) this;
        }

        public Criteria andJc1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jc1 >=", value, "jc1");
            return (Criteria) this;
        }

        public Criteria andJc1LessThan(BigDecimal value) {
            addCriterion("jc1 <", value, "jc1");
            return (Criteria) this;
        }

        public Criteria andJc1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("jc1 <=", value, "jc1");
            return (Criteria) this;
        }

        public Criteria andJc1In(List<BigDecimal> values) {
            addCriterion("jc1 in", values, "jc1");
            return (Criteria) this;
        }

        public Criteria andJc1NotIn(List<BigDecimal> values) {
            addCriterion("jc1 not in", values, "jc1");
            return (Criteria) this;
        }

        public Criteria andJc1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("jc1 between", value1, value2, "jc1");
            return (Criteria) this;
        }

        public Criteria andJc1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jc1 not between", value1, value2, "jc1");
            return (Criteria) this;
        }

        public Criteria andPercent1IsNull() {
            addCriterion("percent1 is null");
            return (Criteria) this;
        }

        public Criteria andPercent1IsNotNull() {
            addCriterion("percent1 is not null");
            return (Criteria) this;
        }

        public Criteria andPercent1EqualTo(BigDecimal value) {
            addCriterion("percent1 =", value, "percent1");
            return (Criteria) this;
        }

        public Criteria andPercent1NotEqualTo(BigDecimal value) {
            addCriterion("percent1 <>", value, "percent1");
            return (Criteria) this;
        }

        public Criteria andPercent1GreaterThan(BigDecimal value) {
            addCriterion("percent1 >", value, "percent1");
            return (Criteria) this;
        }

        public Criteria andPercent1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("percent1 >=", value, "percent1");
            return (Criteria) this;
        }

        public Criteria andPercent1LessThan(BigDecimal value) {
            addCriterion("percent1 <", value, "percent1");
            return (Criteria) this;
        }

        public Criteria andPercent1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("percent1 <=", value, "percent1");
            return (Criteria) this;
        }

        public Criteria andPercent1In(List<BigDecimal> values) {
            addCriterion("percent1 in", values, "percent1");
            return (Criteria) this;
        }

        public Criteria andPercent1NotIn(List<BigDecimal> values) {
            addCriterion("percent1 not in", values, "percent1");
            return (Criteria) this;
        }

        public Criteria andPercent1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("percent1 between", value1, value2, "percent1");
            return (Criteria) this;
        }

        public Criteria andPercent1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("percent1 not between", value1, value2, "percent1");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2IsNull() {
            addCriterion("delivermonth2 is null");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2IsNotNull() {
            addCriterion("delivermonth2 is not null");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2EqualTo(String value) {
            addCriterion("delivermonth2 =", value, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2NotEqualTo(String value) {
            addCriterion("delivermonth2 <>", value, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2GreaterThan(String value) {
            addCriterion("delivermonth2 >", value, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2GreaterThanOrEqualTo(String value) {
            addCriterion("delivermonth2 >=", value, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2LessThan(String value) {
            addCriterion("delivermonth2 <", value, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2LessThanOrEqualTo(String value) {
            addCriterion("delivermonth2 <=", value, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2Like(String value) {
            addCriterion("delivermonth2 like", value, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2NotLike(String value) {
            addCriterion("delivermonth2 not like", value, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2In(List<String> values) {
            addCriterion("delivermonth2 in", values, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2NotIn(List<String> values) {
            addCriterion("delivermonth2 not in", values, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2Between(String value1, String value2) {
            addCriterion("delivermonth2 between", value1, value2, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andDelivermonth2NotBetween(String value1, String value2) {
            addCriterion("delivermonth2 not between", value1, value2, "delivermonth2");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2IsNull() {
            addCriterion("settlementprice2 is null");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2IsNotNull() {
            addCriterion("settlementprice2 is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2EqualTo(BigDecimal value) {
            addCriterion("settlementprice2 =", value, "settlementprice2");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2NotEqualTo(BigDecimal value) {
            addCriterion("settlementprice2 <>", value, "settlementprice2");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2GreaterThan(BigDecimal value) {
            addCriterion("settlementprice2 >", value, "settlementprice2");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settlementprice2 >=", value, "settlementprice2");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2LessThan(BigDecimal value) {
            addCriterion("settlementprice2 <", value, "settlementprice2");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("settlementprice2 <=", value, "settlementprice2");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2In(List<BigDecimal> values) {
            addCriterion("settlementprice2 in", values, "settlementprice2");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2NotIn(List<BigDecimal> values) {
            addCriterion("settlementprice2 not in", values, "settlementprice2");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("settlementprice2 between", value1, value2, "settlementprice2");
            return (Criteria) this;
        }

        public Criteria andSettlementprice2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settlementprice2 not between", value1, value2, "settlementprice2");
            return (Criteria) this;
        }

        public Criteria andJc2IsNull() {
            addCriterion("jc2 is null");
            return (Criteria) this;
        }

        public Criteria andJc2IsNotNull() {
            addCriterion("jc2 is not null");
            return (Criteria) this;
        }

        public Criteria andJc2EqualTo(BigDecimal value) {
            addCriterion("jc2 =", value, "jc2");
            return (Criteria) this;
        }

        public Criteria andJc2NotEqualTo(BigDecimal value) {
            addCriterion("jc2 <>", value, "jc2");
            return (Criteria) this;
        }

        public Criteria andJc2GreaterThan(BigDecimal value) {
            addCriterion("jc2 >", value, "jc2");
            return (Criteria) this;
        }

        public Criteria andJc2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("jc2 >=", value, "jc2");
            return (Criteria) this;
        }

        public Criteria andJc2LessThan(BigDecimal value) {
            addCriterion("jc2 <", value, "jc2");
            return (Criteria) this;
        }

        public Criteria andJc2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("jc2 <=", value, "jc2");
            return (Criteria) this;
        }

        public Criteria andJc2In(List<BigDecimal> values) {
            addCriterion("jc2 in", values, "jc2");
            return (Criteria) this;
        }

        public Criteria andJc2NotIn(List<BigDecimal> values) {
            addCriterion("jc2 not in", values, "jc2");
            return (Criteria) this;
        }

        public Criteria andJc2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("jc2 between", value1, value2, "jc2");
            return (Criteria) this;
        }

        public Criteria andJc2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("jc2 not between", value1, value2, "jc2");
            return (Criteria) this;
        }

        public Criteria andPercent2IsNull() {
            addCriterion("percent2 is null");
            return (Criteria) this;
        }

        public Criteria andPercent2IsNotNull() {
            addCriterion("percent2 is not null");
            return (Criteria) this;
        }

        public Criteria andPercent2EqualTo(BigDecimal value) {
            addCriterion("percent2 =", value, "percent2");
            return (Criteria) this;
        }

        public Criteria andPercent2NotEqualTo(BigDecimal value) {
            addCriterion("percent2 <>", value, "percent2");
            return (Criteria) this;
        }

        public Criteria andPercent2GreaterThan(BigDecimal value) {
            addCriterion("percent2 >", value, "percent2");
            return (Criteria) this;
        }

        public Criteria andPercent2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("percent2 >=", value, "percent2");
            return (Criteria) this;
        }

        public Criteria andPercent2LessThan(BigDecimal value) {
            addCriterion("percent2 <", value, "percent2");
            return (Criteria) this;
        }

        public Criteria andPercent2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("percent2 <=", value, "percent2");
            return (Criteria) this;
        }

        public Criteria andPercent2In(List<BigDecimal> values) {
            addCriterion("percent2 in", values, "percent2");
            return (Criteria) this;
        }

        public Criteria andPercent2NotIn(List<BigDecimal> values) {
            addCriterion("percent2 not in", values, "percent2");
            return (Criteria) this;
        }

        public Criteria andPercent2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("percent2 between", value1, value2, "percent2");
            return (Criteria) this;
        }

        public Criteria andPercent2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("percent2 not between", value1, value2, "percent2");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}