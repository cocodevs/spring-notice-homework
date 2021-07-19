package com.rsupport.rsupporthomework.service;

import com.rsupport.rsupporthomework.repository.MemberRepository;


class MemberServiceTest {
    MemberService memberService;
    MemberRepository memberRepository;

    /*@BeforeEach
    public void beforeEach(){
        memberRepository = new MemberRepository();
        memberService = new MemberService(memberRepository);
    }*/

    //@Test
    /*public void join(){
        //given
        Member member = new Member();
        member.setName("name");

        //when
        //Long saveId = memberService.join(member);

        //then
        //Member findMember = memberService.findOne(saveId).get();
        //Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

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