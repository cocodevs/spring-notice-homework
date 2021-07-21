package com.rsupport.rsupporthomework.service;

import com.rsupport.rsupporthomework.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Test
    public void join(){
        //given
        Member member = new Member();
        member.setName("이름");
        member.setEmail("coco@naver.com");
        member.setPassword("1234");

        //when
        Member savedMember = memberService.join(member);

        //then
        Member findMember = memberService.findById(savedMember.getId());
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }
/*
    //@Test
    public void duplCheck(){
        //given
        Member member1 = new Member();
        member1.setName("name1");

        Member member2 = new Member();
        member2.setName("name1");

        //when
        memberService.join(member1);
        //assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
    }*/
}