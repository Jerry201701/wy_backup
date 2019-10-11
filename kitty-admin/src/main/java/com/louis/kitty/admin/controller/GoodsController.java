package com.louis.kitty.admin.controller;

import com.louis.kitty.admin.model.Goods;
import com.louis.kitty.admin.model.SysDept;
import com.louis.kitty.admin.sevice.GoodService;
import com.louis.kitty.admin.sevice.SysDeptService;
import com.louis.kitty.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiu
 */
@RestController
@RequestMapping("goods")
public class GoodsController {


    @Autowired
    private GoodService goodService;

   // @PreAuthorize("hasAuthority('sys:dept:add') AND hasAuthority('sys:dept:edit')")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody Goods record) {
        return HttpResult.ok(goodService.save(record));
    }

   // @PreAuthorize("hasAuthority('sys:dept:delete')")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<Goods> records) {
        return HttpResult.ok(goodService.delete(records));
    }

   // @PreAuthorize("hasAuthority('sys:dept:view')")
    @GetMapping(value="/findTree")
    public HttpResult findTree() {
        return HttpResult.ok(goodService.findTree());
    }




}
