package com.rsupport.rsupporthomework.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public class PostFile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFileName;

    private String filePath;

    private Long fileSize;

    @ManyToOne(fetch=FetchType.LAZY)
    private Post post;
}