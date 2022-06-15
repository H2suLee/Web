// variable2.js

// var l1; // hoisting

let ary = new Array(); // | 0 | ~ | 14 | (15칸)
ary[0] = 10;
ary = [20, 30, 15, 27]; // 선언과 동시에 초기화
ary[ary.length] = 50;
ary[ary.length] = 60;
ary[ary.length] = 65;
ary[15] = 100;
console.log(ary); // 60, 65, 빈*8, 100
console.log(ary[7]); // undefined
console.log(typeof ary[7]); // undefined
console.log(ary.length);
for (let i = 0; i < ary.length; i++) {
    console.log(i + '번째 ' + ary[i]);
}

// console.clear(); // 로그 지우기
ary = ['사과', '바나나', '고구마', '수박'];

document.write('-------------------- ul로')

document.write('<ul>');
for (let val of ary) {
    document.write('<li>' + val + '</li>')
};
document.write('</ul>');


document.write('-------------------- p로')

for (let val of ary) {
    console.log(val); // undefined값은 한 번만 띄워줌
    document.write('<p style="padding-left: 50px;">' + val + '<p>');
};

ary = [{
        name: '홍길동',
        age: 20,
        phone: '010-1111-2222'
    },
    {
        name: '김민수',
        age: 21,
        phone: '010-2222-2222'
    },
    {
        name: '박우용',
        age: 22,
        phone: '010-3333-2222'
    },
    {
        name: '최선식',
        age: 23,
        phone: '010-4444-2222'
    }
];

// for of
document.write('-------------------- for of로')

document.write('<ul>');
for (let val of ary) {
    document.write('<li>' + val.name + '의 연락처 : ' + val['phone'] + '</li>');
};
document.write('</ul>');

// 반복문
document.write('-------------------- 반복문')

document.write('<ul>');
for (let i = 0; i < ary.length; i++) {
    document.write('<li>' + ary[i].name + '의 연락처 : ' + ary[i].phone + '</li>');
};
document.write('</ul>');

document.write('-------------------- str 변수에 +=으로 담고 for of로')
let str = '';
str += '<ul>';
for (let val of ary) {
    str += '<li> 이름: ' + val.name + ', 나이: ' + val['age'] + ', 연락처: ' + val['phone'] + '</li>';
};
str += '</ul>';
document.write(str);


document.write('-------------------- str 변수에 +=으로 담고 테이블로<br><br>')

str = ''; // 초기화
str += '<table border=1 style="width: 300px; text-align: center;">';
str += '<tr><th>이름</th><th>나이</th><th>연락처</th></tr>';
for (let val of ary) {
    str += '<tr>';
    str += '<td>' + val.name + '</td><td>' + val['age'] + '</td><td>' + val['phone'] + '</td>';
    str += '</tr>';
};
str += '</table>';
document.write(str);

// constant variable, 상수(final)
console.clear
const v1 = 'hello';
// v1 = 'new'; // 에러남, 값 수정 불가

// 원시타입 vs 참조 타입
// 원시타입
let n1 = 10;
let n2 = n1;
n1 = 20;
console.log(n1, n2); // 20 10

// 참조타입
let o1 = {name: 'one'};
let o2 = o1; // o1이 가진 주소를 담음. 결론적으로 o1과 o2는 같은 주소를 참조함
o2.name = 'two';
o1.name = 'three';
console.log(o1, o2);

const obj = {
    no: '22-123456',
    name: 'con'
}
console.log(obj);

obj.no='22-222222'; // obj 상수 변수에 값을 새롭게 선언하는 것이 아니고, obj가 참조하고 있는 속성값을 변경하는 것이므로 가능
console.log(obj);

// obj = ''; // obj 상수 변수에 새로운 값을 할당하려면 오류남

// var vs. let

// var 변수 선언: 변수의 scope => 전역변수, 지역변수로 나뉨
// 전역변수: 스크립트 내에서 변수 값 유효
// 지역변수: 함수(function) 안에 선언된 변수, 함수 안에서만 값 유효
localFnc(); // 함수 선언하기 전에 호출해도 에러가 나진 않음
var var1 = 'great good find ok';
function localFnc(){
    var var1 = 'many moons ago';
    console.log(var1);
    // console.log(var2);
};
localFnc(); // 함수 밖에서 함수를 호출해 줘야 함수 내에 console.log가 실행됨
console.log(var1);
// console.log(var2); // error

// let
let value1 = 'hi';
{
    // 블록 안의 value1 은 일회용
    let value1 = 'new hi';
    console.log(value1); // new hi
}
console.log(value1); // hi

// hoisting p22
console.log(l1); // undefined
var l1 = 'hello l1';

console.log(l2); // uncaught 에러, initialize하라구 함. var은 hoisting해서 에러는 안내고 undefined을 내는 반면, let은 오류를 냄ㄹㄹ
let l2 = 'hello l2'; 