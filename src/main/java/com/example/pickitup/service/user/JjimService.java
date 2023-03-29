package com.example.pickitup.service.user;

import com.example.pickitup.domain.dao.user.JjimDAO;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JjimService {

    private final JjimDAO jjimDAO;

    // 나의 프로젝트 찜 목록
    public List<ProjectVO> getProjectList(Long userNum){
        return jjimDAO.getProjectList(userNum);
    }

    // 나의 상품 찜 목록
    public List<ProductVO> getProductList(Long userNum){
        return jjimDAO.getProductList(userNum);
    }

    // 프로젝트 찜 등록
    public void addProject(JjimVO jjimVO){
        jjimDAO.addProject(jjimVO);
    }

    // 프로젝트 찜 해제
    public void removeProject(JjimVO jjimVO){
        jjimDAO.removeProject(jjimVO);
    }

    // 프로젝트 찜 개수 조회
    public long getJjimCount(Long projectNum){
        return jjimDAO.getJjimCount(projectNum);
    }

    // 프로젝트 유저 찜 여부 조회
    public boolean checkUserProject(Long userNum, Long projectNum){
        return jjimDAO.checkUserProject(userNum, projectNum);
    }

}
