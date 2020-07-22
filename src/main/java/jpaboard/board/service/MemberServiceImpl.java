package jpaboard.board.service;

import jpaboard.board.domain.Member;
import jpaboard.board.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member getMember(Member member){
        Optional<Member> findMember = memberRepository.findById(member.getId());
        if(findMember.isPresent())
            return findMember.get();
        else return null;
    }
}
