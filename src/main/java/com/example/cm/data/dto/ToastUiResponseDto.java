package com.example.cm.data.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Data
@Builder
public class ToastUiResponseDto {
    private boolean result;
    private HashMap<String, Object> data;
}
