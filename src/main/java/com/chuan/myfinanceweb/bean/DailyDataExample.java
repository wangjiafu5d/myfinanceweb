package com.chuan.myfinanceweb.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DailyDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DailyDataExample() {
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

        public Criteria andDelivermonthIsNull() {
            addCriterion("delivermonth is null");
            return (Criteria) this;
        }

        public Criteria andDelivermonthIsNotNull() {
            addCriterion("delivermonth is not null");
            return (Criteria) this;
        }

        public Criteria andDelivermonthEqualTo(String value) {
            addCriterion("delivermonth =", value, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthNotEqualTo(String value) {
            addCriterion("delivermonth <>", value, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthGreaterThan(String value) {
            addCriterion("delivermonth >", value, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthGreaterThanOrEqualTo(String value) {
            addCriterion("delivermonth >=", value, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthLessThan(String value) {
            addCriterion("delivermonth <", value, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthLessThanOrEqualTo(String value) {
            addCriterion("delivermonth <=", value, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthLike(String value) {
            addCriterion("delivermonth like", value, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthNotLike(String value) {
            addCriterion("delivermonth not like", value, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthIn(List<String> values) {
            addCriterion("delivermonth in", values, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthNotIn(List<String> values) {
            addCriterion("delivermonth not in", values, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthBetween(String value1, String value2) {
            addCriterion("delivermonth between", value1, value2, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andDelivermonthNotBetween(String value1, String value2) {
            addCriterion("delivermonth not between", value1, value2, "delivermonth");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceIsNull() {
            addCriterion("PRESETTLEMENTPRICE is null");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceIsNotNull() {
            addCriterion("PRESETTLEMENTPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceEqualTo(BigDecimal value) {
            addCriterion("PRESETTLEMENTPRICE =", value, "presettlementprice");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceNotEqualTo(BigDecimal value) {
            addCriterion("PRESETTLEMENTPRICE <>", value, "presettlementprice");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceGreaterThan(BigDecimal value) {
            addCriterion("PRESETTLEMENTPRICE >", value, "presettlementprice");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRESETTLEMENTPRICE >=", value, "presettlementprice");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceLessThan(BigDecimal value) {
            addCriterion("PRESETTLEMENTPRICE <", value, "presettlementprice");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRESETTLEMENTPRICE <=", value, "presettlementprice");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceIn(List<BigDecimal> values) {
            addCriterion("PRESETTLEMENTPRICE in", values, "presettlementprice");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceNotIn(List<BigDecimal> values) {
            addCriterion("PRESETTLEMENTPRICE not in", values, "presettlementprice");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRESETTLEMENTPRICE between", value1, value2, "presettlementprice");
            return (Criteria) this;
        }

        public Criteria andPresettlementpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRESETTLEMENTPRICE not between", value1, value2, "presettlementprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceIsNull() {
            addCriterion("OPENPRICE is null");
            return (Criteria) this;
        }

        public Criteria andOpenpriceIsNotNull() {
            addCriterion("OPENPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenpriceEqualTo(BigDecimal value) {
            addCriterion("OPENPRICE =", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceNotEqualTo(BigDecimal value) {
            addCriterion("OPENPRICE <>", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceGreaterThan(BigDecimal value) {
            addCriterion("OPENPRICE >", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OPENPRICE >=", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceLessThan(BigDecimal value) {
            addCriterion("OPENPRICE <", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OPENPRICE <=", value, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceIn(List<BigDecimal> values) {
            addCriterion("OPENPRICE in", values, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceNotIn(List<BigDecimal> values) {
            addCriterion("OPENPRICE not in", values, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPENPRICE between", value1, value2, "openprice");
            return (Criteria) this;
        }

        public Criteria andOpenpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPENPRICE not between", value1, value2, "openprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceIsNull() {
            addCriterion("HIGHESTPRICE is null");
            return (Criteria) this;
        }

        public Criteria andHighestpriceIsNotNull() {
            addCriterion("HIGHESTPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andHighestpriceEqualTo(BigDecimal value) {
            addCriterion("HIGHESTPRICE =", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceNotEqualTo(BigDecimal value) {
            addCriterion("HIGHESTPRICE <>", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceGreaterThan(BigDecimal value) {
            addCriterion("HIGHESTPRICE >", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HIGHESTPRICE >=", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceLessThan(BigDecimal value) {
            addCriterion("HIGHESTPRICE <", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HIGHESTPRICE <=", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceIn(List<BigDecimal> values) {
            addCriterion("HIGHESTPRICE in", values, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceNotIn(List<BigDecimal> values) {
            addCriterion("HIGHESTPRICE not in", values, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HIGHESTPRICE between", value1, value2, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HIGHESTPRICE not between", value1, value2, "highestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceIsNull() {
            addCriterion("LOWESTPRICE is null");
            return (Criteria) this;
        }

        public Criteria andLowestpriceIsNotNull() {
            addCriterion("LOWESTPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andLowestpriceEqualTo(BigDecimal value) {
            addCriterion("LOWESTPRICE =", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceNotEqualTo(BigDecimal value) {
            addCriterion("LOWESTPRICE <>", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceGreaterThan(BigDecimal value) {
            addCriterion("LOWESTPRICE >", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOWESTPRICE >=", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceLessThan(BigDecimal value) {
            addCriterion("LOWESTPRICE <", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOWESTPRICE <=", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceIn(List<BigDecimal> values) {
            addCriterion("LOWESTPRICE in", values, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceNotIn(List<BigDecimal> values) {
            addCriterion("LOWESTPRICE not in", values, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOWESTPRICE between", value1, value2, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOWESTPRICE not between", value1, value2, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceIsNull() {
            addCriterion("CLOSEPRICE is null");
            return (Criteria) this;
        }

        public Criteria andClosepriceIsNotNull() {
            addCriterion("CLOSEPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andClosepriceEqualTo(BigDecimal value) {
            addCriterion("CLOSEPRICE =", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceNotEqualTo(BigDecimal value) {
            addCriterion("CLOSEPRICE <>", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceGreaterThan(BigDecimal value) {
            addCriterion("CLOSEPRICE >", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CLOSEPRICE >=", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceLessThan(BigDecimal value) {
            addCriterion("CLOSEPRICE <", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CLOSEPRICE <=", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceIn(List<BigDecimal> values) {
            addCriterion("CLOSEPRICE in", values, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceNotIn(List<BigDecimal> values) {
            addCriterion("CLOSEPRICE not in", values, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLOSEPRICE between", value1, value2, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLOSEPRICE not between", value1, value2, "closeprice");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceIsNull() {
            addCriterion("SETTLEMENTPRICE is null");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceIsNotNull() {
            addCriterion("SETTLEMENTPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceEqualTo(BigDecimal value) {
            addCriterion("SETTLEMENTPRICE =", value, "settlementprice");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceNotEqualTo(BigDecimal value) {
            addCriterion("SETTLEMENTPRICE <>", value, "settlementprice");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceGreaterThan(BigDecimal value) {
            addCriterion("SETTLEMENTPRICE >", value, "settlementprice");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLEMENTPRICE >=", value, "settlementprice");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceLessThan(BigDecimal value) {
            addCriterion("SETTLEMENTPRICE <", value, "settlementprice");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLEMENTPRICE <=", value, "settlementprice");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceIn(List<BigDecimal> values) {
            addCriterion("SETTLEMENTPRICE in", values, "settlementprice");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceNotIn(List<BigDecimal> values) {
            addCriterion("SETTLEMENTPRICE not in", values, "settlementprice");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLEMENTPRICE between", value1, value2, "settlementprice");
            return (Criteria) this;
        }

        public Criteria andSettlementpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLEMENTPRICE not between", value1, value2, "settlementprice");
            return (Criteria) this;
        }

        public Criteria andZd1ChgIsNull() {
            addCriterion("ZD1_CHG is null");
            return (Criteria) this;
        }

        public Criteria andZd1ChgIsNotNull() {
            addCriterion("ZD1_CHG is not null");
            return (Criteria) this;
        }

        public Criteria andZd1ChgEqualTo(BigDecimal value) {
            addCriterion("ZD1_CHG =", value, "zd1Chg");
            return (Criteria) this;
        }

        public Criteria andZd1ChgNotEqualTo(BigDecimal value) {
            addCriterion("ZD1_CHG <>", value, "zd1Chg");
            return (Criteria) this;
        }

        public Criteria andZd1ChgGreaterThan(BigDecimal value) {
            addCriterion("ZD1_CHG >", value, "zd1Chg");
            return (Criteria) this;
        }

        public Criteria andZd1ChgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZD1_CHG >=", value, "zd1Chg");
            return (Criteria) this;
        }

        public Criteria andZd1ChgLessThan(BigDecimal value) {
            addCriterion("ZD1_CHG <", value, "zd1Chg");
            return (Criteria) this;
        }

        public Criteria andZd1ChgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZD1_CHG <=", value, "zd1Chg");
            return (Criteria) this;
        }

        public Criteria andZd1ChgIn(List<BigDecimal> values) {
            addCriterion("ZD1_CHG in", values, "zd1Chg");
            return (Criteria) this;
        }

        public Criteria andZd1ChgNotIn(List<BigDecimal> values) {
            addCriterion("ZD1_CHG not in", values, "zd1Chg");
            return (Criteria) this;
        }

        public Criteria andZd1ChgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZD1_CHG between", value1, value2, "zd1Chg");
            return (Criteria) this;
        }

        public Criteria andZd1ChgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZD1_CHG not between", value1, value2, "zd1Chg");
            return (Criteria) this;
        }

        public Criteria andZd2ChgIsNull() {
            addCriterion("ZD2_CHG is null");
            return (Criteria) this;
        }

        public Criteria andZd2ChgIsNotNull() {
            addCriterion("ZD2_CHG is not null");
            return (Criteria) this;
        }

        public Criteria andZd2ChgEqualTo(BigDecimal value) {
            addCriterion("ZD2_CHG =", value, "zd2Chg");
            return (Criteria) this;
        }

        public Criteria andZd2ChgNotEqualTo(BigDecimal value) {
            addCriterion("ZD2_CHG <>", value, "zd2Chg");
            return (Criteria) this;
        }

        public Criteria andZd2ChgGreaterThan(BigDecimal value) {
            addCriterion("ZD2_CHG >", value, "zd2Chg");
            return (Criteria) this;
        }

        public Criteria andZd2ChgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZD2_CHG >=", value, "zd2Chg");
            return (Criteria) this;
        }

        public Criteria andZd2ChgLessThan(BigDecimal value) {
            addCriterion("ZD2_CHG <", value, "zd2Chg");
            return (Criteria) this;
        }

        public Criteria andZd2ChgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZD2_CHG <=", value, "zd2Chg");
            return (Criteria) this;
        }

        public Criteria andZd2ChgIn(List<BigDecimal> values) {
            addCriterion("ZD2_CHG in", values, "zd2Chg");
            return (Criteria) this;
        }

        public Criteria andZd2ChgNotIn(List<BigDecimal> values) {
            addCriterion("ZD2_CHG not in", values, "zd2Chg");
            return (Criteria) this;
        }

        public Criteria andZd2ChgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZD2_CHG between", value1, value2, "zd2Chg");
            return (Criteria) this;
        }

        public Criteria andZd2ChgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZD2_CHG not between", value1, value2, "zd2Chg");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("VOLUME is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("VOLUME is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(Integer value) {
            addCriterion("VOLUME =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(Integer value) {
            addCriterion("VOLUME <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(Integer value) {
            addCriterion("VOLUME >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("VOLUME >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(Integer value) {
            addCriterion("VOLUME <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("VOLUME <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<Integer> values) {
            addCriterion("VOLUME in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<Integer> values) {
            addCriterion("VOLUME not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(Integer value1, Integer value2) {
            addCriterion("VOLUME between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("VOLUME not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andOpeninterestIsNull() {
            addCriterion("OPENINTEREST is null");
            return (Criteria) this;
        }

        public Criteria andOpeninterestIsNotNull() {
            addCriterion("OPENINTEREST is not null");
            return (Criteria) this;
        }

        public Criteria andOpeninterestEqualTo(Integer value) {
            addCriterion("OPENINTEREST =", value, "openinterest");
            return (Criteria) this;
        }

        public Criteria andOpeninterestNotEqualTo(Integer value) {
            addCriterion("OPENINTEREST <>", value, "openinterest");
            return (Criteria) this;
        }

        public Criteria andOpeninterestGreaterThan(Integer value) {
            addCriterion("OPENINTEREST >", value, "openinterest");
            return (Criteria) this;
        }

        public Criteria andOpeninterestGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPENINTEREST >=", value, "openinterest");
            return (Criteria) this;
        }

        public Criteria andOpeninterestLessThan(Integer value) {
            addCriterion("OPENINTEREST <", value, "openinterest");
            return (Criteria) this;
        }

        public Criteria andOpeninterestLessThanOrEqualTo(Integer value) {
            addCriterion("OPENINTEREST <=", value, "openinterest");
            return (Criteria) this;
        }

        public Criteria andOpeninterestIn(List<Integer> values) {
            addCriterion("OPENINTEREST in", values, "openinterest");
            return (Criteria) this;
        }

        public Criteria andOpeninterestNotIn(List<Integer> values) {
            addCriterion("OPENINTEREST not in", values, "openinterest");
            return (Criteria) this;
        }

        public Criteria andOpeninterestBetween(Integer value1, Integer value2) {
            addCriterion("OPENINTEREST between", value1, value2, "openinterest");
            return (Criteria) this;
        }

        public Criteria andOpeninterestNotBetween(Integer value1, Integer value2) {
            addCriterion("OPENINTEREST not between", value1, value2, "openinterest");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgIsNull() {
            addCriterion("OPENINTERESTCHG is null");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgIsNotNull() {
            addCriterion("OPENINTERESTCHG is not null");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgEqualTo(Integer value) {
            addCriterion("OPENINTERESTCHG =", value, "openinterestchg");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgNotEqualTo(Integer value) {
            addCriterion("OPENINTERESTCHG <>", value, "openinterestchg");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgGreaterThan(Integer value) {
            addCriterion("OPENINTERESTCHG >", value, "openinterestchg");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPENINTERESTCHG >=", value, "openinterestchg");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgLessThan(Integer value) {
            addCriterion("OPENINTERESTCHG <", value, "openinterestchg");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgLessThanOrEqualTo(Integer value) {
            addCriterion("OPENINTERESTCHG <=", value, "openinterestchg");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgIn(List<Integer> values) {
            addCriterion("OPENINTERESTCHG in", values, "openinterestchg");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgNotIn(List<Integer> values) {
            addCriterion("OPENINTERESTCHG not in", values, "openinterestchg");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgBetween(Integer value1, Integer value2) {
            addCriterion("OPENINTERESTCHG between", value1, value2, "openinterestchg");
            return (Criteria) this;
        }

        public Criteria andOpeninterestchgNotBetween(Integer value1, Integer value2) {
            addCriterion("OPENINTERESTCHG not between", value1, value2, "openinterestchg");
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