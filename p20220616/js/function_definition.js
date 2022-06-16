// 함수 정의문
let args = [1, 2, 3, 5, 5, 6]; // 매개값
args = [1, 2, 33];

function sumAry(ary) {
    let result = 0;
    for (let i = 0; i < ary.length; i++) {
        result += ary[i];
    };
    return result;
}

// 함수를 정의는 했어도 선언은 한 적이 없는데 정의구문이 잘 출력됨
// 위 정의한 함수가 const sumAry = function(ary){}; 랑 같은 의미
console.log(sumAry);

let result = sumAry(args);
console.log(result); // 36

// 함수 표현식
const sum = function (num1, num2) {
    return num1 + num2;
}

console.log(sum); // 함수 정의구문이 출력됨
console.log(sum()); // NaN(Not a number) 출력됨
console.log(sum(10, 20)); // 30
console.log(sum(10)); // NaN
console.log(sum(10, 20, 30)); // 30, 오류도 안 내고 세번째 자리에 있는 수는 쓰지도 않음

const sum2 = function (num1, num2) {
    if (!num1) { // num1이 undefined일 때 = num1이 false, null, 0, '' 일 때..
        num1 = 0;
    }
    num2 = num2 == undefined ? 0 : num2; // 삼항연산자
    return num1 + num2;
}

console.log(sum2()); // 0
console.log(sum2(10, 20)); // 30
console.log(sum2(10)); // 10

// 함수 이런 식으로도 정의 가능
const sum3 = sum;
console.log(sum3(10, 50));
