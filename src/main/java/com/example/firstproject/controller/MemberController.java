package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class MemberController {

    @Autowired private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String newSignUpForm() {
        return "members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm memberForm) {
        log.info(memberForm.toString());
        //System.out.println(memberForm.toString());

        Member member = memberForm.toEntity();
        log.info(member.toString());
        //System.out.println(member.toString());

        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        //System.out.println(saved.toString());

        return "members/create";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        // 1. id 를 조회해 데이터 가져오기
        Member member = memberRepository.findById(id).orElse(null);

        // 2. 모델에 데이터 등록하기
        model.addAttribute("member", member);

        // 3. 뷰 페이지 반환하기
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        // 1. id 를 조회해 데이터 가져오기
        List<Member> memberList = memberRepository.findAll();

        // 2. 모델에 데이터 등록하기
        model.addAttribute("memberList", memberList);

        // 3. 뷰 페이지 반환하기
        return "members/index";
    }
}
