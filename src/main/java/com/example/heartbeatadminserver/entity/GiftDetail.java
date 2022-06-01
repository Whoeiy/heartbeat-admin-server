package com.example.heartbeatadminserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GiftDetail {
    private Gift gift;

    private List<Category> categories;

    private List<Label> labels;
}
