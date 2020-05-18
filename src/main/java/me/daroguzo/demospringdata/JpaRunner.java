package me.daroguzo.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Post post = new Post();
        post.setTitle("When is the Algorithm Study?");

        Comment comment = new Comment();
        comment.setComment("4 p.m on Tuesday.");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("No, It will start on Friday.");
        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
        session.save(post);


    }
}
