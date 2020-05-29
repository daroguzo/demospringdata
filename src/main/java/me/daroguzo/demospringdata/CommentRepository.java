package me.daroguzo.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.RepositoryDefinition;


import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long>{
    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
}
