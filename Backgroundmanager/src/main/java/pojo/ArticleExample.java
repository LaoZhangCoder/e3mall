package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
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

        public Criteria andImghrefIsNull() {
            addCriterion("imghref is null");
            return (Criteria) this;
        }

        public Criteria andImghrefIsNotNull() {
            addCriterion("imghref is not null");
            return (Criteria) this;
        }

        public Criteria andImghrefEqualTo(String value) {
            addCriterion("imghref =", value, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefNotEqualTo(String value) {
            addCriterion("imghref <>", value, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefGreaterThan(String value) {
            addCriterion("imghref >", value, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefGreaterThanOrEqualTo(String value) {
            addCriterion("imghref >=", value, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefLessThan(String value) {
            addCriterion("imghref <", value, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefLessThanOrEqualTo(String value) {
            addCriterion("imghref <=", value, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefLike(String value) {
            addCriterion("imghref like", value, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefNotLike(String value) {
            addCriterion("imghref not like", value, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefIn(List<String> values) {
            addCriterion("imghref in", values, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefNotIn(List<String> values) {
            addCriterion("imghref not in", values, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefBetween(String value1, String value2) {
            addCriterion("imghref between", value1, value2, "imghref");
            return (Criteria) this;
        }

        public Criteria andImghrefNotBetween(String value1, String value2) {
            addCriterion("imghref not between", value1, value2, "imghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefIsNull() {
            addCriterion("backimghref is null");
            return (Criteria) this;
        }

        public Criteria andBackimghrefIsNotNull() {
            addCriterion("backimghref is not null");
            return (Criteria) this;
        }

        public Criteria andBackimghrefEqualTo(String value) {
            addCriterion("backimghref =", value, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefNotEqualTo(String value) {
            addCriterion("backimghref <>", value, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefGreaterThan(String value) {
            addCriterion("backimghref >", value, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefGreaterThanOrEqualTo(String value) {
            addCriterion("backimghref >=", value, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefLessThan(String value) {
            addCriterion("backimghref <", value, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefLessThanOrEqualTo(String value) {
            addCriterion("backimghref <=", value, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefLike(String value) {
            addCriterion("backimghref like", value, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefNotLike(String value) {
            addCriterion("backimghref not like", value, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefIn(List<String> values) {
            addCriterion("backimghref in", values, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefNotIn(List<String> values) {
            addCriterion("backimghref not in", values, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefBetween(String value1, String value2) {
            addCriterion("backimghref between", value1, value2, "backimghref");
            return (Criteria) this;
        }

        public Criteria andBackimghrefNotBetween(String value1, String value2) {
            addCriterion("backimghref not between", value1, value2, "backimghref");
            return (Criteria) this;
        }

        public Criteria andAutorIsNull() {
            addCriterion("autor is null");
            return (Criteria) this;
        }

        public Criteria andAutorIsNotNull() {
            addCriterion("autor is not null");
            return (Criteria) this;
        }

        public Criteria andAutorEqualTo(String value) {
            addCriterion("autor =", value, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorNotEqualTo(String value) {
            addCriterion("autor <>", value, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorGreaterThan(String value) {
            addCriterion("autor >", value, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorGreaterThanOrEqualTo(String value) {
            addCriterion("autor >=", value, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorLessThan(String value) {
            addCriterion("autor <", value, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorLessThanOrEqualTo(String value) {
            addCriterion("autor <=", value, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorLike(String value) {
            addCriterion("autor like", value, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorNotLike(String value) {
            addCriterion("autor not like", value, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorIn(List<String> values) {
            addCriterion("autor in", values, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorNotIn(List<String> values) {
            addCriterion("autor not in", values, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorBetween(String value1, String value2) {
            addCriterion("autor between", value1, value2, "autor");
            return (Criteria) this;
        }

        public Criteria andAutorNotBetween(String value1, String value2) {
            addCriterion("autor not between", value1, value2, "autor");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andLiulanliangIsNull() {
            addCriterion("liulanliang is null");
            return (Criteria) this;
        }

        public Criteria andLiulanliangIsNotNull() {
            addCriterion("liulanliang is not null");
            return (Criteria) this;
        }

        public Criteria andLiulanliangEqualTo(Integer value) {
            addCriterion("liulanliang =", value, "liulanliang");
            return (Criteria) this;
        }

        public Criteria andLiulanliangNotEqualTo(Integer value) {
            addCriterion("liulanliang <>", value, "liulanliang");
            return (Criteria) this;
        }

        public Criteria andLiulanliangGreaterThan(Integer value) {
            addCriterion("liulanliang >", value, "liulanliang");
            return (Criteria) this;
        }

        public Criteria andLiulanliangGreaterThanOrEqualTo(Integer value) {
            addCriterion("liulanliang >=", value, "liulanliang");
            return (Criteria) this;
        }

        public Criteria andLiulanliangLessThan(Integer value) {
            addCriterion("liulanliang <", value, "liulanliang");
            return (Criteria) this;
        }

        public Criteria andLiulanliangLessThanOrEqualTo(Integer value) {
            addCriterion("liulanliang <=", value, "liulanliang");
            return (Criteria) this;
        }

        public Criteria andLiulanliangIn(List<Integer> values) {
            addCriterion("liulanliang in", values, "liulanliang");
            return (Criteria) this;
        }

        public Criteria andLiulanliangNotIn(List<Integer> values) {
            addCriterion("liulanliang not in", values, "liulanliang");
            return (Criteria) this;
        }

        public Criteria andLiulanliangBetween(Integer value1, Integer value2) {
            addCriterion("liulanliang between", value1, value2, "liulanliang");
            return (Criteria) this;
        }

        public Criteria andLiulanliangNotBetween(Integer value1, Integer value2) {
            addCriterion("liulanliang not between", value1, value2, "liulanliang");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
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