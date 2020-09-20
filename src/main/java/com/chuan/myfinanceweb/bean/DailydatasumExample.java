package com.chuan.myfinanceweb.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DailydatasumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DailydatasumExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andProductnameIsNull() {
            addCriterion("PRODUCTNAME is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("PRODUCTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("PRODUCTNAME =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("PRODUCTNAME <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("PRODUCTNAME >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTNAME >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("PRODUCTNAME <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTNAME <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("PRODUCTNAME like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("PRODUCTNAME not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("PRODUCTNAME in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("PRODUCTNAME not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("PRODUCTNAME between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("PRODUCTNAME not between", value1, value2, "productname");
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

        public Criteria andHighestpriceEqualTo(Double value) {
            addCriterion("HIGHESTPRICE =", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceNotEqualTo(Double value) {
            addCriterion("HIGHESTPRICE <>", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceGreaterThan(Double value) {
            addCriterion("HIGHESTPRICE >", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("HIGHESTPRICE >=", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceLessThan(Double value) {
            addCriterion("HIGHESTPRICE <", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceLessThanOrEqualTo(Double value) {
            addCriterion("HIGHESTPRICE <=", value, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceIn(List<Double> values) {
            addCriterion("HIGHESTPRICE in", values, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceNotIn(List<Double> values) {
            addCriterion("HIGHESTPRICE not in", values, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceBetween(Double value1, Double value2) {
            addCriterion("HIGHESTPRICE between", value1, value2, "highestprice");
            return (Criteria) this;
        }

        public Criteria andHighestpriceNotBetween(Double value1, Double value2) {
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

        public Criteria andLowestpriceEqualTo(Double value) {
            addCriterion("LOWESTPRICE =", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceNotEqualTo(Double value) {
            addCriterion("LOWESTPRICE <>", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceGreaterThan(Double value) {
            addCriterion("LOWESTPRICE >", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("LOWESTPRICE >=", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceLessThan(Double value) {
            addCriterion("LOWESTPRICE <", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceLessThanOrEqualTo(Double value) {
            addCriterion("LOWESTPRICE <=", value, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceIn(List<Double> values) {
            addCriterion("LOWESTPRICE in", values, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceNotIn(List<Double> values) {
            addCriterion("LOWESTPRICE not in", values, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceBetween(Double value1, Double value2) {
            addCriterion("LOWESTPRICE between", value1, value2, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andLowestpriceNotBetween(Double value1, Double value2) {
            addCriterion("LOWESTPRICE not between", value1, value2, "lowestprice");
            return (Criteria) this;
        }

        public Criteria andAvgpriceIsNull() {
            addCriterion("AVGPRICE is null");
            return (Criteria) this;
        }

        public Criteria andAvgpriceIsNotNull() {
            addCriterion("AVGPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andAvgpriceEqualTo(Double value) {
            addCriterion("AVGPRICE =", value, "avgprice");
            return (Criteria) this;
        }

        public Criteria andAvgpriceNotEqualTo(Double value) {
            addCriterion("AVGPRICE <>", value, "avgprice");
            return (Criteria) this;
        }

        public Criteria andAvgpriceGreaterThan(Double value) {
            addCriterion("AVGPRICE >", value, "avgprice");
            return (Criteria) this;
        }

        public Criteria andAvgpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("AVGPRICE >=", value, "avgprice");
            return (Criteria) this;
        }

        public Criteria andAvgpriceLessThan(Double value) {
            addCriterion("AVGPRICE <", value, "avgprice");
            return (Criteria) this;
        }

        public Criteria andAvgpriceLessThanOrEqualTo(Double value) {
            addCriterion("AVGPRICE <=", value, "avgprice");
            return (Criteria) this;
        }

        public Criteria andAvgpriceIn(List<Double> values) {
            addCriterion("AVGPRICE in", values, "avgprice");
            return (Criteria) this;
        }

        public Criteria andAvgpriceNotIn(List<Double> values) {
            addCriterion("AVGPRICE not in", values, "avgprice");
            return (Criteria) this;
        }

        public Criteria andAvgpriceBetween(Double value1, Double value2) {
            addCriterion("AVGPRICE between", value1, value2, "avgprice");
            return (Criteria) this;
        }

        public Criteria andAvgpriceNotBetween(Double value1, Double value2) {
            addCriterion("AVGPRICE not between", value1, value2, "avgprice");
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

        public Criteria andTurnoverIsNull() {
            addCriterion("TURNOVER is null");
            return (Criteria) this;
        }

        public Criteria andTurnoverIsNotNull() {
            addCriterion("TURNOVER is not null");
            return (Criteria) this;
        }

        public Criteria andTurnoverEqualTo(Double value) {
            addCriterion("TURNOVER =", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotEqualTo(Double value) {
            addCriterion("TURNOVER <>", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThan(Double value) {
            addCriterion("TURNOVER >", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverGreaterThanOrEqualTo(Double value) {
            addCriterion("TURNOVER >=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThan(Double value) {
            addCriterion("TURNOVER <", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverLessThanOrEqualTo(Double value) {
            addCriterion("TURNOVER <=", value, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverIn(List<Double> values) {
            addCriterion("TURNOVER in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotIn(List<Double> values) {
            addCriterion("TURNOVER not in", values, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverBetween(Double value1, Double value2) {
            addCriterion("TURNOVER between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andTurnoverNotBetween(Double value1, Double value2) {
            addCriterion("TURNOVER not between", value1, value2, "turnover");
            return (Criteria) this;
        }

        public Criteria andYearvolumeIsNull() {
            addCriterion("YEARVOLUME is null");
            return (Criteria) this;
        }

        public Criteria andYearvolumeIsNotNull() {
            addCriterion("YEARVOLUME is not null");
            return (Criteria) this;
        }

        public Criteria andYearvolumeEqualTo(Double value) {
            addCriterion("YEARVOLUME =", value, "yearvolume");
            return (Criteria) this;
        }

        public Criteria andYearvolumeNotEqualTo(Double value) {
            addCriterion("YEARVOLUME <>", value, "yearvolume");
            return (Criteria) this;
        }

        public Criteria andYearvolumeGreaterThan(Double value) {
            addCriterion("YEARVOLUME >", value, "yearvolume");
            return (Criteria) this;
        }

        public Criteria andYearvolumeGreaterThanOrEqualTo(Double value) {
            addCriterion("YEARVOLUME >=", value, "yearvolume");
            return (Criteria) this;
        }

        public Criteria andYearvolumeLessThan(Double value) {
            addCriterion("YEARVOLUME <", value, "yearvolume");
            return (Criteria) this;
        }

        public Criteria andYearvolumeLessThanOrEqualTo(Double value) {
            addCriterion("YEARVOLUME <=", value, "yearvolume");
            return (Criteria) this;
        }

        public Criteria andYearvolumeIn(List<Double> values) {
            addCriterion("YEARVOLUME in", values, "yearvolume");
            return (Criteria) this;
        }

        public Criteria andYearvolumeNotIn(List<Double> values) {
            addCriterion("YEARVOLUME not in", values, "yearvolume");
            return (Criteria) this;
        }

        public Criteria andYearvolumeBetween(Double value1, Double value2) {
            addCriterion("YEARVOLUME between", value1, value2, "yearvolume");
            return (Criteria) this;
        }

        public Criteria andYearvolumeNotBetween(Double value1, Double value2) {
            addCriterion("YEARVOLUME not between", value1, value2, "yearvolume");
            return (Criteria) this;
        }

        public Criteria andYearturnoverIsNull() {
            addCriterion("YEARTURNOVER is null");
            return (Criteria) this;
        }

        public Criteria andYearturnoverIsNotNull() {
            addCriterion("YEARTURNOVER is not null");
            return (Criteria) this;
        }

        public Criteria andYearturnoverEqualTo(Double value) {
            addCriterion("YEARTURNOVER =", value, "yearturnover");
            return (Criteria) this;
        }

        public Criteria andYearturnoverNotEqualTo(Double value) {
            addCriterion("YEARTURNOVER <>", value, "yearturnover");
            return (Criteria) this;
        }

        public Criteria andYearturnoverGreaterThan(Double value) {
            addCriterion("YEARTURNOVER >", value, "yearturnover");
            return (Criteria) this;
        }

        public Criteria andYearturnoverGreaterThanOrEqualTo(Double value) {
            addCriterion("YEARTURNOVER >=", value, "yearturnover");
            return (Criteria) this;
        }

        public Criteria andYearturnoverLessThan(Double value) {
            addCriterion("YEARTURNOVER <", value, "yearturnover");
            return (Criteria) this;
        }

        public Criteria andYearturnoverLessThanOrEqualTo(Double value) {
            addCriterion("YEARTURNOVER <=", value, "yearturnover");
            return (Criteria) this;
        }

        public Criteria andYearturnoverIn(List<Double> values) {
            addCriterion("YEARTURNOVER in", values, "yearturnover");
            return (Criteria) this;
        }

        public Criteria andYearturnoverNotIn(List<Double> values) {
            addCriterion("YEARTURNOVER not in", values, "yearturnover");
            return (Criteria) this;
        }

        public Criteria andYearturnoverBetween(Double value1, Double value2) {
            addCriterion("YEARTURNOVER between", value1, value2, "yearturnover");
            return (Criteria) this;
        }

        public Criteria andYearturnoverNotBetween(Double value1, Double value2) {
            addCriterion("YEARTURNOVER not between", value1, value2, "yearturnover");
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