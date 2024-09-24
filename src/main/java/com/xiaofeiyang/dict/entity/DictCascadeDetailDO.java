package com.xiaofeiyang.dict.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 字典级联详情表
 * </p>
 *
 * @author xiaofeiyang
 * @since 2024-08-17
 */
@Getter
@Setter
@TableName("dict_cascade_detail")
public class DictCascadeDetailDO implements Serializable {

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
     * 字典值编码
     */
    private String dictValueCode;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 逻辑删除状态 0已删除 1未删除
     */
    private Integer status;
}
