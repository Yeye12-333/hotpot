package com.runnersoftware.hot_pot_shop.service.impl;

import com.runnersoftware.hot_pot_shop.model.Scar;
import com.runnersoftware.hot_pot_shop.mapper.ScarMapper;
import com.runnersoftware.hot_pot_shop.model.vo.ScarVo;
import com.runnersoftware.hot_pot_shop.service.ScarService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * (Scar)表服务实现类
 *
 * @author
 * @since 2021-06-02 15:42:07
 */
@Service("scarService")
public class ScarServiceImpl implements ScarService {
    @Resource
    private ScarMapper scarMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Scar queryById(Integer id) {
        return this.scarMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Scar> queryAllByLimit(int offset, int limit) {
        return this.scarMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param scar 实例对象
     * @return 实例对象
     */
    @Override
    public Scar insert(Scar scar) {
        ScarVo scarVo = new ScarVo();
        BeanUtils.copyProperties(scar, scarVo);
        scarVo.setQuantity(null);
        List<ScarVo> scars = scarMapper.queryAll(scarVo);
        if (scars.size() > 0){
            scar.setQuantity(scars.get(0).getQuantity() + 1);
            scar.setId(scars.get(0).getId());
            this.scarMapper.update(scar);
        }else {
            this.scarMapper.insert(scar);
        }
        return scar;
    }

    /**
     * 修改数据
     *
     * @param scar 实例对象
     * @return 实例对象
     */
    @Override
    public Scar update(Scar scar) {
        this.scarMapper.update(scar);
        return this.queryById(scar.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.scarMapper.deleteById(id) > 0;
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
        List<ScarVo> models = scarMapper.queryAll((ScarVo) params.get("entity"));
        map.put("rows", models);
        return map;
    }
}
