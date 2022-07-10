// variable.js

console.log('Hello, World!');
document.write('<h3>Hello, World!<h3>');

let num = 0; /*대입되는 변수에 따라 타입이 정해짐*/
num = 'Hello'; /*string 타입*/
num = 10; /*number 타입*/
num = true; /*boolean 타입*/
num = null; /*object 타입, class의 인스턴스*/

let num1; /*값이 담기지 않은 경우 undefined*/
console.log(typeof num1);

num1 = 100;
num2 = 200; // 변수의 선언이 없이 사용되면 전역 객체 (윈도우)의 속성으로 간주하므로, let을 선언한 후에 값을 담는 것이 좋다
console.log(num1 + num2); // num2를 선언한 적이 없는데도 계산이 된다
console.log(window); // navigator안에 num2가 들어가있는 것을 확인할 수 있다
console.log(window.navigator.num2); // undefined
window.navigator.num2
// window.alert('h2')

// 변수에 학생이름, 학생번호, 영어, 수학 등 복합적인 정보를 담고 싶을 때
let student = new Object(); //object 타입 선언
student.sno = '22-0123';
student.sname = '홍길동';
student.eng = 90;
student.math = 95;

console.log(student);

// 이런 방법도 가능하다
let person = {
    // object 안에 선언된 변수(?)를 필드라고 하지 않고 속성(property)이라고 한다
    // html 안의 속성(attribute)이랑은 다름;
    pname: '홍길동',
    age: 20,
    height: 180,
    // object 안에 메소드를 선언할 수 있다
    // object 안에 선언되는 기능을 함수라고 하지 않고 메소드라고 한다
    showInfo: function () {
        return this.pname + ', ' + this.age + ', ' + this.height;
    }
};

person.weight = '74'; // 속성 추가

console.log(person);
console.log(person.pname); // 속성 값을 불러오기 위해서 dot연산자 사용
console.log(person['age']); // 이런 식으로 속성 값을 불러올 수도 있다
console.log(person.showInfo); // 함수의 생김새가 출력됨
console.log(person.showInfo());

let field = 'height';
console.log(person[field]);

// 전체 필드를 읽기 위해서 for in 반복문을 사용한다
// for 반복문에서 사용되는 필드는 일회용이며 person.field와 다른놈
// debugger;
for (let field in person) {
    // console.log(field);
    console.log(field, '=>', person[field]);
}

// 변수: me => 이름, 취미, 연락처, 주소, 소개(showInfo)
let me = {
    myName: '이희수',
    myAga: 29,
    myHobby: 'running',
    myPhoneNo: '010-7181-xxxx',
    myAddr: '대구광역시 중구',
    showInfo: function(){
        return this.myName + '/' + this.myAga + '/' + this.myHobby + '/' + this.myPhoneNo + '/' + this.myAddr;
    }
};
console.log(me.showInfo());

