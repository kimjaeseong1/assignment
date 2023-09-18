package com.example.withfhture.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.Clock;
import java.util.*;
import java.util.stream.Stream;

public class MemberProgram extends Menu {



    public void memberProgram(int menuNum,Set<MemberDTO> members,BufferedReader br) throws IOException {


        if (menuNum == 1) {
            if (members.isEmpty()) {
                System.out.println("회원이 없어서 조회 할 수 없습니다.");
            } else {
                members.forEach(member -> System.out.printf("Key: %s, Member: %s%n", member.getKey(), member.getName()));
            }
        }
        /*
        key로 조회
         */
        else if (menuNum == 2) {
            System.out.println("회원을 입력해주세요.");
            String memberKey = br.readLine();

            Optional<MemberDTO> findMember = members.stream()
                    .filter(member -> member.getKey().toString().equals(memberKey))
                    .findFirst();

            if(findMember.isPresent()){
               MemberDTO member= findMember.get();
               System.out.printf("회원: %s%n", member.getName());
            }else{
                System.out.printf("회원의 정보를 찾을 수 없습니다.");
                System.out.println();
            }
        }
        /*
        신규 레코드 추가
         */
        else if (menuNum == 3) {
            System.out.println("추가 할 회원을 입력해주세요.");
            String name = br.readLine();

            UUID Key = UUID.randomUUID();
            MemberDTO newMember = new MemberDTO(Key,name);
            members.add(newMember);

        }
        /*
        key를 기반으로 갱신
         */
        else if (menuNum == 4) {
            System.out.println("갱신할 KEY를 입력해주세요.");
            String name = br.readLine();

            Optional<MemberDTO> findMember = members.stream()
                    .filter(member -> member.getKey().toString().equals(name))
                    .findFirst();

            if(findMember.isPresent()){
                System.out.println("갱신할 이름을 입력해주세요");
                String newName = br.readLine();
                MemberDTO member = findMember.get();
                member.setName(newName);

                System.out.println(newName + "으로 갱신되었습니다.");
            }else{
                System.out.println("갱신할 회원 정보를  찾을 수 없습니다.");

            }

        }
        /*
        key를 기반으로 삭제
         */
        else if (menuNum == 5) {
            System.out.println("삭제할 KEY를 입력해주세요.");
            String Key = br.readLine();

            boolean remove = members.removeIf(member ->member.getKey().toString().equals(Key));

            if(remove){
                System.out.println("회원 정보가 삭제 되었습니다.");
            }else{
                System.out.println("삭제할 회원 정보를 찾을 수 없습니다.");
            }
        }
    }


}
