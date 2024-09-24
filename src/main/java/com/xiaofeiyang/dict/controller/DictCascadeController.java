package com.xiaofeiyang.dict.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 字典级联表 前端控制器
 * </p>
 *
 * @author xiaofeiyang
 * @since 2024-08-17
 */
@Tag(name = "用户管理", description = "包含用户相关的操作")
@RestController
@RequestMapping("/dict/dictCascade")
public class DictCascadeController {

    @Operation(summary = "获取用户信息", description = "通过用户ID获取用户的详细信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功获取用户信息"),
            @ApiResponse(responseCode = "404", description = "用户未找到")
    })
    @GetMapping("/user")
    public String getUser() {
        return "User info";
    }
}
