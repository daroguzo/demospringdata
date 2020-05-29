package me.daroguzo.demospringdata;

import java.util.List;

public interface PostCustomRepository {
    List<Post> findMyPost();
}
