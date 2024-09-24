package com.xiaofeiyang.dict.controller.dto;

import com.xiaofeiyang.dict.common.BasePageReqDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DictTypeListReqDTO extends BasePageReqDTO {

    @Schema(title = "名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    @Schema(title = "编码")
    @NotBlank(message = "编码不能为空")
    private String code;

    @Schema(title = "展示编码")
    private String showCode;

}
