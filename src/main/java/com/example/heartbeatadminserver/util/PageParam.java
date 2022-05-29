package com.example.heartbeatadminserver.util;

import com.github.pagehelper.IPage;
import lombok.Data;

@Data
public class PageParam{

    private Integer pageNum = 1;

    private Integer pageSize = 10;

}
