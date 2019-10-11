package com.louis.kitty.admin.dao;

import com.louis.kitty.admin.model.Goods;
import com.louis.kitty.admin.model.SysDept;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> findPage();

    List<Goods> findAll();
}
