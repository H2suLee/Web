// 문자열 변환 함수 .valueOf()

let str = 'Hello'; // 문자열
let str1 = new String('Hello'); // 객체

console.log(str);
console.log(str1);
console.log(str == str1); // true, == 값만 비교
console.log(str === str1); // false, === 값과 타입까지 비교

document.write(str); // Hello
document.write(str1);  // Hello

console.log(str1.valueOf()); // Hello
console.log(str === str1.valueOf()); // true

console.log('123');
console.log((123).valueOf());
console.log(('123').valueOf());

let num = new Number(123); // 객체
let numt = num.valueOf();
let numr = 123
console.log(numt === numr); // true

// 원시타입: string, number, boolean, undefined
// 객체타입(Object): 함수, Object(), 배열, null

console.clear();

// p160~
let str2 = '      hello    '.trimEnd(); // 공백제거, trim(), trimStart(), trimEnd()
str2 = "This is the only story".slice(10, 15); // 문자 절단(begin index, end index), e onl
str2 = "This is the only story".slice(0, -10); // end Index에 음수를 쓸 경우 문자열길이+마이너스값, This is the 반환
str2 = "This is the only story".slice(8, 100); // end Index가 문자열 길이보다 클 경우 마지막 인덱스 +1, this only story
str2 = 'Hello'.substring(2,3); // 문자 추출(begin index, end index), l, 음수 넣으면 0으로 반환하는 것이 slice 와 가장 큰 차이점
str2 = 'This is the only one story'.substr(8, 11); // (begin idx, length) 8번째부터 11개 문자 반환, the only on, 길이에 음수를 넣으면 0으로 반환하여 빈문자열이 출력됨. 구닥다리

console.log(str2);

// p163~ toString
const num1 = 123;
const num2 = 123.45;
const bool = true;
const strVal = '문자열타입';
const arr = [1,2,'a','b',3];
const obj = {key: 'data', value: 15};

console.log(num1.toString());
console.log(num2.toString());
console.log(bool.toString());
console.log(strVal.toString());
console.log(arr.toString()); // 1,2,a,b,3
console.log(obj.toString()); // [object Object], 문자열이 아닌 객체를 반환
console.log(obj.key.toString()); // data
console.log(obj.value.toString()); // 15

// replace(orgvalue, replacevalue)
let thisis = 'This is the only one story'.replace('the','THE');
console.log(thisis);


//p164~ indexOf(value[, index]), 찾은 문자열의 시작 위치 얻기
let strr = 'good morning, good afternoon, good evening, and good night';
console.log(strr.indexOf('even')); // 35
console.log(strr.lastIndexOf('good')); // 48, 뒤에서부터
console.log(strr.lastIndexOf('dawn')); // -1, 없으면 -1 반환, 문자열 존재 여부를 판단하기에 좋다.
console.log(strr.indexOf('good', 15)); // 30, 두번째 인자는 검색을 시작하는 위치 지정

// charAt(index), 특정 위치의 문자 1개를 얻기
console.log(strr.charAt(30)); // g
console.log(strr.charAt(100)); // 위치 설정이 잘못되면 빈문자열 반환

// includes(value), 특정 문자열이 포함되어 있는 지 알기
console.log(strr.includes('even')); // true
console.log(strr.includes('dawn')); // false

// toLowerCase, toUpperCase
console.log(strr.toUpperCase()); 

// toLowerCase().indexOf(value), search 대소문자 구분없이 문자열 위치 찾기
strr = 'good morning, good afternoon,  GOOD EVENING, AND GOOD NIGHT';
console.log(strr.toLowerCase().indexOf('good')); // 0
console.log(strr.toUpperCase().indexOf('GOOD')); // 0
console.log(strr.search('GOOD')); // 31, 대소문자 구분함
console.log(strr.search(/GOOD/i)); // 0, 정규표현식에다가 i option을 쓰면 대소문자 구분 안 함

// /value/, 정규 표현식과 일치하는 모든 문자열을 찾기

let regStr = 'bad MORNING, GOOD AFTERNOON, good evening, and good night';
console.log('  raw data: ' + regStr);
console.log('/good\s\w+/gi: ' + regStr.match(/good\s\w+/gi)); // good 뒤에 공백 1개가 있고, 그 뒤에 단어 1개가 있는 패턴인 것을 모두 찾음
console.log('/bad\s\w+/gi: ' + regStr.match(/bad\s\w+/gi)); // bad 뒤에 공백 1개가 있고, 그 뒤에 단어 1개가 있는 패턴인 것을 모두 찾음
console.log('/none\s\w+/gi: ' + regStr.match(/none\s\w+/gi)); // null, none 뒤에 공백 1개가 있고 그 뒤에 단어 1개가 있는 패턴
console.log('good 문자열 인 것 1개를 찾음: ' + regStr.match('good')); // good


// /value/, 정규 표현식과 일치하는 문자열 바꾸기
regStr = 'GOOD MORNING, GOOD AFTERNOON, good evening, and good night';
console.log(regStr.replace('good', 'bad')); // 대소문자를 구분하므로 세번째 good만 바뀐다
console.log(regStr.toLowerCase().replace('good', 'bad')); // 모두 소문자로 바꾸고 앞에 1개만 바뀐다
console.log(regStr.replace(/good/i, 'bad')); // i option으로 대소문자를 구분안하고 앞에 1개만 바뀐다
console.log(regStr.replace(/good/gi, 'bad')); // gi option으로 모든 good, GOOD을 bad로 바꿔준다

// 문자열 합치기: 결합연산자 +를 쓰거나, .concat(value) 쓰기
console.clear();
str1 = '문자열1';
str2 = '문자열2';
str3 = '문자열3';
console.log(str1.concat(str2));
console.log(''.concat(str1, str3));

let strarr = ['good', ' ', 'morning', '!'];
console.log(''.concat(strarr)); // good, ,morning,!
console.log(''.concat(...strarr)); // good morning!











