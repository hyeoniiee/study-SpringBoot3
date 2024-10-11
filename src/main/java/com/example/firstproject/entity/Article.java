package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article {

    @Id // 엔티티의 대표값 지정
    @GeneratedValue // 자동 생성 기능 추가 (숫자가 자동으로 매겨짐)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

}
