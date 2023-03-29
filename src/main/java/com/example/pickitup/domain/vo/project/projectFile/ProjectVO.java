package com.example.pickitup.domain.vo.project.projectFile;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ProjectVO {

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
    private long num;
    private long point;
    private String registDate;
    private String updateDate;
    private String status;
    private String summary;
    private String terrain;
    private String title;
    private String course;



}
