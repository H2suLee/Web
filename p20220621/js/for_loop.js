// for_loop.js

// 배열 관련 반복되는 메소드
// ForEach -> void
// Map -> A'격의 [], A와 A'의 요소 수는 똑같다, 값/null, 값/undefined, 조건식을 리턴하면 true/false로 뜸
// Reduce -> 문자열, Number, [], {}. 요소(값)를 반환하고 null이나 undefined을 걸러준다,

let ary = [3, 5, 8, 9, 12];
ary.push(5);
ary.unshift(7);
console.log(ary); // 7 3 5 8 9 12 5
// 8 빼기
ary.splice(3, 1);
console.log(ary); // 7 3 5 8 9 12 5

// forEach
ary.forEach(val => console.log(val));

// forEach에 익명함수만 써야되는 것은 아니다
function firstCallBack(val) {
    console.log(val);
}
let result = ary.forEach(firstCallBack);

// undefined, forEach 함수는 리턴해 주는 값이 없다
console.log(result);

let newAry = [];

function secondCallBack(val) {
    newAry.push(val);
}
ary.forEach(secondCallBack); // 왜 괄호를 안 쓰는 걸까
console.log(newAry); // 7 3 5 9 12 5

// map
result = ary.map(val => val * 2);
console.log(result); // 14 6 10 18 24 10

// filter
result = ary.map((val, idx, ary) => {
    if (idx % 2 == 0) {
        return val
    }
    return null
}).filter(val => val); //7, null, 5, null, 12 => 7,5,12
result = ary.filter((val, idx) => idx > 3); // 12, 5
console.log(result);
console.clear();
// reduce
result = ary.reduce((acc, curr, idx, ary) => {
    console.log(curr);
    // console.log(`acc = ${acc} / curr = ${curr} / idx = ${idx}`);
    // 리턴하는 값이 다음 순번의 초기값이다
    // return curr; 
    // return acc+curr; // 누적합
    if (idx == 0) {
        acc += '<table border=1><tr>';
    }
    acc += `<td>${curr}</td>`;
    if (idx == ary.length - 1) {
        acc += '</tr></table>'
    }
    return acc;
}, '')
console.log(result);
document.write(result);

result = ary.reduce((acc, curr) => {
    console.log(acc, curr);
    acc.push(curr);
    return acc;
}, [])
console.log(result);

// [] 7
// [7] 3
// [7, 3] 5
// [7, 3, 5] 9
// [7, 3, 5, 9] 12
// [7, 3, 5, 9, 12] 5
// [7, 3, 5, 9, 12, 5] (=result)

// reduce로 map+filter 기능 구현하기
// 인덱스가 3이상인 값들 *2하여 새로운 배열을 생성
result = ary.reduce((acc, curr, idx, ary) => {
    if (idx > 3) {
        acc.push(curr * 2);
    }
    return acc;
}, []);
console.log(result); // 12, 5 => [24, 10]

result = ary.filter((val, idx, ary) => {
    if (idx > 3) {
        return val * 2;
    }
});
console.log(result); // 12, 5, 필터는 값을 그대로 출력해 주는 듯.. 값을 변경하고 싶으면 맵도 같이 써서 새로운 배열을 도출해내야

result = ary.filter((val, idx) => idx > 3).map(val => {
    return val * 2
});
console.log(result); // [24, 10]