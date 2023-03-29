package com.example.pickitup.service;

import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.dao.project.projectFile.ProjectFileDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaCommentDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaDAO;
import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewDAO;
import com.example.pickitup.domain.dao.project.projectReview.ProjectReviewFileDAO;
import com.example.pickitup.domain.dao.user.ApplyDAO;
import com.example.pickitup.domain.dao.user.JjimDAO;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.dto.ProjectDTO;
import com.example.pickitup.domain.vo.dto.ProjectMainDTO;
import com.example.pickitup.domain.vo.dto.ReviewDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectFileVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewFileVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.service.user.JjimService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDAO projectDAO;
    private final ProjectQnaDAO projectQnaDAO;
    private final ProjectQnaCommentDAO projectQnaCommentDAO;
    private final JjimDAO jjimDAO;
    private final ApplyDAO applyDAO;
    private final ProjectReviewDAO projectReviewDAO;
    private final ProjectReviewFileDAO projectReviewFileDAO;
    private final ProjectFileDAO projectFileDAO;

    // 프로젝트 목록(관리자용)
    public List<ProjectVO> getList(){
        return projectDAO.getList();
    }


    // 프로젝트 목록(특정 단체 유저)
    public List<ProjectVO> getProjectList(Long companyNum, Criteria criteria){
        return projectDAO.getUserProjectList(companyNum, criteria);
    }

    // 프로젝트 상세보기
    public ProjectDTO read(Long num){
        return  projectDAO.read(num);
    }

    // 프로젝트 수정
    public boolean update(ProjectVO projectVO){
        return projectDAO.update(projectVO);
    }

    // 프로젝트 삭제
    public boolean remove(Long num){
        return projectDAO.remove(num);
    }

    // 프로젝트 등록
    @Transactional(rollbackFor = Exception.class)
    public void registerProject (ProjectVO projectVO) {
//        String startDate = projectVO.getStartTime().substring(0,10)+" "+projectVO.getStartTime().substring(11,16)+":00";
//        String endDate = projectVO.getEndTime().substring(0,10)+" "+projectVO.getEndTime().substring(11,16)+":00";
//        projectVO.setEndTime(endDate);
//        projectVO.setStartTime(startDate);
//        //게시글 추가
//        projectDAO.register(projectVO);
//        // 파일 추가
//        if(projectVO.getFileList() != null) {
//            projectVO.getFileList().forEach(projectFileVO -> {
//                projectFileVO.setProjectNum(projectVO.getNum());
//                projectFileDAO.register(projectFileVO);
//            });
//        }
    }


    // 프로젝트 사진 가져오기
    public List<ProjectFileVO>getProjectFileList(Long num){
        return projectFileDAO.findByProjectNum(num);
    }


    // 리뷰 등록
    @Transactional(rollbackFor = Exception.class)
    public void registerReview(ProjectReviewVO projectReviewVO) {
        // 게시글 추가
        projectReviewDAO.register(projectReviewVO);
        // 파일 추가
        if (projectReviewVO.getFileList() != null) {
            projectReviewVO.getFileList().forEach(projectReviewFileVO -> {
                projectReviewFileVO.setReviewNum(projectReviewVO.getNum());
                projectReviewFileDAO.register(projectReviewFileVO);
            });
        }
    }

    // 리뷰 수정
    @Transactional(rollbackFor = Exception.class)
    public void modifyReview(ProjectReviewVO projectReviewVO) {
        // 기존 파일 삭제
        projectReviewFileDAO.remove(projectReviewVO.getNum());

        // 파일 추가
        if (projectReviewVO.getFileList() != null) {
            projectReviewVO.getFileList().forEach(projectReviewFileVO -> {
                projectReviewFileVO.setReviewNum(projectReviewVO.getNum());
                projectReviewFileDAO.register(projectReviewFileVO);
            });
        }

        // 게시물 수정
        projectReviewDAO.update(projectReviewVO);
    }

    // 리뷰 사진 가져오기
    public List<ProjectReviewFileVO>getReviewFileList(Long num){
        return projectReviewFileDAO.findProjectReviewNum(num);
    }

    // 리뷰 정보 가져오기(수정용)
    public ReviewDTO readReview(Long reviewNum){
        return projectReviewDAO.read(reviewNum);
    }

    // 리뷰 삭제
    public void removeReview(Long reviewNum){
        projectReviewDAO.remove(reviewNum);
    }

    // 리뷰 목록
    public List<ReviewDTO> getProjectReviewList(Long projectNum){
        return projectReviewDAO.getReviewList(projectNum);
    }

    // 프로젝트 생성한 개수
    public int getUserProjectTotal(Long companyNum){
        return projectDAO.getUserProjectTotal(companyNum);
    }


    // 프로젝트 목록(찜순)
    public List<ProjectMainDTO> getListJJim() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListJJim();

