package me.lee.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 엔티티 지정
@Getter // -> 아래 게터의 역할
@NoArgsConstructor(access = AccessLevel.PROTECTED) // -> 해당 어노테이션이 아래의 기본 생성자 역할
public class Article {
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false) // 업데이트 가능여부, 이 필드의 값은 한 번 설정되면 변경할 수 없음
    private Long id;

    @Column(name = "title", nullable = false) // 'title'이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder // 빌더 패턴으로 객체 생성 ('builder'라는 디자인 패턴임)
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // lombok을 사용하지 않았을 때
    /*
    protected Article() { // 기본 생성자 -> 좀 더 이해가 필요
    }
    // 게터
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    */
}
