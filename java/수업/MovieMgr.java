package com.ssafy;

public class MovieMgr {

	private Movie[] movies = new Movie[100];
	private int index;

	private MovieMgr() {
	}

	private static MovieMgr instance;

	public static MovieMgr getInstance() {
		if (instance == null) {
			instance = new MovieMgr();
		}
		return instance;
	}

	// 추가0
	public void add(Movie m) {
//		System.out.println(index);
		if (index < 100) {
			movies[index++] = m;
		}
	}

	// 모든 영화정보 리턴0
	public Movie[] search() {

		int idx = 0;
		Movie temp[] = new Movie[index];
		for (Movie movie : movies) {
			if (movie != null) {
				temp[idx++] = movie;
			}
		}
		return temp;
	}

	// 타이틀로 영화정보 찾기0
	public Movie[] search(String title) {
		int idx = 0;
		Movie[] temp = new Movie[index];
		for (Movie movie : movies) {
			if (movie != null) {
				if (movie.getTitle().contains(title)) {
					temp[idx++] = movie;
				}
			}
		}
		return temp;
	}

	// 감독의 모든 영화정보 찾기0
	public Movie[] searchDirector(String name) {
		int idx = 0;
		Movie[] temp = new Movie[index];

		for (Movie movie : movies) {
			if (movie != null) {
				if (movie.getDirector().contains(name)) {
					temp[idx++] = movie;
				}
			}
		}
		return temp;
	}

	// 해당장르의 모든 영화 정보 찾기0
	public Movie[] searchGenre(String genre) {
		int idx = 0;
		Movie[] temp = new Movie[index];

		for (Movie movie : movies) {
			if (movie != null) {
				if (movie.getGenre().contains(genre)) {
					temp[idx++] = movie;
				}
			}
		}
		return temp;
	}

	// 해당영화정보 삭제0
	public void delete(String title) {
		for (Movie movie : movies) {
			if (movie != null) {
				if (movie.getTitle().equals(title)) {
					index--;
				}
			}
		}
		int idx=0;
		
		for (Movie movie : movies) {
			if(movie!=null && idx<index) {
				if (movie.getTitle().equals(title)) {}
				else {
					movies[idx++]=movie;
				}
			}
		}
		movies[index]=null;
		
		
	}

	// 영화정보 개수 리턴0
	public int getSize() {

		int cnt = 0;
		for (Movie movie : movies) {
			if (movie != null) {
				cnt++;
			}
		}
		return cnt;
	}

}
