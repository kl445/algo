package com.object;

public class Base_Movie_Test {

	public static void main(String[] args) {
		
		Base_Movie mo= new Base_Movie();
		
		mo.title="기생충";
		mo.director="봉준호";
		mo.genre="송강호";
		mo.summary="요약";
		mo.grade=15;
		
		mo.movieInfo();
	}

}
