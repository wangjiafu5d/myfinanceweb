package com.chuan.myfinanceweb.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HoldingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HoldingsExample() {
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

        public Criteria andRankIsNull() {
            addCriterion("_rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("_rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("_rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("_rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("_rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("_rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("_rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("_rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("_rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("_rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("_rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("_rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andVolumcompIsNull() {
            addCriterion("volumcomp is null");
            return (Criteria) this;
        }

        public Criteria andVolumcompIsNotNull() {
            addCriterion("volumcomp is not null");
            return (Criteria) this;
        }

        public Criteria andVolumcompEqualTo(String value) {
            addCriterion("volumcomp =", value, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompNotEqualTo(String value) {
            addCriterion("volumcomp <>", value, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompGreaterThan(String value) {
            addCriterion("volumcomp >", value, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompGreaterThanOrEqualTo(String value) {
            addCriterion("volumcomp >=", value, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompLessThan(String value) {
            addCriterion("volumcomp <", value, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompLessThanOrEqualTo(String value) {
            addCriterion("volumcomp <=", value, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompLike(String value) {
            addCriterion("volumcomp like", value, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompNotLike(String value) {
            addCriterion("volumcomp not like", value, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompIn(List<String> values) {
            addCriterion("volumcomp in", values, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompNotIn(List<String> values) {
            addCriterion("volumcomp not in", values, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompBetween(String value1, String value2) {
            addCriterion("volumcomp between", value1, value2, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andVolumcompNotBetween(String value1, String value2) {
            addCriterion("volumcomp not between", value1, value2, "volumcomp");
            return (Criteria) this;
        }

        public Criteria andCjIsNull() {
            addCriterion("cj is null");
            return (Criteria) this;
        }

        public Criteria andCjIsNotNull() {
            addCriterion("cj is not null");
            return (Criteria) this;
        }

        public Criteria andCjEqualTo(Integer value) {
            addCriterion("cj =", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjNotEqualTo(Integer value) {
            addCriterion("cj <>", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjGreaterThan(Integer value) {
            addCriterion("cj >", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjGreaterThanOrEqualTo(Integer value) {
            addCriterion("cj >=", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjLessThan(Integer value) {
            addCriterion("cj <", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjLessThanOrEqualTo(Integer value) {
            addCriterion("cj <=", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjIn(List<Integer> values) {
            addCriterion("cj in", values, "cj");
            return (Criteria) this;
        }

        public Criteria andCjNotIn(List<Integer> values) {
            addCriterion("cj not in", values, "cj");
            return (Criteria) this;
        }

        public Criteria andCjBetween(Integer value1, Integer value2) {
            addCriterion("cj between", value1, value2, "cj");
            return (Criteria) this;
        }

        public Criteria andCjNotBetween(Integer value1, Integer value2) {
            addCriterion("cj not between", value1, value2, "cj");
            return (Criteria) this;
        }

        public Criteria andCjchgIsNull() {
            addCriterion("cjchg is null");
            return (Criteria) this;
        }

        public Criteria andCjchgIsNotNull() {
            addCriterion("cjchg is not null");
            return (Criteria) this;
        }

        public Criteria andCjchgEqualTo(Integer value) {
            addCriterion("cjchg =", value, "cjchg");
            return (Criteria) this;
        }

        public Criteria andCjchgNotEqualTo(Integer value) {
            addCriterion("cjchg <>", value, "cjchg");
            return (Criteria) this;
        }

        public Criteria andCjchgGreaterThan(Integer value) {
            addCriterion("cjchg >", value, "cjchg");
            return (Criteria) this;
        }

        public Criteria andCjchgGreaterThanOrEqualTo(Integer value) {
            addCriterion("cjchg >=", value, "cjchg");
            return (Criteria) this;
        }

        public Criteria andCjchgLessThan(Integer value) {
            addCriterion("cjchg <", value, "cjchg");
            return (Criteria) this;
        }

        public Criteria andCjchgLessThanOrEqualTo(Integer value) {
            addCriterion("cjchg <=", value, "cjchg");
            return (Criteria) this;
        }

        public Criteria andCjchgIn(List<Integer> values) {
            addCriterion("cjchg in", values, "cjchg");
            return (Criteria) this;
        }

        public Criteria andCjchgNotIn(List<Integer> values) {
            addCriterion("cjchg not in", values, "cjchg");
            return (Criteria) this;
        }

        public Criteria andCjchgBetween(Integer value1, Integer value2) {
            addCriterion("cjchg between", value1, value2, "cjchg");
            return (Criteria) this;
        }

        public Criteria andCjchgNotBetween(Integer value1, Integer value2) {
            addCriterion("cjchg not between", value1, value2, "cjchg");
            return (Criteria) this;
        }

        public Criteria andBcompIsNull() {
            addCriterion("bcomp is null");
            return (Criteria) this;
        }

        public Criteria andBcompIsNotNull() {
            addCriterion("bcomp is not null");
            return (Criteria) this;
        }

        public Criteria andBcompEqualTo(String value) {
            addCriterion("bcomp =", value, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompNotEqualTo(String value) {
            addCriterion("bcomp <>", value, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompGreaterThan(String value) {
            addCriterion("bcomp >", value, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompGreaterThanOrEqualTo(String value) {
            addCriterion("bcomp >=", value, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompLessThan(String value) {
            addCriterion("bcomp <", value, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompLessThanOrEqualTo(String value) {
            addCriterion("bcomp <=", value, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompLike(String value) {
            addCriterion("bcomp like", value, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompNotLike(String value) {
            addCriterion("bcomp not like", value, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompIn(List<String> values) {
            addCriterion("bcomp in", values, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompNotIn(List<String> values) {
            addCriterion("bcomp not in", values, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompBetween(String value1, String value2) {
            addCriterion("bcomp between", value1, value2, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBcompNotBetween(String value1, String value2) {
            addCriterion("bcomp not between", value1, value2, "bcomp");
            return (Criteria) this;
        }

        public Criteria andBuyIsNull() {
            addCriterion("buy is null");
            return (Criteria) this;
        }

        public Criteria andBuyIsNotNull() {
            addCriterion("buy is not null");
            return (Criteria) this;
        }

        public Criteria andBuyEqualTo(Integer value) {
            addCriterion("buy =", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyNotEqualTo(Integer value) {
            addCriterion("buy <>", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyGreaterThan(Integer value) {
            addCriterion("buy >", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy >=", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyLessThan(Integer value) {
            addCriterion("buy <", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyLessThanOrEqualTo(Integer value) {
            addCriterion("buy <=", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyIn(List<Integer> values) {
            addCriterion("buy in", values, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyNotIn(List<Integer> values) {
            addCriterion("buy not in", values, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyBetween(Integer value1, Integer value2) {
            addCriterion("buy between", value1, value2, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyNotBetween(Integer value1, Integer value2) {
            addCriterion("buy not between", value1, value2, "buy");
            return (Criteria) this;
        }

        public Criteria andBuychgIsNull() {
            addCriterion("buychg is null");
            return (Criteria) this;
        }

        public Criteria andBuychgIsNotNull() {
            addCriterion("buychg is not null");
            return (Criteria) this;
        }

        public Criteria andBuychgEqualTo(Integer value) {
            addCriterion("buychg =", value, "buychg");
            return (Criteria) this;
        }

        public Criteria andBuychgNotEqualTo(Integer value) {
            addCriterion("buychg <>", value, "buychg");
            return (Criteria) this;
        }

        public Criteria andBuychgGreaterThan(Integer value) {
            addCriterion("buychg >", value, "buychg");
            return (Criteria) this;
        }

        public Criteria andBuychgGreaterThanOrEqualTo(Integer value) {
            addCriterion("buychg >=", value, "buychg");
            return (Criteria) this;
        }

        public Criteria andBuychgLessThan(Integer value) {
            addCriterion("buychg <", value, "buychg");
            return (Criteria) this;
        }

        public Criteria andBuychgLessThanOrEqualTo(Integer value) {
            addCriterion("buychg <=", value, "buychg");
            return (Criteria) this;
        }

        public Criteria andBuychgIn(List<Integer> values) {
            addCriterion("buychg in", values, "buychg");
            return (Criteria) this;
        }

        public Criteria andBuychgNotIn(List<Integer> values) {
            addCriterion("buychg not in", values, "buychg");
            return (Criteria) this;
        }

        public Criteria andBuychgBetween(Integer value1, Integer value2) {
            addCriterion("buychg between", value1, value2, "buychg");
            return (Criteria) this;
        }

        public Criteria andBuychgNotBetween(Integer value1, Integer value2) {
            addCriterion("buychg not between", value1, value2, "buychg");
            return (Criteria) this;
        }

        public Criteria andScompIsNull() {
            addCriterion("scomp is null");
            return (Criteria) this;
        }

        public Criteria andScompIsNotNull() {
            addCriterion("scomp is not null");
            return (Criteria) this;
        }

        public Criteria andScompEqualTo(String value) {
            addCriterion("scomp =", value, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompNotEqualTo(String value) {
            addCriterion("scomp <>", value, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompGreaterThan(String value) {
            addCriterion("scomp >", value, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompGreaterThanOrEqualTo(String value) {
            addCriterion("scomp >=", value, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompLessThan(String value) {
            addCriterion("scomp <", value, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompLessThanOrEqualTo(String value) {
            addCriterion("scomp <=", value, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompLike(String value) {
            addCriterion("scomp like", value, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompNotLike(String value) {
            addCriterion("scomp not like", value, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompIn(List<String> values) {
            addCriterion("scomp in", values, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompNotIn(List<String> values) {
            addCriterion("scomp not in", values, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompBetween(String value1, String value2) {
            addCriterion("scomp between", value1, value2, "scomp");
            return (Criteria) this;
        }

        public Criteria andScompNotBetween(String value1, String value2) {
            addCriterion("scomp not between", value1, value2, "scomp");
            return (Criteria) this;
        }

        public Criteria andSellIsNull() {
            addCriterion("sell is null");
            return (Criteria) this;
        }

        public Criteria andSellIsNotNull() {
            addCriterion("sell is not null");
            return (Criteria) this;
        }

        public Criteria andSellEqualTo(Integer value) {
            addCriterion("sell =", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellNotEqualTo(Integer value) {
            addCriterion("sell <>", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellGreaterThan(Integer value) {
            addCriterion("sell >", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell >=", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellLessThan(Integer value) {
            addCriterion("sell <", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellLessThanOrEqualTo(Integer value) {
            addCriterion("sell <=", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellIn(List<Integer> values) {
            addCriterion("sell in", values, "sell");
            return (Criteria) this;
        }

        public Criteria andSellNotIn(List<Integer> values) {
            addCriterion("sell not in", values, "sell");
            return (Criteria) this;
        }

        public Criteria andSellBetween(Integer value1, Integer value2) {
            addCriterion("sell between", value1, value2, "sell");
            return (Criteria) this;
        }

        public Criteria andSellNotBetween(Integer value1, Integer value2) {
            addCriterion("sell not between", value1, value2, "sell");
            return (Criteria) this;
        }

        public Criteria andSellchgIsNull() {
            addCriterion("sellchg is null");
            return (Criteria) this;
        }

        public Criteria andSellchgIsNotNull() {
            addCriterion("sellchg is not null");
            return (Criteria) this;
        }

        public Criteria andSellchgEqualTo(Integer value) {
            addCriterion("sellchg =", value, "sellchg");
            return (Criteria) this;
        }

        public Criteria andSellchgNotEqualTo(Integer value) {
            addCriterion("sellchg <>", value, "sellchg");
            return (Criteria) this;
        }

        public Criteria andSellchgGreaterThan(Integer value) {
            addCriterion("sellchg >", value, "sellchg");
            return (Criteria) this;
        }

        public Criteria andSellchgGreaterThanOrEqualTo(Integer value) {
            addCriterion("sellchg >=", value, "sellchg");
            return (Criteria) this;
        }

        public Criteria andSellchgLessThan(Integer value) {
            addCriterion("sellchg <", value, "sellchg");
            return (Criteria) this;
        }

        public Criteria andSellchgLessThanOrEqualTo(Integer value) {
            addCriterion("sellchg <=", value, "sellchg");
            return (Criteria) this;
        }

        public Criteria andSellchgIn(List<Integer> values) {
            addCriterion("sellchg in", values, "sellchg");
            return (Criteria) this;
        }

        public Criteria andSellchgNotIn(List<Integer> values) {
            addCriterion("sellchg not in", values, "sellchg");
            return (Criteria) this;
        }

        public Criteria andSellchgBetween(Integer value1, Integer value2) {
            addCriterion("sellchg between", value1, value2, "sellchg");
            return (Criteria) this;
        }

        public Criteria andSellchgNotBetween(Integer value1, Integer value2) {
            addCriterion("sellchg not between", value1, value2, "sellchg");
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