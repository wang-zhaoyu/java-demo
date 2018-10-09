/*
 * Copyright 2011-2015 10jqka.com.cn All right reserved. This software is the confidential and proprietary information
 * of 10jqka.com.cn ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with 10jqka.com.cn.
 */
package cn.mobilemart.demo.service.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 类BaseDao.java的实现描述：基础方法DAO接口
 *
 * @author Administrator 2012-12-3 下午6:16:15
 */
public interface BaseDao {

    /**
     * 插入数据
     *
     * @param jdbcTemplate jdbc操作模板
     * @param sql          sql语句
     * @param args         条件参数
     */
    public int insert(JdbcTemplate jdbcTemplate, String sql, Object... args);

    /**
     * 删除数据
     *
     * @param jdbcTemplate jdbc操作模板
     * @param sql          sql语句
     * @param args         条件参数
     */
    public void delete(JdbcTemplate jdbcTemplate, String sql, Object... args);

    /**
     * 更新数据
     *
     * @param jdbcTemplate jdbc操作模板
     * @param sql          sql语句
     * @param args         条件参数
     */
    public int update(JdbcTemplate jdbcTemplate, String sql, Object... args);

    /**
     * 批量更新操作
     *
     * @param jdbcTemplate      jdbc操作模板
     * @param sql               sql语句
     * @param batchUpdateParams 批量更新参数
     */
    public int[] batchUpdate(JdbcTemplate jdbcTemplate, String sql, List<Object[]> batchUpdateParams);

    /**
     * 查询唯一记录
     *
     * @param jdbcTemplate jdbc操作模板
     * @param sql          sql语句
     * @param dtoClass     映射的类
     * @param args         条件参数
     * @return 对应映射类实体
     */
    public <T> T findUnique(JdbcTemplate jdbcTemplate, String sql, Class<T> dtoClass, Object... args);

    /**
     * 查询一个列值
     *
     * @param jdbcTemplate jdbc操作模板
     * @param sql          select name from t_user
     * @param objectClass  非实体对象的class
     */
    public <T> T queryForObject(JdbcTemplate jdbcTemplate, String sql, Class<T> objectClass, Object... args);

    /**
     * 查询一个实体几个列的值
     *
     * @param jdbcTemplate jdbc操作模板
     * @param sql          select name,password from t_user
     */
    public Map<String, Object> queryMap(JdbcTemplate jdbcTemplate, String sql, Object... args);

    /**
     * 查询一个实体几个列值的集合
     *
     * @param jdbcTemplate jdbc操作模板
     * @param sql          select name,password from t_user
     */
    public List<Map<String, Object>> queryListMap(JdbcTemplate jdbcTemplate, String sql, Object... args);

    /**
     * 获取指定条件数据条数
     *
     * @param jdbcTemplate jdbc操作模板
     */
    public Integer getTotalNum(JdbcTemplate jdbcTemplate, String sql, Object... args);

    /**
     * 查询记录集
     *
     * @param jdbcTemplate jdbc操作模板
     * @param sql          sql语句
     * @param dtoClass     映射的类
     * @param args         条件参数
     * @return 对应包含映射类实体的记录集
     */
    public <T> List<T> findList(JdbcTemplate jdbcTemplate, String sql, Class<T> dtoClass, Object... args);

  /*  *//**
     * 查询分页记录
     *
     * @param jdbcTemplate jdbc操作模板
     * @param sql          sql语句
     * @param pageable     页面设置
     * @param dtoClass     映射的类
     * @param args         条件参数
     * @return 对应包含映射类实体的分页
     *//*
    public <T> Page<T> findPage(JdbcTemplate jdbcTemplate, String sql, Pageable pageable, Class<T> dtoClass,
                                Object... args);
*/
}
