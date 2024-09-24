package com.xiaofeiyang.dict.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DictTypeListResDTO {

    @Schema(title = "ID")
    private Long id;

    @Schema(title = "名称")
    private String name;

    @Schema(title = "编码")
    private String code;

    @Schema(title = "展示编码")
    private String showCode;

    @Schema(title = "有效状态 0失效 1生效")
    private String effectiveStatus;

}
