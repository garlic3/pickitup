package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.dto.ApplyDTO;
import com.example.pickitup.domain.vo.dto.ProjectDTO;
import com.example.pickitup.domain.vo.dto.QnaDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaCommentVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.UserSerivce;
import com.example.pickitup.service.project.projectQna.ProjectQnaCommentService;
import com.example.pickitup.service.project.projectQna.ProjectQnaService;
import com.example.pickitup.service.user.ApplyService;
import com.example.pickitup.service.user.CompanyService;
import com.example.pickitup.service.user.JjimService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/project/*")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ApplyService applyService;
    private final JjimService jjimService;
    private final ProjectQnaService projectQnaService;
    private final CompanyService companyService;
    private final UserSerivce userSerivce;
    private final ProjectQnaCommentService projectQnaCommentService;

    // 프로젝트 상세보기
    @GetMapping("/projectDetail")
    public String projectDetail(Long num, Model model) throws ParseException {

        ProjectDTO projectDTO = projectService.read(num);
        // 시작시간, 종료시간 변환
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 시작 시간
        Date startTime = sdf.parse(projectDTO.getStartTime());
        // 종료 시간
        Date endTime = sdf.parse(projectDTO.getEndTime());
        SimpleDateFormat newSdf = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 HH:mm");
        projectDTO.setStartTime(newSdf.format(startTime));
        projectDTO.setEndTime(newSdf.format(endTime));


        log.info("================================");
        log.info("projectDTO : " + projectDTO.toString());
        log.info("================================");

        model.addAttribute("project", projectDTO);

//        model.addAttribute("company", companyService.read(projectVO.getCompanyNum()));
//        model.addAttribute("project", projectVO);
//        model.addAttribute("qna", projectService.getQnAList(num));
//        model.addAttribute("img", projectService.getProjectFileList(num));
        return "/project/projectDetail";
    }

    // 프로젝트 등록 스텝 1
    @GetMapping("/createStep")
    public void createStep(Long num, Model model){
        log.info("=============================================");
        model.addAttribute("company", companyService.read(num));
        log.info(companyService.read(num).toString());
    }

    // 프로젝트 등록
    @PostMapping("/createStepForm")
    public RedirectView projectCreate(ProjectVO projectVO, RedirectAttributes rttr){
        log.info("========================" + projectVO.getCompanyNum());

        projectService.registerProject(projectVO);
        rttr.addFlashAttribute("companyNum", projectVO.getCompanyNum());
        return new RedirectView("/group/main");

    }

    // 프로젝트 수정
    @GetMapping("/modifyProject")
    public String modifyProject(Long num, Model model){
        model.addAttribute("project", projectService.read(num));
        return "project/modifyProject";

    }

    // 프로젝트 수정 폼
    @PostMapping("/modifyProjectForm")
    public String modifyProjectForm(ProjectVO projectVO){
        projectService.update(projectVO);
        return "/group/main";
    }

    // 프로젝트 삭제
    @DeleteMapping("/remove/{num}")
    @ResponseBody
    public void removeProject(Long num){
        projectService.remove(num);
    }

    // 프로젝트 지원
    @PostMapping("/apply")
    @ResponseBody
    public void applyProject(@RequestBody ApplyVO applyVO){
        applyService.apply(applyVO);
    }

    // 유저 프로젝트 시작
    @GetMapping("/apply/start")
    @ResponseBody
    public void userStart(@RequestBody ApplyDTO applyDTO){
        applyService.userStart(applyDTO);
    }

    // 유저 프로젝트 종료
    @GetMapping("/apply/end")
    @ResponseBody
    public void userEnd(@RequestBody ApplyDTO applyDTO){
        applyService.userEnd(applyDTO);
    }

    // 유저 프로젝트 완료
    @GetMapping("/apply/finish/{num}")
    @ResponseBody
    public void userFinish(@PathVariable("num") Long num){
        applyService.userFinish(num);
    }

    // 프로젝트 지원한 유저 목록
    @GetMapping("/apply/list/{projectNum}")
    @ResponseBody
    public List<ApplyDTO> getApplyUser(@PathVariable("projectNum") Long projectNum){
        return applyService.getApplyUser(projectNum);
    }

    // 프로젝트 찜 개수
    @GetMapping("/jjim/{projectNum}")
    @ResponseBody
    public Long getJjim(@PathVariable Long projectNum){
        return jjimService.getJjimCount(projectNum);
    }

    // 프로젝트 찜 여부 조회
    @GetMapping("/jjim/user/{userNum}/{projectNum}")
    @ResponseBody
    public boolean checkJjim(@PathVariable Long userNum, @PathVariable Long projectNum){
        return jjimService.checkUserProject(userNum, projectNum) ? true : false;
    }

    // 프로젝트 찜 등록 및 해제
    @GetMapping("/jjim/add/{userNum}/{projectNum}")
    @ResponseBody
    public boolean addJjim(@PathVariable Long userNum, @PathVariable Long projectNum){
        JjimVO jjimVO = new JjimVO();
        jjimVO.setProjectNum(projectNum);
        jjimVO.setUserNum(userNum);
        jjimVO.setCategory("project");
        // 이미 찜한 유저
        if(jjimService.checkUserProject(userNum, projectNum)){
            jjimService.removeProject(jjimVO);
            return false;
        }else {
            jjimService.addProject(jjimVO);
            return true;
        }
    }


    // 프로젝트 문의 조회(rest)
    @GetMapping("/qna/{projectNum}")
    @ResponseBody
    public List<QnaDTO> removeJjim(@PathVariable Long projectNum){
        return projectQnaService.getList(projectNum);

    }

    // 프로젝트 문의 등록폼
    @GetMapping("/qna/register")
    public String registerQnaForm(Long userNum, Long projectNum, Model model){
        model.addAttribute("user", userSerivce.readUserInfo(userNum));
        return "project/qnaWrite";
    }

    // 프로젝트 문의 등록
    @PostMapping("/qna/register")
    public RedirectView registerQna(ProjectQnaVO projectQnaVO, RedirectAttributes rttr){
        log.info("=================");
        log.info(projectQnaVO.toString());
        projectQnaService.register(projectQnaVO);
        return new RedirectView("/project/projectDetail?num=" + projectQnaVO.getProjectNum());
    }

    // 프로젝트 문의 수정

    // 프로젝트 문의 삭제


    // 프로젝트 문의 답변글 조회
    @GetMapping("/qna/reply/{qnaNum}")
    @ResponseBody
    public List<ProjectQnaCommentVO> getComment(@PathVariable Long qnaNum){
        return projectQnaCommentService.getComment(qnaNum);
    }


}
