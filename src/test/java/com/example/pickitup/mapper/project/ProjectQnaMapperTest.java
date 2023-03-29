package com.example.pickitup.mapper.project;

import com.example.pickitup.domain.vo.dto.QnaDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.mapper.project.projectFile.ProjectMapper;
import com.example.pickitup.mapper.project.projectQna.ProjectQnaMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectQnaMapperTest {
    @Autowired
    private ProjectQnaMapper projectQnaMapper;

    @Test
    public void getListTest(){
        Long projectNum = 0L;
        projectQnaMapper.getList(projectNum).stream().map(QnaDTO::toString).forEach(log::info);
    }

    @Test
    public void registerTest(){
        ProjectQnaVO projectQanVo = new ProjectQnaVO();
        projectQanVo.setUserNum(1L);
        projectQanVo.setProjectNum(0L);
        projectQanVo.setCompanyNum(0L);
        projectQanVo.setContent("문의 단위테스트");
        projectQnaMapper.insert(projectQanVo);

    }

    @Test
    public void updateTest(){
        ProjectQnaVO projectQanVo = new ProjectQnaVO();
        projectQanVo.setContent("teset");
        projectQanVo.setNum(6L);
        log.info(Boolean.toString(projectQnaMapper.update(projectQanVo)));

    }

    @Test
    public void deleteTest(){
        projectQnaMapper.delete(6L);

    }

}
