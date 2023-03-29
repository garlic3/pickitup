package com.example.pickitup.mapper.project.projectFile;

import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.dto.ProjectDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {

//    프로젝트 전부 띄우기
    public List<ProjectVO> getList();
//
    public List<ProjectVO> getProjectList(Criteria criteria);

//  특정 유저의 프로젝트 목록
    public List<ProjectVO> getUserProjectList(Long companyNum, Criteria criteria);

//    프로젝트 상세 정보
    public ProjectDTO getDetail(Long num);

//    프로젝트 등록하기
    public void insert(ProjectVO projectVO);

//    프로젝트 수정하기
    public boolean update(ProjectVO projectVO);

//    프로젝트 삭제하기
    public boolean delete(Long num);

//    프로젝트 최대 찜순 가져오기
    public List<ProjectVO> getListJJim();

    //    프로젝트 최대 포인트순 가져오기
    public List<ProjectVO> getListPoint();

    //    프로젝트 최대 참가자순 가져오기
    public List<ProjectVO> getListApply();

    // 프로젝트 생성한 개수
    public int getUserProjectTotal(Long companyNum);


}
