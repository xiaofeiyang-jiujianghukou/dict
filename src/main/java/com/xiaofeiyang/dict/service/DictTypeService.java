package com.xiaofeiyang.dict.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofeiyang.dict.common.enums.StatusEnum;
import com.xiaofeiyang.dict.controller.dto.DictTypeListReqDTO;
import com.xiaofeiyang.dict.controller.dto.DictTypeListResDTO;
import com.xiaofeiyang.dict.entity.DictTypeDO;
import com.xiaofeiyang.dict.mapper.DictTypeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 字典类型 服务实现类
 * </p>
 *
 * @author xiaofeiyang
 * @since 2024-08-17
 */
@Service
public class DictTypeService extends ServiceImpl<DictTypeMapper, DictTypeDO> {

    public DictTypeDO getByCode(String code, Long excludeId) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        return this.lambdaQuery()
                .eq(DictTypeDO::getCode, code)
                .ne(Objects.nonNull(excludeId), DictTypeDO::getId, excludeId)
                .eq(DictTypeDO::getStatus, StatusEnum.NOT.getValue())
                .one();
    }

    public Page<DictTypeListResDTO> page(DictTypeListReqDTO input) {
        return baseMapper.pageList(new Page<>(input.getPageIndex(), input.getPageSize()), input);
    }

}
