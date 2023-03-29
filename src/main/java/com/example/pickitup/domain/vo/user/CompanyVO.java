package com.example.pickitup.domain.vo.user;

import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CompanyVO {
    private Long num;
    private String email;
    private String password;
    private String nickname;
    private String phone;
    private String businessPhone;
    private String address;
    private String addressDetail;
    private String businessNumber;
    private String approval;
    private String registDate;
    private String profileFileName;
    private String profileUploadPath;
    private String category;


}
