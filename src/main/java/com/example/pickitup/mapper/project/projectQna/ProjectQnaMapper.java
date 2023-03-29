package com.example.pickitup.mapper.project.projectQna;

import com.example.pickitup.domain.vo.dto.QnaDTO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProjectQnaMapper {

//    qan 상세보기 class101에 없음 qna+comment 세트로 불러옴
//    관리자에서 필요함 관리자가 댓글 달아준것만 리스트 업
//    public List<ProjectQnaVO> getDetail(Long projectNum);

    // qna 목록 조회
    public List<QnaDTO> getList(Long projectNum);

    // qna 등록
    public void insert(ProjectQnaVO projectQnaVO);

    // qna 수정
    public boolean update(ProjectQnaVO projectQnaVO);

    // qna 삭제
    public boolean delete(Long num);


}
