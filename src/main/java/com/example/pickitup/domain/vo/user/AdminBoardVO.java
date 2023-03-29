package com.example.pickitup.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class AdminBoardVO {
    private Long num;
    private String title;
    private String category;
    private String content;
    private String registDate;
    private String updateDate;
    private String status;
    private Long userNum;
}
