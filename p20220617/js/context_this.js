// 객체와 클래스
// p112 객체 메서드 안에 추가한 함수의 this 접근

let obj = {};

// 객체 메서드 act() 생성
obj.act = function(){
    this.value = 'default value';

    // act() 안에 innerAct()
    function innerAct(){
        this.value = 'innerAct value';
        console.log('this. value : ' + this.value);
    }
    // 객체 참조를 넘기는 act() 메소드 안의 추가 함수
    function innerReact(caller){
        caller.value = 'innerReact value';
        console.log('this.value: ' + this.value);
        console.log('caller.value: ' + caller.value);
    }

    innerAct(); // 1. innerAct value
    console.log('obj 객체의 this.value : ' + this.value); // 2. default value 

    innerReact(this); // 3. innerAct value 4. innerReact value
    console.log('obj 객체의 this.value : ' + this.value); // 5. innerReact value 
}

console.log(obj.act());