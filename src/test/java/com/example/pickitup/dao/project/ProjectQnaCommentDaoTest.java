package com.example.pickitup.dao.project;

import com.example.pickitup.domain.dao.project.projectFile.ProjectDAO;
import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaCommentDAO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.mapper.project.projectQna.ProjectQnaCommentMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectQnaCommentDaoTest {
    @Autowired
    private ProjectQnaCommentDAO projectQnaCommentDAO;

    @Test
    public void getListTest(){
        Long qnaNum = 3L;
        projectQnaCommentDAO.getComment(qnaNum).stream().map(ProjectQnaCommentVO::toString).forEach(log::info);
    }

    @Test
    public void registerTest(){
        ProjectQnaCommentVO projectQnaCommentVO = new ProjectQnaCommentVO();
        projectQnaCommentVO.setUserNum(3L);
        projectQnaCommentVO.setQnaNum(3L);
        projectQnaCommentVO.setCompanyNum(1L);
        projectQnaCommentVO.setContent("문의 답변 단위테스트");
        projectQnaCommentDAO.register(projectQnaCommentVO);

    }

    @Test
    public void updateTest(){
        ProjectQnaCommentVO projectQnaCommentVO = new ProjectQnaCommentVO();
        projectQnaCommentVO.setContent("tese2222t");
        projectQnaCommentVO.setNum(1L);
        log.info(Boolean.toString(projectQnaCommentDAO.update(projectQnaCommentVO)));

    }

    @Test
    public void deleteTest(){
        projectQnaCommentDAO.remove(1L);

    }

}
