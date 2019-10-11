package com.louis.kitty.admin.sevice;

import com.louis.kitty.admin.model.Goods;
import com.louis.kitty.admin.model.SysDept;
import com.louis.kitty.core.service.CurdService;

import java.util.List;

public interface GoodService extends CurdService<Goods> {
    List<Goods> findTree();
}
