package com.xiaofeiyang.dict.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofeiyang.dict.controller.dto.DictTypeListReqDTO;
import com.xiaofeiyang.dict.controller.dto.DictTypeListResDTO;
import com.xiaofeiyang.dict.entity.DictTypeDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 字典类型 Mapper 接口
 * </p>
 *
 * @author xiaofeiyang
 * @since 2024-08-17
 */
public interface DictTypeMapper extends BaseMapper<DictTypeDO> {

    Page<DictTypeListResDTO> pageList(@Param("page") Page<DictTypeListResDTO> page,
                                      @Param("req") DictTypeListReqDTO req);

}
