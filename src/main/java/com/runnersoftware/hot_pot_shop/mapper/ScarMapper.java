package com.runnersoftware.hot_pot_shop.mapper;

import com.runnersoftware.hot_pot_shop.model.Scar;
import com.runnersoftware.hot_pot_shop.model.vo.ScarVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Scar)表数据库访问层
 *
 * @author
 * @since 2021-06-02 15:42:07
 */
public interface ScarMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Scar queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Scar> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param scar 实例对象
     * @return 对象列表
     */
    List<ScarVo> queryAll(ScarVo scar);

    /**
     * 新增数据
     *
     * @param scar 实例对象
     * @return 影响行数
     */
    int insert(Scar scar);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Scar> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Scar> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Scar> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Scar> entities);

    /**
     * 修改数据
     *
     * @param scar 实例对象
     * @return 影响行数
     */
    int update(Scar scar);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

