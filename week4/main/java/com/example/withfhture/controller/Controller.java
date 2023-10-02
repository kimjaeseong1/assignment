package com.example.withfhture.controller;

import com.example.withfhture.dto.MemberDTO;
import com.example.withfhture.entity.Member;
import com.example.withfhture.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor

public class Controller {

    private final MemberService memberService;


    @ApiOperation(value = "신규레코드 추가 ")
    @PostMapping("/member")
    public ResponseEntity<String> signup(@RequestBody MemberDTO.MemberReqDTO memberReqDTO){
         memberService.signUp(memberReqDTO);
         return ResponseEntity.ok("멤버 등록 성공하였습니다.");
    }

    @ApiOperation("전체조회")
    @GetMapping("/member")
    public List<Member> MemberInfo(){
        return memberService.MemberInfo();
    }

    @ApiOperation("Key로 조회")
    @GetMapping("/member/key")
    public MemberDTO.MemberResDTO MemberKeyInfo(@RequestParam("memberId") UUID memberId){
        return memberService.MemberKeyInfo(memberId);
    }

    @ApiOperation("Key를 기반으로 갱신")
    @PutMapping("/member")
    public ResponseEntity<String> MemberUpdate(@RequestParam("memberId") UUID memberId ,  MemberDTO.MemberReqDTO memberReqDTO){
         memberService.MemberUpdate(memberId,memberReqDTO);
         return ResponseEntity.ok("회원 갱신 성공");
    }

    @ApiOperation("Key를 기반으로 삭제")
    @DeleteMapping("/member")
    public ResponseEntity<String> MemberDelete(@RequestParam("memberId") UUID memberId){
        memberService.MemberDelete(memberId);

        return  ResponseEntity.ok("회원이 삭제 되었습니다.");
    }
}
