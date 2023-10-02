package com.example.withfhture.dto;


import com.example.withfhture.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

public class MemberDTO {

    @Getter
    @NoArgsConstructor
    @Setter
    public static class MemberReqDTO{

        private String memberName;

        public Member toEntity(){
            return Member.builder()
                    .memberId(UUID.randomUUID())
                    .memberName(this.memberName)
                    .build();
        }


        @Builder
        public MemberReqDTO(Member member){
            this.memberName = member.getMemberName();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class MemberResDTO{
        private UUID memberId;
        private String memberName;

        public MemberResDTO(Member member){
            this.memberId = member.getMemberId();
            this.memberName = member.getMemberName();

        }
    }
}
