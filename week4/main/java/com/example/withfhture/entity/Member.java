package com.example.withfhture.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "member")
public class Member {

    @Id
    @Column(name="member_id")
    private UUID memberId;

    @Column(name =  "member_name")
    private String memberName;

    public void MemberUpdate(UUID memberId,String memberName){
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
