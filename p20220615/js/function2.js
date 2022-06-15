// function2.js

function sum(n1, n2) {
    return n1 + n2;
};

console.log(sum(10, 20)); // 연산
console.log(sum('10', '20')); // 결합

function minus(v1, v2) {
    return v1 - v2;
};

function div(v1, v2) {
    return v1 / v2;
};
console.log(minus('10', '20')); // 숫자로 자동 형변환
console.log(div('10', '20')); // 숫자로 자동 형변환, *, %도 마찬가지

let result = 0;

function sumAry(ary) {
    for (let num of ary) {
        result += num;
    }
    return result;
};

let numAry = [20, 27, 33, 19, 45]
console.log('배열의 합 : ' + sumAry(numAry));

// 배열.foreach(function()) 
// 콜백함수: 메소드의 매개값으로 함수가 올 수 있음
result = 0;
numAry.forEach(function (a, b, c) { // 익명함수
    console.log('hi'); // hi가 5번 출력됨
    console.log(a, b, c);
    // a는 인덱스별 들어있는 값, b는 인덱스, c는 배열 그 자체
    // 이건 정해져 있는 것임. (?) 
    result = result + a;
});

console.log(result);

// 홀수값들의 합
result = 0;
numAry.forEach(function (val, idx, ary) { // 익명함수
    if (val % 2 == 1) {
        result += val;
    }
});
console.log(result);