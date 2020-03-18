package net.work100.training.stage2.iot.cloud.commons.dao;

import net.work100.training.stage2.iot.cloud.commons.dto.AbstractBaseDomain;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: BaseDao</p>
 * <p>Description: 通用 DAO 接口</p>
 *
 * @author liuxiaojun
 * @date 2020-03-18 09:11
 * ------------------- History -------------------
 * <date>      <author>       <desc>
 * 2020-03-18   liuxiaojun     初始创建
 * -----------------------------------------------
 */
public interface BaseDao<T extends AbstractBaseDomain> {

    /**
     * 查询全部表记录
     *
     * @return
     */
    List<T> selectAll();


    /**
     * 新增
     *
     * @param entity
     */
    void insert(T entity);

    /**
     * 更新
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 删除
     *
     * @param entityKey
     */
    void delete(String entityKey);

    /**
     * 批量删除
     *
     * @param entityKeys
     */
    void multiDelete(String[] entityKeys);

    /**
     * 获取单个对象
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 获取单个对象
     *
     * @param entityKey 实体对象Key
     * @return
     */
    T getByKey(String entityKey);

    /**
     * 搜索
     *
     * @param entity 查询条件
     * @return
     */
    List<T> search(T entity);

    /**
     * 分页查询
     *
     * @param params 查询条件及分页参数
     * @return
     */
    List<T> pageSearch(Map<String, Object> params);

    /**
     * 计数统计
     *
     * @param entity 查询条件
     * @return
     */
    int count(T entity);
}
