/*
 * Copyright (c)  2011-2016. 10jqka.com.cn All right reserved. This software is the confidential and proprietary information
 *  of 10jqka.com.cn ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 *  only in accordance with the terms of the license agreement you entered into with 10jqka.com.cn.
 */
package cn.mobilemart.demo.service.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Map;

/**
 * 类BaseDaoSupport.java的实现描述：基础方法DAO接口实现
 *
 * @author Administrator 2012-12-3 下午7:22:42
 */
public class BaseDaoSupport implements BaseDao {

    private static final Logger logger = LoggerFactory.getLogger(BaseDaoSupport.class);

    @Override public int insert(JdbcTemplate jdbcTemplate, String sql, Object... args) {
        debugSql(sql, args);

        return jdbcTemplate.update(sql, args);
    }

    @Override public void delete(JdbcTemplate jdbcTemplate, String sql, Object... args) {
        debugSql(sql, args);

        jdbcTemplate.update(sql, args);

    }

    @Override public int update(JdbcTemplate jdbcTemplate, String sql, Object... args) {
        debugSql(sql, args);

        return jdbcTemplate.update(sql, args);
    }

    @Override public int[] batchUpdate(JdbcTemplate jdbcTemplate, String sql, List<Object[]> batchUpdateParams) {
        return jdbcTemplate.batchUpdate(sql, batchUpdateParams);

    }

    @Override public <T> T queryForObject(JdbcTemplate jdbcTemplate, String sql, Class<T> objectClass, Object... args) {
        return jdbcTemplate.queryForObject(sql, args, objectClass);
    }

    @Override public <T> T findUnique(JdbcTemplate jdbcTemplate, String sql, Class<T> dtoClass, Object... args) {
        debugSql(sql, args);

        RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(dtoClass);

        List<T> list = jdbcTemplate.query(sql, rowMapper, args);
        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    @Override public <T> List<T> findList(JdbcTemplate jdbcTemplate, String sql, Class<T> dtoClass, Object... args) {
        debugSql(sql, args);

        RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(dtoClass);

        return jdbcTemplate.query(sql, rowMapper, args);
    }

    private void debugSql(String sql, Object[] args) {
        if (logger.isDebugEnabled()) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("sql: ");
            buffer.append(sql);
            buffer.append(", args: ");
            for (Object arg : args) {
                buffer.append(arg);
                buffer.append(",");
            }
            buffer.deleteCharAt(buffer.length() - 1);

            logger.debug(buffer.toString());
        }
    }

    @Override public Map<String, Object> queryMap(JdbcTemplate jdbcTemplate, String sql, Object... args) {
        debugSql(sql, args);
        return jdbcTemplate.queryForMap(sql, args);
    }

    @Override public List<Map<String, Object>> queryListMap(JdbcTemplate jdbcTemplate, String sql, Object... args) {
        debugSql(sql, args);
        return jdbcTemplate.queryForList(sql, args);
    }

    @Override public Integer getTotalNum(JdbcTemplate jdbcTemplate, String sql, Object... args) {
        debugSql(sql, args);
        return jdbcTemplate.queryForInt(sql, args);
    }

   /* *//*
     * (non-Javadoc)
     * @see com.myhexin.core.dao.BaseDao#findPage(org.springframework.jdbc.core.JdbcTemplate, java.lang.String, int,
     * int, java.lang.Class, java.lang.Object[])
     *//*
    @Override public <T> Page<T> findPage(JdbcTemplate jdbcTemplate, String sql, Pageable pageable, Class<T> dtoClass,
                                          Object... args) {
        int currentPage = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        StringBuffer countSqlBuf = new StringBuffer();
        countSqlBuf.append("select count(*) from (");
        //countSqlBuf.append(StringUtils.substringBeforeLast(sql, "order"));
        countSqlBuf.append(sql);
        countSqlBuf.append(") tmp_table");
        debugSql(countSqlBuf.toString(), args);

        long total = jdbcTemplate.queryForLong(countSqlBuf.toString(), args);
        Sort sorts = pageable.getSort();
        StringBuffer pageSqlBuf = new StringBuffer();
        pageSqlBuf.append(sql);
        if (sorts != null) {
            Iterator<Order> iterator = sorts.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                if (i == 0) {
                    pageSqlBuf.append(" order by ");
                } else {
                    pageSqlBuf.append(", ");
                }
                Order order = iterator.next();
                pageSqlBuf.append(order.getProperty() + " " + order.getDirection());
                i++;
            }
        }
        pageSqlBuf.append(" limit ");
        pageSqlBuf.append(currentPage * pageSize);
        pageSqlBuf.append(",");
        pageSqlBuf.append(pageSize);
        pageSqlBuf.append(" ");
        debugSql(pageSqlBuf.toString(), args);
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(dtoClass);
        List<T> dataList = jdbcTemplate.query(pageSqlBuf.toString(), rowMapper, args);
        return new PageImplBean<T>(dataList, pageable, total);
    }*/

}
