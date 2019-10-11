package com.louis.kitty.admin.sevice.impl;

import com.louis.kitty.admin.dao.GoodsMapper;
import com.louis.kitty.admin.dao.SysDeptMapper;
import com.louis.kitty.admin.model.Goods;
import com.louis.kitty.admin.model.SysDept;
import com.louis.kitty.admin.sevice.GoodService;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int save(Goods record) {
        if(record.getId() == null || record.getId() == 0) {
            return goodsMapper.insertSelective(record);
        }
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(Goods record) {
        return goodsMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<Goods> records) {
        for(Goods record:records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public Goods findById(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, goodsMapper);
    }

    @Override
    public List<Goods> findTree() {
        List<Goods> sysDepts = new ArrayList<>();
        List<Goods> depts = goodsMapper.findAll();
//        for (Goods dept : depts) {
//            if (dept.getParentId() == null || dept.getParentId() == 0) {
//                dept.setLevel(0);
//                sysDepts.add(dept);
//            }
//        }
        findChildren(sysDepts, depts);
        return sysDepts;
    }

    private void findChildren(List<Goods> sysDepts, List<Goods> depts) {
        for (Goods sysDept : sysDepts) {
            List<Goods> children = new ArrayList<>();
//            for (Goods dept : depts) {
//                if (sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())) {
//                    dept.setParentName(dept.getName());
//                    dept.setLevel(sysDept.getLevel() + 1);
//                    children.add(dept);
//                }
//            }
//            sysDept.setChildren(children);
            findChildren(children, depts);
        }
    }

}
