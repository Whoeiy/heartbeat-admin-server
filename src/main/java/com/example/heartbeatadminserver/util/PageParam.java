package com.example.heartbeatadminserver.util;

import com.github.pagehelper.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam{

    private Integer pageNum = 1;

    private Integer pageSize = 10;

}
