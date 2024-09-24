package com.xiaofeiyang.dict.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 字典值
 * </p>
 *
 * @author xiaofeiyang
 * @since 2024-08-17
 */
@Getter
@Setter
@TableName("dict_value")
public class DictValueDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典类型编码
     */
    private String dictTypeCode;

    /**
     * 字典值编码
     */
    private String code;

    /**
     * 字典值名称
     */
    private String name;

    /**
     * 有效状态 0无效 1有效
     */
    private Integer effectiveStatus;

    /**
     * 逻辑删除状态 0已删除 1未删除
     */
    private Integer status;
}
