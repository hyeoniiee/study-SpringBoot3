package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해 놓은 피라지터리 객체 주입(DI) : 의존성 주입
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){ // form 데이터를 DTO 로 받기
        System.out.println(form.toString()); // DTO 에 form 데이터가 잘 담겼는지 확인
        // 1. DTO 를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println(article.toString()); // DTO 가 엔티티로 잘 변환되는지 확인 출력
        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString()); // article 이 DB 에 잘 저장되는지 확인 출력
        return "articles/create";
    }

}
