package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewFileVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
@NoArgsConstructor
public class QnaCommentDTO {

//    TPQ.NUM, TPQ.CONTENT, TPQ.UPDATE_DATE, TU.NICKNAME
    private long num;
    private long projectNum;
    private String content;
    private String updateDate;
    private String status;

    // 유저 정보
    private long userNum;
    private String nickname;
    private String profileFileName;
    private String profileUploadPath;
    private List<ProjectReviewFileVO> fileList;
}
