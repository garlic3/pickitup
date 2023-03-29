package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ApplyDTO {
    private Long num;
    private String completion;
    private String registDate;
    private Long projectNum;
    private String startTime;
    private String endTime;

    private Long userNum;
    private String nickname;
    private String phone;




}
