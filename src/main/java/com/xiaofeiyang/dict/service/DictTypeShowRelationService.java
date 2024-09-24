package com.xiaofeiyang.dict.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaofeiyang.dict.common.enums.StatusEnum;
import com.xiaofeiyang.dict.entity.DictTypeShowRelationDO;
import com.xiaofeiyang.dict.mapper.DictTypeShowRelationMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典类型展示对照表 服务实现类
 * </p>
 *
 * @author xiaofeiyang
 * @since 2024-08-17
 */
@Service
public class DictTypeShowRelationService extends ServiceImpl<DictTypeShowRelationMapper, DictTypeShowRelationDO> {

    public DictTypeShowRelationDO getByDictTypeCode(String dictTypeCode) {
        if (StringUtils.isBlank(dictTypeCode)) {
            return null;
        }
        return this.lambdaQuery()
                .eq(DictTypeShowRelationDO::getDictTypeCode, dictTypeCode)
                .eq(DictTypeShowRelationDO::getStatus, StatusEnum.NOT.getValue())
                .one();
    }

    public DictTypeShowRelationDO getByShowCode(String showCode) {
        if (StringUtils.isBlank(showCode)) {
            return null;
        }
        return this.lambdaQuery()
                .eq(DictTypeShowRelationDO::getShowCode, showCode)
                .eq(DictTypeShowRelationDO::getStatus, StatusEnum.NOT.getValue())
                .one();
    }


}
