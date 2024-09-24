package com.xiaofeiyang.dict.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.xiaofeiyang.dict.common.BasePageResDTO;
import com.xiaofeiyang.dict.common.Result;
import com.xiaofeiyang.dict.controller.dto.DictTypeCreateReqDTO;
import com.xiaofeiyang.dict.controller.dto.DictTypeListReqDTO;
import com.xiaofeiyang.dict.controller.dto.DictTypeListResDTO;
import com.xiaofeiyang.dict.controller.dto.DictTypeUpdateReqDTO;
import com.xiaofeiyang.dict.manager.DictTypeManager;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 字典类型 前端控制器
 * </p>
 *
 * @author xiaofeiyang
 * @since 2024-08-17
 */
@RestController
@RequestMapping("/dict/dictType")
public class DictTypeController {

    @Autowired
    private DictTypeManager dictTypeManager;

    @Operation(summary = "字典类型创建")
    @PostMapping(path = {"create"})
    public Result<Boolean> create(@Validated @RequestBody DictTypeCreateReqDTO input) {
        dictTypeManager.create(input);
        return Result.success(true);
    }

    @Operation(summary = "字典类型更新")
    @PostMapping(path = {"update"})
    public Result<Boolean> update(@Validated @RequestBody DictTypeUpdateReqDTO input) {
        dictTypeManager.update(input);
        return Result.success(true);
    }

    @Operation(summary = "字典类型列表")
    @PostMapping(path = {"list"})
    public Result<BasePageResDTO<DictTypeListResDTO>> list(@Validated @RequestBody DictTypeListReqDTO input) {
        return Result.success(dictTypeManager.list(input));
    }

    @Operation(summary = "字典类型列表")
    @GetMapping(path = {"getList"})
    public String getList() {
        DictTypeListReqDTO input = new DictTypeListReqDTO();
        String jsonStr = JSONUtil.toJsonStr(dictTypeManager.list(input));
        return JSONUtil.toJsonStr(jsonStr);
    }



}
