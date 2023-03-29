package com.example.pickitup.service.project;

import com.example.pickitup.domain.dao.project.projectQna.ProjectQnaDAO;
import com.example.pickitup.domain.vo.dto.QnaDTO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.service.project.projectQna.ProjectQnaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectQnaDaoServiceTest {
    @Autowired
    private ProjectQnaService projectQnaService;

    @Test
    public void getListTest(){
        projectQnaService.getList(0L).stream().map(QnaDTO::toString).forEach(log::info);
    }

    @Test
    public void registerTest(){
        ProjectQnaVO projectQanVo = new ProjectQnaVO();
        projectQanVo.setUserNum(1L);
        projectQanVo.setProjectNum(0L);
        projectQanVo.setCompanyNum(0L);
        projectQanVo.setContent("문의 단위테스트");
        projectQnaService.register(projectQanVo);

    }

    @Test
    public void updateTest(){
        ProjectQnaVO projectQanVo = new ProjectQnaVO();
        projectQanVo.setContent("teset");
        projectQanVo.setNum(6L);
        log.info(Boolean.toString(projectQnaService.update(projectQanVo)));

    }

    @Test
    public void deleteTest(){
        projectQnaService.remove(6L);

    }


}
