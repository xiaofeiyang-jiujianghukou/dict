package com.xiaofeiyang.dict.manager;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaofeiyang.dict.common.BasePageResDTO;
import com.xiaofeiyang.dict.common.enums.EffectiveStatusEnum;
import com.xiaofeiyang.dict.common.enums.StatusEnum;
import com.xiaofeiyang.dict.common.exception.BizException;
import com.xiaofeiyang.dict.controller.dto.DictTypeCreateReqDTO;
import com.xiaofeiyang.dict.controller.dto.DictTypeListReqDTO;
import com.xiaofeiyang.dict.controller.dto.DictTypeListResDTO;
import com.xiaofeiyang.dict.controller.dto.DictTypeUpdateReqDTO;
import com.xiaofeiyang.dict.entity.DictTypeDO;
import com.xiaofeiyang.dict.entity.DictTypeShowRelationDO;
import com.xiaofeiyang.dict.service.DictTypeService;
import com.xiaofeiyang.dict.service.DictTypeShowRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Objects;

@Service
public class DictTypeManager {

    @Autowired
    private DictTypeService dictTypeService;

    @Autowired
    private DictTypeShowRelationService dictTypeShowRelationService;

    @Transactional(rollbackFor = BizException.class)
    public void create(DictTypeCreateReqDTO input) {
        // check
        DictTypeDO dbDictTypeDO = dictTypeService.getByCode(input.getCode(), null);
        if (Objects.nonNull(dbDictTypeDO)) {
            throw new BizException("字典类型编码已存在");
        }
        DictTypeShowRelationDO dbDictTypeShowRelationDO = dictTypeShowRelationService.getByShowCode(input.getShowCode());
        if (Objects.nonNull(dbDictTypeShowRelationDO)) {
            throw new BizException("字典类型展示编码已存在");
        }

        DictTypeDO dictTypeDO = new DictTypeDO();
        dictTypeDO.setCode(input.getCode());
        dictTypeDO.setName(input.getName());
        dictTypeDO.setStatus(StatusEnum.NOT.getValue());
        dictTypeDO.setEffectiveStatus(EffectiveStatusEnum.YES.getValue());
        dictTypeService.save(dictTypeDO);

        if (StringUtils.isNotBlank(input.getShowCode())) {
            DictTypeShowRelationDO dictTypeShowRelationDO = new DictTypeShowRelationDO();
            dictTypeShowRelationDO.setDictTypeCode(input.getCode());
            dictTypeShowRelationDO.setShowCode(input.getShowCode());
            dictTypeShowRelationDO.setStatus(StatusEnum.NOT.getValue());
            dictTypeShowRelationService.save(dictTypeShowRelationDO);
        }
    }

    @Transactional
    public void update(DictTypeUpdateReqDTO input) {
        // check
        DictTypeDO dbDictTypeDO = dictTypeService.getByCode(input.getCode(), input.getId());
        if (Objects.nonNull(dbDictTypeDO)) {
            throw new BizException("字典类型编码已存在");
        }
        DictTypeShowRelationDO dbDictTypeShowRelationDO = dictTypeShowRelationService.getByShowCode(input.getShowCode());
        if (Objects.nonNull(dbDictTypeShowRelationDO)) {
            throw new BizException("字典类型展示编码已存在");
        }

        DictTypeDO dictTypeDO = new DictTypeDO();
        dictTypeDO.setCode(input.getCode());
        dictTypeDO.setName(input.getName());
        dictTypeService.save(dictTypeDO);

        if (StringUtils.isNotBlank(input.getShowCode())) {
            DictTypeShowRelationDO dictTypeShowRelationDO = new DictTypeShowRelationDO();
            dictTypeShowRelationDO.setDictTypeCode(input.getCode());
            dictTypeShowRelationDO.setShowCode(input.getShowCode());
            dictTypeShowRelationService.save(dictTypeShowRelationDO);
        }
    }

    public BasePageResDTO<DictTypeListResDTO> list(DictTypeListReqDTO input) {
        BasePageResDTO<DictTypeListResDTO> pageResDTO = new BasePageResDTO<>();

        Page<DictTypeListResDTO> page = dictTypeService.page(input);

        pageResDTO.setTotalCount(page.getTotal());
        if (CollectionUtil.isEmpty(page.getRecords())) {
            pageResDTO.setData(Collections.emptyList());
            return pageResDTO;
        }

        pageResDTO.setData(page.getRecords());
        return pageResDTO;
    }
}
