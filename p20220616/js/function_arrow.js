// 화살표 함수 p81

function add(a, b) {
    return a + b;
}

const add2 = function (a, b) {
    return a + b;
}

const add3 = (a, b) => a + b;

// 규칙
// 파라미터가 0개 일때 괄호 반드시 표기, 1개일 때 생략 가능, 2개 이상이면 () 사용 권장
// return 구문: 블록으로 코드를 감싼 경우 반환할 값이 있으면 반드시 return문으로 반환
// 블록으로 감싼 코드에 return문에 없을 경우 undefined 반환
// 블록을 생략한 경우 return 또한 생략 가능

let multi = (a, b, ...args) => {
    let result = a * b;
    // args.forEach(function(val){
    //     return result *= val;
    // });
    // 이것도 화살표로.. 근데 result*=val 하고 ; < 넣으면 오류남
    args.forEach(val => result *= val)
    return result;
}
console.log(multi(1, 2, 3, 4, 5)); // 120

// 선생님 예제

function sayHey(name) {
    return 'Hey, ' + name + '!';
};
const sayHello = function (name) {
    return 'Hello, ' + name + '!';
};
console.log(sayHello('홍길동'));

// 위 구문을 아래와 같이 화살표 함수로 변형 가능
const sayHi = name => 'Hi, ' + name + '!';
console.log(sayHi('홍길동'));

// forEach안에 콜백 함수이자 익명 함수 호출
let arr = ['홍길동', '김영수', '최민식'];
arr.forEach(function (val, idx, ary) {
    console.log(sayHello(val));
});
// 이걸 화살표로
arr.forEach((val) => console.log(sayHi(val)));

let arrNum = [29, 34, 12, 55, 29, 42];
// 1. 배열의 각 요소 중에 짝수의 값만 더하도록 sumEven();
// 2. 배열의 각 요소 중에 홀수번째 요소의 합만 구하도록 sumOdd();


// 1-1 화살표 안 쓰기
const sumEven = function (ary) {
    let sum = 0;
    ary.forEach(function (val) {
        if (val % 2 == 0) {
            sum += val;
        }
    })
    return sum;
};

console.log(sumEven(arrNum));

// 1-2 화살표 함수와 삼항 연산자 쓰기

const sumEven2 = ary => {
    let sum = 0;
    ary.forEach(val =>
        sum += val % 2 == 0 ? val : 0
    );
    return sum;
};

console.log(sumEven2(arrNum));

// 2-1 

const sumOdd = function (ary) {
    let sum = 0;
    ary.forEach(function (val, idx) {
        if (idx % 2 == 1) {
            sum += val;
        }
    });
    return sum;
};

console.log(sumOdd(arrNum));

// 2-2

const sumOdd2 = ary => {
    let sum = 0;
    ary.forEach((val, idx) =>
        sum += idx % 2 == 1 ? val : 0
    );
    return sum;
};

console.log(sumOdd2(arrNum));


console.log('----- 은지님 방식');
const sumEvenn = function (arryy) {
    let sum = 0;
    for (let i = 0; i < arryy.length; i++) {
        if (arryy[i] % 2 == 0) {
            sum += arryy[i];
        }
    }
    return sum;

    // 나는 매개변수를 val로 주고,
    // if(val % 2 == 0){
    //     sum += val;
    // }
    // return val;}
    // 일케 해가지고
    //arrNum.forEach((val, idx, ary) => console.log(sumEvenn(val)));
    // 출력하니까 루프 돌면서 짝수값을 그냥 그대로 출력해버림
}

arrNum.forEach((val, idx, ary) => console.log(sumEvenn(arrNum)));
console.log('----- me');

const sumEvennn = function(val){

}

