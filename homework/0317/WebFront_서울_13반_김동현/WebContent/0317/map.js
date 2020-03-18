/**
 * MyMap 생성자로 사용될 함수를 구현
 */


function MyMap() {
  this.data = {};//{}<- 이것두 객체야. 아직 내용은 없음(저장할 수 있는 값들의 갯수를 처음에 모르니)
  this.count = 0;//data안에 저장된 내용들의 갯수 저장하고 있는 변수. 하나 선언해 쓰면 편할 듯
}

//function 붙이기
//for in 돌릴때도 this 붙이기
MyMap.prototype = {
  put:function(key, value) {
    this.data[key] = value;
    this.count++;
  },
  
  size:function() {
	  var count = 0;
      for (var dat in this.data) {
        count++;
      }
      return count;

  },
  get:function(key) {

	  return this.data[key];
  },
  
  remove(key) {
	  delete this.data[key];
		  
  },
  clear() {
	  for(var dat in this.data){
	      delete this.data[dat];
	     }


  }
};