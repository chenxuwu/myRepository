package com.wufang.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wufang.controller.utils.Code;
import com.wufang.controller.utils.R;
import com.wufang.dao.IInfoDao;
import com.wufang.domain.Info;
import com.wufang.service.IInfoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static java.awt.SystemColor.info;

@RestController
@RequestMapping("/infos")
public class InfoController {
    @Autowired
    private IInfoDao infoDao;

    @Autowired
    private IInfoService infoService;

    @PostMapping
    public R insertInfo(@RequestBody Info info) {
        boolean save = infoService.save(info);
        Integer code = save != false ? Code.GET_OK : Code.GET_ERR;
        String msg = save != false ? "添加成功^_^" : "添加失败-_-！";
        return new R(code, save, msg);
    }

    @PutMapping
    public R updateInfo(@RequestBody Info info) {
        boolean update = infoService.updateById(info);
        Integer code = update != false ? Code.GET_OK : Code.GET_ERR;
        String msg = update != false ? "修改成功^_^" : "修改失败-_-！";
        return new R(code, update, msg);
    }

    @GetMapping("/{id}")
    public R getInfoById(@PathVariable Integer id) {
        Info info = infoService.getById(id);
        Integer code = info != null ? Code.GET_OK : Code.GET_ERR;
        String msg = info != null ? "查询成功^_^" : "查询失败-_-！";
        return new R(code, info, msg);
    }

    @GetMapping
    public R getInfoAll() {
        List<Info> infos = infoService.list();
        Integer code = infos != null ? Code.GET_OK : Code.GET_ERR;
        String msg = infos != null ? "查询成功^_^" : "查询失败-_-！";
        return new R(code, infos, msg);
    }


    @DeleteMapping("/{id}")
    public R deleteInfoById(@PathVariable Integer id) {
        boolean remove = infoService.removeById(id);
        Integer code = remove != false ? Code.GET_OK : Code.GET_ERR;
        String msg = remove != false ? "删除成功^_^" : "删除失败-_-！";
        return new R(code, remove, msg);
    }

    //批量删除
    @PostMapping("/delBatch")
    public R deleteInfoBatch(@RequestBody int[] batchids) {
        boolean remove = true;
        for (int i : batchids) {
            remove = infoService.removeById(i);
        }
        Integer code = remove != false ? Code.GET_OK : Code.GET_ERR;
        String msg = remove != false ? "删除成功^_^" : "删除失败-_-！";
        return new R(code, remove, msg);
    }

    @GetMapping("/{current}/{size}")
    public R pages(@PathVariable Integer current, @PathVariable Integer size,Info info) {

        IPage<Info> page = infoService.pages(current,size,info);
        //如果当前页码值大于总页码值，重新执行查询，使用最大页码值作为当前页码
        if (current > page.getPages()) {
            page = infoService.pages(current-1,size,info);
        }
        Integer code = Code.GET_OK;
        String msg = "分页查询";
        return new R(code,page, msg);
    }



//    @PostMapping("/query")
//    public IPage<Info> querywrapper(@RequestBody Info info) {
//        LambdaQueryWrapper<Info> wrapper = new LambdaQueryWrapper<Info>();
//        wrapper.like(info.getDeleted() != null,Info::getDeleted,info.getDeleted());
//        wrapper.like(info.getId() != null,Info::getId,info.getId());
//        wrapper.like(info.getName() != null,Info::getName,info.getName());
//
//        IPage iPage = new Page(1,10);
//        infoDao.selectPage(iPage,wrapper);
////        Integer code = Code.GET_OK;
////        String msg = "条件查询";
//        return iPage;
//    }


}
