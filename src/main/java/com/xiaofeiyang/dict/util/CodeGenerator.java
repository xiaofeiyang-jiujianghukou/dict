package com.xiaofeiyang.dict.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;

import java.util.Collections;

public class CodeGenerator {

    public static void main(String[] args) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig.Builder(
                "jdbc:mysql://120.26.6.232:3306/dict?useSSL=false&useUnicode=true&characterEncoding=utf8",
                "xiaofeiyang", "xfy@930112")
                .build();

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator(dsc);

        // 全局配置
        GlobalConfig gc = new GlobalConfig.Builder()
                .outputDir(System.getProperty("user.dir") + "/src/main/java")
                .author("xiaofeiyang")
                .disableOpenDir()
                .build();
        mpg.global(gc);

        // 包配置
        PackageConfig pc = new PackageConfig.Builder()
                .moduleName("dict")
                .parent("com.xiaofeiyang")
                .serviceImpl("service")
                .pathInfo(Collections.singletonMap(OutputFile.xml,
                        System.getProperty("user.dir") + "\\src\\main\\resources\\mapper"))
                .build();
        mpg.packageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig.Builder()
                .addTablePrefix("DO")
                .addInclude("dict_cascade,dict_cascade_detail,dict_cascade_relation,dict_type,dict_type_show_relation,dict_value,dict_value_show_relation") // 表名
                .entityBuilder().enableLombok().enableFileOverride().idType(IdType.AUTO) // 启用Lombok
                .controllerBuilder().enableRestStyle().enableFileOverride() // RestController风格
                .serviceBuilder().enableFileOverride()
                .disableService()
                .convertServiceImplFileName( (entityName) -> {
                    return entityName + "Service";
                })
                .mapperBuilder().enableFileOverride()
                .build();
        mpg.strategy(strategy);

        // 执行生成
        mpg.execute();
    }
}
