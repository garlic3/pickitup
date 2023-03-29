package com.example.pickitup.mapper.project;

import com.example.pickitup.domain.vo.dto.QnaDTO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.mapper.project.projectQna.ProjectQnaCommentMapper;
import com.example.pickitup.mapper.project.projectQna.ProjectQnaMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectQnaCommentMapperTest {
    @Autowired
    private ProjectQnaCommentMapper projectQnaCommentMapper;

    @Test
    public void getListTest(){
        Long qnaNum = 3L;
        projectQnaCommentMapper.getComment(qnaNum).stream().map(ProjectQnaCommentVO::toString).forEach(log::info);
    }

    @Test
    public void registerTest(){
        ProjectQnaCommentVO projectQnaCommentVO = new ProjectQnaCommentVO();
        projectQnaCommentVO.setUserNum(3L);
        projectQnaCommentVO.setQnaNum(3L);
        projectQnaCommentVO.setCompanyNum(1L);
        projectQnaCommentVO.setContent("문의 답변 단위테스트");
        projectQnaCommentMapper.insert(projectQnaCommentVO);

    }

    @Test
    public void updateTest(){
        ProjectQnaCommentVO projectQnaCommentVO = new ProjectQnaCommentVO();
        projectQnaCommentVO.setContent("tese2222t");
        projectQnaCommentVO.setNum(1L);
        log.info(Boolean.toString(projectQnaCommentMapper.update(projectQnaCommentVO)));

    }

    @Test
    public void deleteTest(){
        projectQnaCommentMapper.delete(1L);

    }

}
