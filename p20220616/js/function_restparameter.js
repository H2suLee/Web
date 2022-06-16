// 나머지 파라미터
// 파라미터 개수를 가변적으로 사용할 수 있도록 해준다. 개수를 정의할 필요가 없다
// 나머지 파라미터의 타입은 배열이다
// 그렇지만 나머지 파라미터는 웬만하면 쓰지 않는 것을 권장.. 

// 최소 2개의 파라미터는 필수이고, 추가 파라미터는 선택적인 파라미터라면..
function myFunc(a, b, ...args) {

}
// (예시)

function sum(a, b, ...args) {
    let result = a + b;
    args.forEach(function (arg) {
        result += arg;
    })
    return result;
}


function sumParam(...args) { // 단독 변수명 앞에 붙여서 점 세 개를 표시하면 해당 파라미터는 나머지 파라미터가 딘다
    let result = 0;
    args.forEach((val, idx) =>
        result += val 
    );
    return result;
};
console.log(sumParam(1, 2, 3, 6, 4, 5, 7, 9, 8)); // 45

// 예제 p78~

// - 정의
function restparams(...args) {
    console.log(args);
}
restparams(1, 2, 3, 4); // [1,2,3,4]

// - 사용예
const rest2 = (arg1, arg2, ...args) => {
    console.log([arg1, arg2, args]);
};
rest2(1, 2, 3, 4); // [1,2, Array(2)]
rest2(1, 2); // [1,2, Array(0)]
rest2(1); // [1, undefined, Array(0)]

// - 나머지 파라미터로 합계 구하기
function sumArg(a, b, ...args) {
    let result = 0;
    if (a != undefined) {
        result = a;
    } else {
        return 0;
    }
    if (b != undefined) {
        result += b;
    }
    args.forEach(function (arg) {
        result += arg;
    })
    return result;
}
console.log(sumArg(1, 2, 3, 4)); // 10
console.log(sumArg(1, 2)); // 3
console.log(sumArg(1)); // 1

// - 나머지 파라미터로 합계 구하기 개선
// reduce 메소드와 화살표 함수 사용하여 아주 고오급스럽고 간결한 코드를
// reduce는 배열 요소들의 누적 계산 결과 값을 얻는 메소드
const sumArgg = (a, b, ...args) => {
    let result = 0;
    if (a != undefined) {
        result = a;
    } else {
        return 0;
    }
    if (b != undefined) {
        result += b;
    }
    result += args.length > 0 ? args.reduce((subsum, arg) => subsum += arg) : 0;
    return result;
}

// 삼항연산자랑 화살표 함수로 더 개선..
const sumArggg = (a, b, ...args) => {
    let result = 0;
    result = !a ? 0 : a;
    result += !b ? 0 : b;
    args.forEach(arg => {
        result += arg;
    })
    return result;
}

console.log(sumArgg(1, 2, 3, 4)); // 10
console.log(sumArgg(1, 2)); // 3
console.log(sumArgg(1)); // 1

console.log(sumArggg(1, 2, 3, 4, 5));
console.log(sumArggg(1, 2));
console.log(sumArggg(1));

console.log('---------------------------')