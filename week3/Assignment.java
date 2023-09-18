package com.example.withfhture.week3;

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


}
