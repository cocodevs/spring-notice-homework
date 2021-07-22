package com.rsupport.rsupporthomework.service;

import com.rsupport.rsupporthomework.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired PostService postService;

    @Autowired MemberService memberService;

    @Test
    public void 공지사항_목록_조회(){
        //given
        Pageable pageable = PageRequest.of(0, 10);
        //when
        Page<Post> postList = postService.findAll(pageable);
        //then
        Assertions.assertThat(postList.getTotalElements()).isEqualTo(2);
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
    @WithMockUser(username = "admin@rsupport.com", password = "1234", roles = "ADMIN")
    public void 공지사항_추가(){
        //given
        Post post = new Post();
        post.setTitle("테스트 공지사항");
        post.setContents("공지사항 내용~!");
        //when
        postService.insertByPost(post);
        //then
        Assertions.assertThat(post.getMember().getId()).isEqualTo(1);
    }

    @Test
    @WithMockUser(username = "admin@rsupport.com", password = "1234", roles = "ADMIN")
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

    @Test
    public void 공지사항_삭제(){
        //given
        Pageable pageable = PageRequest.of(0, 10);
        Page<Post> postList = postService.findAll(pageable);
        Long oldCount = postList.getTotalElements();
        //when
        postService.delete(1L);
        Long newCount = postService.findAll(pageable).getTotalElements();
        //then
        Assertions.assertThat(oldCount).isEqualTo(newCount + 1);
    }
}