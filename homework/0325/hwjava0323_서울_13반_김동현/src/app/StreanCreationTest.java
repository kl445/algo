package app;

import java.util.stream.Stream;

public class StreanCreationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		{
			String[] strArray= {"A","B","C"};
			
			Stream<String> stream= Stream.of(strArray);
			print(stream);
		}

	}
	public static void print(Stream<?> stream) {
		
		stream.forEach(a -> System.out.println(a+" "));
		System.out.println();
	}

}
