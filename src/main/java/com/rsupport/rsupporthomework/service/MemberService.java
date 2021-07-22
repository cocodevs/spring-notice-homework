package com.rsupport.rsupporthomework.service;

import com.rsupport.rsupporthomework.domain.Member;
import com.rsupport.rsupporthomework.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {

    private static String ROLE_PREFIX = "ROLE_";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    MemberRepository memberRepository;

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public Long join(Member member) {
        Optional<Member> result = memberRepository.findByEmail(member.getEmail());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setUserRole("1");
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username).get();

        List<GrantedAuthority> authorities = new ArrayList<>();
        if(member.getUserRole().equals("1")){
            authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + "ADMIN"));
        }else{
            authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + "USER"));
        }
        return new User(member.getEmail(), member.getPassword(), authorities);
    }

}
