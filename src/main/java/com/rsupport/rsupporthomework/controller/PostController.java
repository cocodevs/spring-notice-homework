package com.rsupport.rsupporthomework.controller;

import com.rsupport.rsupporthomework.domain.Post;
import com.rsupport.rsupporthomework.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    /**
     * 공지사항 목록 조회
     */
    @GetMapping
    public String getPostList(ModelMap map, Pageable pageable){
        map.addAttribute("postList", postService.findAll(pageable));
        return "/post/list";
    }

    /**
     * 공지사항 단건 조회
     */
    @GetMapping("/{id}")
    public String getPost(@PathVariable Long id, ModelMap map){
        map.addAttribute("post", postService.findById(id));
        return "/post/view";
    }

    /**
     * 공지사항 등록 페이지
     */
    @GetMapping("/create-form")
    public String getWriteForm(ModelMap map){
        map.addAttribute("post", new Post());
        return "/post/create";
    }

    /**
     * 공지사항 등록
     */
    @PostMapping
    public String createPost(Post post, @RequestParam("files") List<MultipartFile> files) throws Exception {
        postService.insertByPost(post, files);
        return "redirect:/posts";
    }

    /**
     * 공지사항 수정 페이지
     */
    @GetMapping("/modify-form/{id}")
    public String getModifyForm(@PathVariable Long id, ModelMap map){
        map.addAttribute("post", postService.findById(id));
        return "/post/modify";
    }

    /**
     * 공지사항 수정
     */
    @PutMapping("/{id}")
    public String putPost(@ModelAttribute Post post){
        postService.update(post);
        return "redirect:/posts";
    }

    /**
     * 공지사항 삭제
     * */
    @DeleteMapping("/{id}")
    @ResponseBody
    public Long deletePost(@PathVariable Long id){
        return postService.delete(id);
    }

}
