package com.pratice.boardservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),

})
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL은 IDENTITY, ORACLE은 SEQUENCE
    private Long id;
    @Setter
    @Column(nullable = false)
    private String title;
    @Setter
    @Column(nullable = false,length = 10000)
    private String content;
    @Setter
    private String hashtag;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(nullable = false,length = 100)
    private String createdBy;


    @OrderBy
    @ToString.Exclude
    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL,orphanRemoval = true)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();



    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;
    @Column(nullable = false,length = 100)
    @LastModifiedBy
    private String modifiedBy;

    protected Article(){
    }

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String content, String hashtag) {
      return new Article(title,content,hashtag);
    }

    @Override
    //pattern variable 이다 자세한건 자바 14버전에서 확인가능함
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id!=null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
