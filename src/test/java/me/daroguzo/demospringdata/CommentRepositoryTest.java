package me.daroguzo.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud(){
        Comment comment = new Comment();
        comment.setComment("spring data jpa");
        comment.setLikeCount(100);
        commentRepository.save(comment);
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));
        Page<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);
        assertThat(comments.getNumberOfElements()).isEqualTo(1);
    }
}