package com.xiaofeiyang.dict.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 字典类型展示对照表
 * </p>
 *
 * @author xiaofeiyang
 * @since 2024-08-17
 */
@Getter
@Setter
@TableName("dict_type_show_relation")
public class DictTypeShowRelationDO implements Serializable {

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
     * 展示编码
     */
    private String showCode;

    /**
     * 逻辑删除状态 0已删除 1未删除
     */
    private Integer status;
}
