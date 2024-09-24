package com.xiaofeiyang.dict.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 字典级联关系表
 * </p>
 *
 * @author xiaofeiyang
 * @since 2024-08-17
 */
@Getter
@Setter
@TableName("dict_cascade_relation")
public class DictCascadeRelationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 级联编码
     */
    private String dictCascadeCode;

    /**
     * 字典类型编码
     */
    private String dictTypeCode;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 逻辑删除状态 0已删除 1未删除
     */
    private Integer status;
}
