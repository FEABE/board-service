package com.pratice.boardservice.repository;

import com.pratice.boardservice.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long>{
}
