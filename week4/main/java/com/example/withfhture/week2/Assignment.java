package com.example.withfhture.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Assignment {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Set<MemberDTO> members = new HashSet<>();
        MemberProgram program = new MemberProgram();

        

        while (true) {
            program.menu();
            int menuNum = memberNumCheck(Integer.parseInt(br.readLine()));
            program.memberProgram(menuNum,members,br);
            if (menuNum == 6) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    public static int memberNumCheck(int menuNum){
        if (menuNum < 1 || menuNum > 6) {
            System.out.println("화면에 있는 번호를 입력해주세요.");
            menuNum = 0;
        }
        return menuNum;
    }

//    public static void menu(){
//        System.out.println("===================");
//        System.out.println("1. 전체조회");
//        System.out.println("2. key로 조회");
//        System.out.println("3. 신규레코드 추가");
//        System.out.println("4. key를 기반으로 갱신 ");
//        System.out.println("5. key를 기반으로 삭제 ");
//        System.out.println("6. 프로그램 종료 ");
//        System.out.println("===================");
//
//    }

//    public static void memberProgram(int menuNum,HashMap<UUID,String> members) throws IOException {
//
//        if (menuNum == 1) {
//            if (members.isEmpty()) {
//                System.out.println("회원이 없어서 조회 할 수 없습니다.");
//            } else {
//                for (Map.Entry<UUID, String> member : members.entrySet()) {
//                    System.out.println(String.format("Key: %s, Member: %s", member.getKey(), member.getValue()));
//                }
//            }
//        }
//        /*
//        key로 조회
//         */
//        else if (menuNum == 2) {
//            System.out.println("회원을 입력해주세요.");
//            String member = br.readLine();
//            try {
//                UUID key = UUID.fromString(member);
//                String val = members.get(key);
//
//                if (val == null) {
//                    System.out.println("회원 정보가 없습니다.");
//                } else {
//                    System.out.println("회원: " + val);
//                }
//            } catch (IllegalArgumentException e) {
//                System.out.println("잘못된 입력 값입니다.");
//            }
//        }
//        /*
//        신규 레코드 추가
//         */
//        else if (menuNum == 3) {
//            System.out.println("추가 할 회원을 입력해주세요.");
//            String member = br.readLine();
//            members.put(UUID.randomUUID(), member);
//            System.out.println(member + " 회원이 추가되었습니다.");
//        }
//        /*
//        key를 기반으로 갱신
//         */
//        else if (menuNum == 4) {
//            System.out.println("갱신할 회원을 입력해주세요.");
//            String member = br.readLine();
//            try {
//                UUID key = UUID.fromString(member);
//                if (members.containsKey(key)) {
//                    System.out.println("갱신할 회원명을 입력해주세요.");
//                    String updateMember = br.readLine();
//                    members.put(key, updateMember);
//                    System.out.println(updateMember + "으로 갱신 되었습니다.");
//                } else {
//                    System.out.println("갱신할 회원을 찾지 못 했습니다.");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("갱신한 회원을 찾지 못 했습니다.");
//            }
//        }
//        /*
//        key를 기반으로 삭제
//         */
//        else if (menuNum == 5) {
//            System.out.println("삭제할 회원을 입력해주세요.");
//            String member = br.readLine();
//            try {
//                UUID key = UUID.fromString(member);
//                if (members.containsKey(key)) {
//                    String removedMember = members.remove(key);
//                    System.out.println(removedMember + " 회원의 정보가 삭제되었습니다.");
//                } else {
//                    System.out.println("입력하신 회원을 찾을 수 없어 삭제 할 수 없습니다.");
//                }
//            } catch (IllegalArgumentException e) {
//                System.out.println("잘못된 입력 값입니다.");
//            }
//        }
//    }
}
