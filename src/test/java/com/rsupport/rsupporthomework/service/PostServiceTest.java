package com.rsupport.rsupporthomework.service;

import com.rsupport.rsupporthomework.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired PostService postService;

    @Test
    public void 공지사항_목록_조회(){
        //given
        //when
        List<Post> postList = postService.findAll();
        //then
        Assertions.assertThat(postList.size()).isEqualTo(2);
    }

    @Test
    public void 공지사항_단건_조회(){
        //given
        Long postId = 1L;
        //when
        Post post = postService.findById(postId);
        //then
        Assertions.assertThat(post.getTitle()).isEqualTo("공지사항 1");
    }

    @Test
    public void 공지사항_추가(){
        //given
        Post post = new Post();
        post.setTitle("테스트 공지사항");
        post.setContents("공지사항 내용~!");
        post.setCreateId(1L);
        //when
        postService.insertByPost(post);
        //then
        Assertions.assertThat(post.getId()).isEqualTo(3);
    }

    @Test
    public void 공지사항_수정(){
        //given
        Post post = postService.findById(1L);
        //when
        post.setTitle("수정된 공지사항 1");
        postService.update(post);
        Post post2 = postService.findById(1L);
        //then
        Assertions.assertThat(post2.getTitle()).isEqualTo("수정된 공지사항 1");
    }

    @Test void 타인이_게시한_공지사항_수정(){
        //given

        //when

        //then
    }
}