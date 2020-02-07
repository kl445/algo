package com.ssafy;

import java.util.Scanner;

public class MovieTest {
	static int select = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		MovieMgr m = MovieMgr.getInstance();

		
		m.add(new Movie("기생충","봉준호",15,"스릴러","송강호 얍얍얍"));
		m.add(new Movie("디워","심형래",15,"판타지","미국에 괴물"));
		m.add(new Movie("암살","최동훈",15,"스릴러","전지현쌍둥이"));
		m.add(new Movie("베테랑","류승완",15,"액션","황정민 얍얍얍"));
		m.add(new Movie("설국열차","봉준호",15,"스릴러","차가운 송강호"));
		m.add(new Movie("기생충비슷한 연가시","박정우",15,"스릴러","김명민이나옴"));
		
		while (select != 0) {
			mainPage();
			
			
			
			select = sc.nextInt();

			switch (select) {

			case 1: {
				System.out.println("영화 tilte:");
				String title = sc.next();
				System.out.println("영화 director:");
				String director = sc.next();
				System.out.println("영화 grade:");
				int grade = sc.nextInt();
				System.out.println("영화 genre:");
				String genre = sc.next();
				System.out.println("영화 summary:");
				String summary = sc.next();

				m.add(new Movie(title, director, grade, genre, summary));
				break;
			}

			case 2: {
				Movie[] temp = m.search();
				for (Movie movie : temp) {
					if(movie!=null) {
					System.out.println(movie);
					}
				}
				break;
			}
			case 3: {
				System.out.println("검색할 영화:");
				String title = sc.next();
				Movie[] temp = m.search(title);
				for (Movie movie : temp) {
					if(movie!=null) {
						System.out.println(movie);
						}
				}
				break;
			}

			case 4: {
				System.out.println("검색할 장르:");
				String genre = sc.next();
				Movie[] temp = m.searchGenre(genre);
				for (Movie movie : temp) {
					if(movie!=null) {
						System.out.println(movie);
						}
				}
				break;
			}

			case 5: {
				System.out.println("삭제할 영화명:");
				String title = sc.next();
				m.delete(title);
				break;
			}

			case 6: {
				System.out.println("검색할 감독:");
				String name = sc.next();
				Movie[] temp = m.searchDirector(name);
				for (Movie movie : temp) {
					if(movie!=null) {
						System.out.println(movie);
						}
				}
				break;
			}
			case 7: {
				System.out.print("영화 정보 개수:");
				System.out.println(m.getSize());
				break;
			}
			}

			System.out.println("메인 화면으로 돌아가려면 아무거나 입력하세요");
			sc.next();

		}

	}

	public static void mainPage() {
		System.out.println("<<  영화 관리 프로그램  >>");
		System.out.println("1. 영화 정보 입력");
		System.out.println("2. 영화 정보 전체 검색");
		System.out.println("3. 영화명 검색");
		System.out.println("4. 영화 장르별 검색");
		System.out.println("5. 영화정보 삭제");
		System.out.println("6. 영화 감독별 검색");
		System.out.println("7. 영화정보 개수");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택하세요._");
	}

}
