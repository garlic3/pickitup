package com.example.pickitup.mapper.user;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JjimMapper {

    //    내가 찜 프로젝트 리스트 보이기
    public List<ProjectVO> getProjectList(Long userNum);

    //    내가 찜 상품 리스트 보이기
    public List<ProductVO> getProductList(Long userNum);

    // 프로젝트 찜 등록
    public void insertProject(JjimVO jjimVO);

    // 프로젝트 찜 해제
    public void deleteProject(JjimVO jjimVO);

    // 프로젝트 찜 개수 조회
    public long getJjimCount(Long projectNum);

    // 프로젝트 유저 찜 여부 조회
    public int checkUserProject(Long userNum, Long projectNum);


}
