package com.example.withfhture.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.Clock;
import java.util.*;

public class MemberProgram extends Menu {

    public void memberProgram(int menuNum, Set<HashMap<String,Object>> members, BufferedReader br) throws IOException {

        Iterator<HashMap<String, Object>> iterator = members.iterator();
        boolean found = false;
        if (menuNum == 1) {
            if (members.isEmpty()) {
                System.out.println("회원이 없어서 조회 할 수 없습니다.");
            } else {
               while(iterator.hasNext()){
                   HashMap<String,Object> member = iterator.next();
                   System.out.printf("Key: %s%nMember: %s%n", member.get("Key"), member.get("Member"));

               }
            }
        }
        /*
        key로 조회
         */
        else if (menuNum == 2) {
            System.out.println("회원을 입력해주세요.");
            String member = br.readLine();

            while (iterator.hasNext()){
                HashMap<String,Object> keyMember = iterator.next();
                if(keyMember.get("Key").equals(member)){
                    System.out.printf("회원:  " + keyMember.get("Member"));
                    System.out.println();
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("회원 정보를 찾울 수 없습니다. ");
            }
        }
        /*
        신규 레코드 추가
         */
        else if (menuNum == 3) {
            System.out.println("추가 할 회원을 입력해주세요.");
            String name = br.readLine();

            HashMap<String,Object> addMember = new HashMap<>();

            addMember.put("Key",UUID.randomUUID().toString());
            addMember.put("Member",name);

            members.add(addMember);
            System.out.println(name + " 회원이 추가되었습니다.");
        }
        /*
        key를 기반으로 갱신
         */
        else if (menuNum == 4) {
            System.out.println("갱신할 KEY를 입력해주세요.");
            String unique = br.readLine();

            while(iterator.hasNext()){
                HashMap<String,Object> updateMember = iterator.next();
                if(updateMember.get("Key").equals(unique)){
                    System.out.println("갱신할 이름을 입력해주세요");
                    String update = br.readLine();
                    updateMember.put("Member",update);

                    System.out.println(update + "으로 갱신되었습니다.");
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("갱신할 KEY를 찾지 못했습니다.");
            }

        }
        /*
        key를 기반으로 삭제
         */
        else if (menuNum == 5) {
            System.out.println("삭제할 KEY를 입력해주세요.");
            String unique = br.readLine();

            while(iterator.hasNext()){
                HashMap<String,Object> deleteMember = iterator.next();

                if(deleteMember.get("Key").equals(unique)){
                    iterator.remove();
                    System.out.println(deleteMember.get("Member") + "회원위 정보가 삭제되었습니다.");
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("삭제할 KEY를 찾지 못했습니다.");
            }
        }
    }
}
