package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
@NoArgsConstructor
public class ProjectDTO {
    private String approval;
    private String companyComment;
    private long companyNum;
    private String content;
    private String distance;
    private String startAddress;
    private String startAddressDetail;
    private String endAddress;
    private String endAddressDetail;
    private String startQr;
    private String endQr;
    private String startTime;
    private String endTime;
    private long num;
    private long point;
    private String registDate;
    private String updateDate;
    private String status;
    private String summary;
    private String terrain;
    private String title;
    private String course;

    // 단체 유저
    private String nickname;

    // 지원
    private Long applyCount;
    
    // 파일
    private List<ProjectFileVO> fileList;



}
