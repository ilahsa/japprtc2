package com.alta.japprtc2.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by baiba on 2018-09-08.
 */
@Data
@Builder
public class ReportInfo implements Serializable {
    private static final long serialVersionUID = -4776940819267663683L;
    private String accesskey;
    private String module;
}
