package com.rsupport.rsupporthomework.repository;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRepositoryTest {
    @Autowired
    MemberRepository repository;

    /*@AfterEach
    public void afterEach(){
        repository.clearStore();
    }
*/
    //@Test
   /* public void save(){
       Member member = new Member();
        member.setName("test");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }*/

    //@Test
   /* public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualsTo(member1);
    }

    @Test
    public void findByAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }*/
}
