package com.alta.japprtc2.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by baiba on 2018-09-08.
 */
@Data
public class User {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String password;
}
