package com.example.pickitup.service;

import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaCommentDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaDAO;
import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewDAO;
import com.example.pickitup.domain.dao.user.CompanyDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.dto.QnaDTO;
import com.example.pickitup.domain.vo.dto.ReviewDTO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import com.example.pickitup.domain.vo.user.CompanyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class TempCompanyService {
    private final CompanyDAO companyDAO;
    private final ProjectQnaDAO projectQnaDAO;
    private final ProjectQnaCommentDAO projectQnaCommentDAO;
    private final ProjectReviewDAO projectReviewDAO;


    // companyDAO
    // 단체 회원가입
    public void registerCompany(CompanyVO companyVO){
        companyDAO.register(companyVO);
    }

    // 단체 정보 상세보기
    public CompanyVO readCompanyInfo(Long num){
        return companyDAO.read(num);
    }

    // 단체 유저 탈퇴
    public boolean removeCompany(Long num){
        return companyDAO.remove(num);
    }



    public CompanyVO loginCompany(String email, String password){
        return companyDAO.login(email,password);
    }


    // projectQnaDAO
    // qna 전체 목록 -> 수정
    public List<QnaDTO> getProjectQnAList(Long projectNum){
        return projectQnaDAO.getList(projectNum);
    }

    // projectQnaCommentDAO
    // 관리자가 답변한 qna 전체 목록
    public List<ProjectQnaCommentVO> getList(Criteria criteria){
        return projectQnaCommentDAO.getList(criteria);
    }

    // qna 답글 달기(모집자, 관리자)
    public void register(ProjectQnaCommentVO projectQnaCommentVO){
        projectQnaCommentDAO.register(projectQnaCommentVO);
    }

    // qna 답글 수정(모집자, 관리자)
    public boolean update(ProjectQnaCommentVO projectQnaCommentVO){
        return projectQnaCommentDAO.update(projectQnaCommentVO);
    }

    // qna 답글 삭제
    public boolean remove(Long num){
        return projectQnaCommentDAO.remove(num);
    }


    // projectReviewDAO
    // 프로젝트 리뷰 목록 -> 수정
    public List<ProjectReviewVO> getList(Long projectNum){
        return projectReviewDAO.getList(projectNum);
    }

    // 리뷰 상세보기
    public ReviewDTO read(Long num){
        return projectReviewDAO.read(num);
    }

    // 단체 정보 수정
    public void update(CompanyVO companyVO){
        companyDAO.update(companyVO);
    }


}
