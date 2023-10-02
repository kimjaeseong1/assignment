package com.example.withfhture.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member signUp(MemberDTO.MemberReqDTO memberReqDTO){
        try{

            Member member = memberReqDTO.toEntity();
            return memberRepository.save(member);
        }catch (Exception e){
            e.printStackTrace();
            throw  new NullPointerException("회원가입 실패했습니다. ");
        }
    }

    public List<Member> MemberInfo(){
        return memberRepository.findAll();
    }

    public MemberDTO.MemberResDTO MemberKeyInfo(UUID memberId){
        Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new EntityNotFoundException("memberId를 찾을 수 없습니다. "));
        MemberDTO.MemberResDTO memberDetail = new MemberDTO.MemberResDTO(member);

        return memberDetail;

    }

    @Transactional
    public Member MemberUpdate(UUID memberId,MemberDTO.MemberReqDTO memberReqDTO ){
        Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new EntityNotFoundException("memberId를 찾을 수 없습니다. "));

        member.MemberUpdate(member.getMemberId(),memberReqDTO.getMemberName());

        return memberRepository.save(member);

    }

    @Transactional
    public Optional<Member> MemberDelete(UUID memberId){
        Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new EntityNotFoundException("memberId를 찾을 수 없습니다. "));

        return memberRepository.deleteByMemberId(member.getMemberId());
    }
}
