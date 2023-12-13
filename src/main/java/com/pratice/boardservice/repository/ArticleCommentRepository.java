package com.pratice.boardservice.repository;

import com.pratice.boardservice.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment,Long>{

}
