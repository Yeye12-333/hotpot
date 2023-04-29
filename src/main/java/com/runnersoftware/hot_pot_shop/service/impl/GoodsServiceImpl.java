package com.runnersoftware.hot_pot_shop.service.impl;

import com.runnersoftware.hot_pot_shop.model.Goods;
import com.runnersoftware.hot_pot_shop.mapper.GoodsMapper;
import com.runnersoftware.hot_pot_shop.service.GoodsService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * (Goods)表服务实现类
 *
 * @author
 * @since 2021-06-02 15:42:04
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Integer id) {
        return this.goodsMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Goods> queryAllByLimit(int offset, int limit) {
        return this.goodsMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods insert(Goods goods) {
        this.goodsMapper.insert(goods);
        return goods;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(Goods goods) {
        this.goodsMapper.update(goods);
        return this.queryById(goods.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.goodsMapper.deleteById(id) > 0;
    }


    /**
     * 通过主键删除数据
     *
     * @param params 分页参数
     * @return 分页结果集
     */
    @Override
    public Map<String, Object> findAllByPage(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<String, Object>(3);
        Page<Goods> page = PageHelper.startPage(Integer.parseInt(params.get("pageNum").toString()), Integer.parseInt(params.get("pageSize").toString()));
        List<Goods> models = goodsMapper.queryAll((Goods) params.get("entity"));
        map.put("rows", models);
        map.put("count", page.getTotal());
        return map;
    }
}
