package com.rsupport.rsupporthomework.service;

import com.rsupport.rsupporthomework.domain.PostFile;
import com.rsupport.rsupporthomework.repository.PostFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostFileService {
    @Autowired
    PostFileRepository postFileRepository;

    public void saveAll(List<PostFile> postFileList){
        postFileRepository.saveAll(postFileList);
    }

}
