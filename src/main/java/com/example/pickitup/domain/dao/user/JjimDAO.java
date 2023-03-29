package com.example.pickitup.domain.dao.user;

import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.mapper.user.JjimMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JjimDAO {

    private final JjimMapper jjimMapper;

    // 나의 프로젝트 찜 목록
    public List<ProjectVO> getProjectList(Long userNum){
        return jjimMapper.getProjectList(userNum);
    }

    // 나의 상품 찜 목록
    public List<ProductVO> getProductList(Long userNum){
        return jjimMapper.getProductList(userNum);
    }

    // 프로젝트 찜 등록
    public void addProject(JjimVO jjimVO){
        jjimMapper.insertProject(jjimVO);
    }

    // 프로젝트 찜 해제
    public void removeProject(JjimVO jjimVO){
        jjimMapper.deleteProject(jjimVO);
    }

    // 프로젝트 찜 개수 조회
    public long getJjimCount(Long projectNum){
        return jjimMapper.getJjimCount(projectNum);
    }

    // 프로젝트 유저 찜 여부 조회
    public boolean checkUserProject(Long userNum, Long projectNum){
        return jjimMapper.checkUserProject(userNum, projectNum) > 0 ? true: false;
    }

}