//        for(ProjectVO pp : projectVOS){
//            String strDate = pp.getProjectDate();  // 기준 날짜 데이터 (("yyyy-MM-dd")의 형태)
//            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // 오늘날짜
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//            Date date = new Date(dateFormat.parse(strDate).getTime());
//            Date today = new Date(dateFormat.parse(todayFm).getTime());
//
//            long calculate = date.getTime() - today.getTime();
//
//            int Ddays = (int) (calculate / ( 24*60*60*1000));
//
//            String Ddate ="";
//            if(Ddays==0){
//                Ddate = "오늘이에요!";
//            }else {
//                Ddate = "D" + Integer.toString(Ddays * (-1));
//            }
//            projectMainDTOS.add(new ProjectMainDTO(pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
//
//
//        }
        return projectMainDTOS;
    }
    // 프로젝트 목록(포인트순)
    public List<ProjectMainDTO> getListPoint() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListPoint();

//        for(ProjectVO pp : projectVOS){
//            String strDate = pp.getProjectDate();  // 기준 날짜 데이터 (("yyyy-MM-dd")의 형태)
//            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // 오늘날짜
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//            Date date = new Date(dateFormat.parse(strDate).getTime());
//            Date today = new Date(dateFormat.parse(todayFm).getTime());
//
//            long calculate = date.getTime() - today.getTime();
//
//            int Ddays = (int) (calculate / ( 24*60*60*1000));
//
//            String Ddate ="";
//            if(Ddays==0){
//                Ddate = "오늘이에요!";
//            }else {
//                Ddate = "D" + Integer.toString(Ddays * (-1));
//            }
//            projectMainDTOS.add(new ProjectMainDTO(pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
//
//
//        }
        return projectMainDTOS;
    }
    // 프로젝트 목록(포인트순)
    public List<ProjectMainDTO> getListApply() throws ParseException {
        List<ProjectMainDTO> projectMainDTOS = new ArrayList<>();
        List<ProjectVO> projectVOS = projectDAO.getListApply();


//        for(ProjectVO pp : projectVOS){
//            String strDate = pp.getProjectDate();  // 기준 날짜 데이터 (("yyyy-MM-dd")의 형태)
//            String todayFm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())); // 오늘날짜
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//            Date date = new Date(dateFormat.parse(strDate).getTime());
//            Date today = new Date(dateFormat.parse(todayFm).getTime());
//
//            long calculate = date.getTime() - today.getTime();
//
//            int Ddays = (int) (calculate / ( 24*60*60*1000));
//
//            String Ddate ="";
//            if(Ddays==0){
//                Ddate = "오늘이에요!";
//            }else {
//                Ddate = "D" + Integer.toString(Ddays * (-1));
//            }
//            projectMainDTOS.add(new ProjectMainDTO(pp.getTitle(),pp.getTerrain(),pp.getPoint(),pp.getJjimCount(),Ddate,pp.getApplyCount()));
//
//
//        }
        return projectMainDTOS;
    }



}
