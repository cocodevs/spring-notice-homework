package com.rsupport.rsupporthomework.repository;

import com.rsupport.rsupporthomework.domain.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
}
