package com.example.jiyoung.study3.controller;

import com.example.jiyoung.study2.Member;
import com.example.jiyoung.study3.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController {

    private final MemberService memberService;
    @GetMapping("")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }
}
