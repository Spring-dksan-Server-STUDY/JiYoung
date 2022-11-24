package com.example.jiyoung.study3.service;

import com.example.jiyoung.study2.Member;
import com.example.jiyoung.study3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional //데이터 관련
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @GetMapping("")
    @ResponseBody
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }
}
