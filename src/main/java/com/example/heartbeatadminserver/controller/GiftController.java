package com.example.heartbeatadminserver.controller;

import com.example.heartbeatadminserver.common.ServiceResultEnum;
import com.example.heartbeatadminserver.entity.Gift;
import com.example.heartbeatadminserver.entity.GiftDetail;
import com.example.heartbeatadminserver.service.Impl.GiftServiceImpl;
import com.example.heartbeatadminserver.util.PageParam;
import com.example.heartbeatadminserver.util.PageResult;
import com.example.heartbeatadminserver.util.Result;
import com.example.heartbeatadminserver.util.ResultGenerator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/admin")
public class GiftController {

    @Autowired
    private GiftServiceImpl giftService;

    @PostMapping("/gift")
    @ApiOperation("/新增礼物")
    public Result<String> addGift(@RequestBody Gift gift, int adminId) {
        String res = this.giftService.addGift(gift);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
           return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

    @GetMapping("/gift")
    @ApiOperation("/查询礼物列表")
    public Result<PageResult> getGiftList(@RequestParam int pageNum, @RequestParam int pageSize, String keyword, @RequestParam Integer vendorId, int adminId) {
        PageParam pageParam = new PageParam();
        pageParam.setPageNum(pageNum);
        pageParam.setPageSize(pageSize);
        String key = keyword;
        if (vendorId == 1) {
            vendorId = null;
        }
        PageResult pageResult = this.giftService.getGiftListPaged(key, vendorId, pageParam);
        Result<PageResult> result = ResultGenerator.genSuccessResultData(pageResult);

        return result;
    }

    @PutMapping("/gift")
    @ApiOperation("/更新礼物信息")
    public Result<String> updateGift(@RequestBody Gift gift, int adminId) {
        String res = this.giftService.updateGift(gift);
        if ( res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

    @PutMapping("/gift/showStatus")
    @ApiOperation("/更新礼物信息")
    public Result<String> updateGiftIsShown(@RequestParam Integer giftId, @RequestParam Integer showStatus, int adminId) {
        String res = this.giftService.updateGiftIsShown(giftId, showStatus);
        if (res.equals(ServiceResultEnum.SUCCESS.getResult())) {
            return ResultGenerator.genSuccessResult(res);
        }
        return ResultGenerator.genFailResult(res);
    }

    @GetMapping("/gift/{giftId}")
    @ApiOperation("/查询礼物详情")
    public Result<GiftDetail> getGiftDetail(@PathVariable Integer giftId, int adminId) {
        GiftDetail giftDetail = this.giftService.getGiftDetail(giftId);
        if (giftDetail == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return ResultGenerator.genSuccessResultData(giftDetail);
    }
}
