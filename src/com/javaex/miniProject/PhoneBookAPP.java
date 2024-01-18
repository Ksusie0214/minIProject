package com.javaex.miniProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookAPP {
	
	public static void main(String[] args) throws IOException{
		
		//파일 읽어오기
		FileReader fr = new FileReader("C:\\javaStudy\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		//리스트 만들기
		ArrayList<Person> pList = new ArrayList<Person>();
		
		
		//읽기 반복, 남은게 없으면 끝
		while(true) {
			String str = br.readLine();
			if(str == null) {
				break;
			}
			
		//읽은 정보 끊어서 저장하기
			String[] pInfo = str.split(",");
			String name = pInfo[0];
			String hp = pInfo[1];
			String company = pInfo[2];
			
			Person p01 = new Person(pInfo[0], pInfo[1], pInfo[2]);
			
			pList.add(p01);
			
		}
		
		//전화번호 관리프로그램 출력
		
		System.out.println("***********************************************");
		System.out.println("*            전화번호 관리 프로그램           *");
		System.out.println("***********************************************");
		
		Scanner sc = new Scanner(System.in);
		
		//메뉴찾기 프로그램 반복
		
		while(true) {
			System.out.println("1. 리스트   2. 등록   3.삭제    4.검색    5.종료");
			System.out.println("-----------------------------------------------");
			System.out.println(">메뉴번호: ");
			int no = sc.nextInt();
		
		//선택지별 동작 작성
			//1번 리스트 출력
			if(no == 1) {
				System.out.println("<1.리스트>");
				for(int i = 0; i<pList.size();i++) {
					System.out.print(i+1);
					pList.get(i).showInfo();
				}
			}
			
			//2번 리스트 등록
			else if(no == 2) {
				//새로운 정보 입력받기
				
				sc.nextLine();
				System.out.println("<2.등록>");
				System.out.println(">이름: ");
				String pName = sc.nextLine();
				System.out.println(">휴대전화: ");
				String pHp = sc.nextLine();
				System.out.println(">회사전화: ");
				String pCompany = sc.nextLine();
				
				//등록되었다는 문구 출력
				
				System.out.println("등록되었습니다.");
				
				//새로 리스트에 등록
				
				Person p02 = new Person(pName, pHp, pCompany);
				pList.add(p02);
				
				FileWriter fw = new FileWriter("C:\\javaStudy\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(Person p : pList) {
					bw.write(p.getName()+","+p.getHp()+","+p.getCompany());
					bw.newLine();
				}
				
				bw.close();
			}
			
			//3번 리스트 삭제
			else if(no == 3) {
				System.out.println("<3.삭제>");
				System.out.println(">번호: ");
				int num = sc.nextInt();
				pList.remove(num-1);
				
				System.out.println("삭제되었습니다.");
				
				FileWriter fw = new FileWriter("C:\\javaStudy\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(Person p : pList) {
					bw.write(p.getName()+p.getHp()+p.getCompany());
					bw.newLine();
				}
				
				
				bw.close();
			}
			
			//5번 프로그램 종료
			
			else if(no == 5) {
				System.out.println("********************************************");
				System.out.println("*                 감사합니다               *");
				System.out.println("********************************************");
				break;
			}
			
			//n번 없는 메뉴 안내
			else if(no>5){
				System.out.println("다시 입력해주세요.");
			}
			else if(no<=0) {
				System.out.println("다시 입력해주세요.");
			}
			
		}
		
		br.close();
		sc.close();
		
	}

}
