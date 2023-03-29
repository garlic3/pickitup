package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.ProductCriteria;
import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewFileVO;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
@NoArgsConstructor
public class QnaDTO {

    private Long num;
    private String content;
    private String registDate;
    private String updateDate;
    private Long qnaNum;

    // 유저 정보
    private Long userNum;
    private String nickname;
    private String profileFileName;
    private String profileUploadPath;

}
