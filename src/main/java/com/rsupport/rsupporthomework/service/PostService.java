package com.rsupport.rsupporthomework.service;

import com.rsupport.rsupporthomework.domain.Member;
import com.rsupport.rsupporthomework.domain.Post;
import com.rsupport.rsupporthomework.domain.PostFile;
import com.rsupport.rsupporthomework.repository.PostRepository;
import com.rsupport.rsupporthomework.util.FileUtil;
import com.rsupport.rsupporthomework.util.MemberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    MemberService memberService;

    @Autowired
    PostFileService postFileService;

    @Autowired
    FileUtil fileUtil;

    public Page<Post> findAll(Pageable pageable) {
        if(pageable.getSort().isUnsorted()) {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").descending());
        }
        return postRepository.findAll(pageable);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }

    public Post insertByPost(Post post) {
        Member loginMember = memberService.findByEmail(MemberUtil.getCurrentUserName()).get();
        post.setMember(loginMember);
        return postRepository.save(post);
    }

    public Post insertByPost(Post post, List<MultipartFile> files) throws Exception {
        Member loginMember = memberService.findByEmail(MemberUtil.getCurrentUserName()).get();
        post.setMember(loginMember);
        postRepository.save(post);

        List<PostFile> postFiles = fileUtil.parseFileInfo(post, files);
        post.setPostFiles(postFiles);
        postFileService.saveAll(postFiles);
        return post;
    }

    public Post update(Post post) {
        Member loginMember = memberService.findByEmail(MemberUtil.getCurrentUserName()).get();
        post.setMember(loginMember);
        return postRepository.save(post);
    }

    public Long delete(Long id) {
        Post post = postRepository.findById(id).get();
        postRepository.delete(post);
        return id;
    }
}
