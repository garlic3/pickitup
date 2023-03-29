package com.example.pickitup.controller;

import com.example.pickitup.service.UserSerivce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/pickitup/*")
@RequiredArgsConstructor
public class RController {
    private final UserSerivce userSerivce;

    // 댓글
    @PostMapping("/comment")
    public void addComment(){

    }

    // 문의글
    @PostMapping("/reply")
    public void addQnA() {

    }

    // qr생성
    @PostMapping("/qr")
    public void addQr(){

    }

    // 관리자 프로젝트 승인
    @GetMapping("/approveProject")
    public void approveProject(){

    }

    // 관리자 단체유저 승인
    @GetMapping("/approveProduct")
    public void approveProduct(){

    }

    // 찜추가
    @PostMapping("/jjim")
    public void addJjim(){

    }

    // 찜해제
    @DeleteMapping("/jjim")
    public void removeJjim(){

    }
    //이메일 중복확인
    @PostMapping("/emailMatching")
    public int match(@RequestParam String email){
        log.info("email test 띄워짐? : "+email.toString());
        return userSerivce.emailcheck(email);
    }
}
