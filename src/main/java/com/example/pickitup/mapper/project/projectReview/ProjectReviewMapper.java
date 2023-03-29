package com.example.pickitup.mapper.project.projectReview;

import com.example.pickitup.domain.vo.dto.ReviewDTO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProjectReviewMapper {

    //    하나의 프로젝트 리뷰 리스트 , 무한 스크롤
    public List<ProjectReviewVO> getList(Long projectNum);

    //  하나의 리뷰 상세보기
    public ReviewDTO getReviewDetail(Long num);

    //    리뷰 하나 작성하기
    public void insert(ProjectReviewVO projectReviewVO);

    //    리뷰 수정하기
    public boolean update(ProjectReviewVO projectReviewVO);

    //    리뷰 삭제하기
    public boolean delete(Long num);

    // 리뷰 리스트
    public List<ReviewDTO> getReviewList(Long projectNum);

}