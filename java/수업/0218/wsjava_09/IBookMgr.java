package wsjava_09;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

class QuantityException extends Exception{
	String msg;

	public QuantityException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "QuantityException [msg=" + msg + "]";
	}
	
}

class ISBNNotFoundException extends Exception{
	String msg;

	public ISBNNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ISBNNotFoundException [msg=" + msg + "]";
	}
	
}
public interface IBookMgr {
	

	
	//도서 추가
	void add(Book book);
	
	//전체 데이터 검색
	ArrayList<Book> search();
	
	//판매
	void sell(String isbn,int quantity) throws QuantityException, ISBNNotFoundException;
	
	//구매
	void buy(String isbn,int quantity) throws ISBNNotFoundException;
	
	//총 재고 금액
	int getTotalAmount();
	
	//오픈
	void open() throws  Exception;
	
	//클로스
	void close() throws Exception;
}
