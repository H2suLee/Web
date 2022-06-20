let arr = [];
// js에서는 배열 안에 여러 타입의 값을 넣을 수 있지만 동일한 타입의 값을 배열에 넣는 것을 권장
arr[0] = 'Hello';
arr[1] = 100;
arr[2] = true;

console.log(arr);
console.log(arr.length); // 3

// 일반 반복문
for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}

// 확장 for
for (let val of arr) {
    console.log(val);
}

// for each
arr.forEach((val, idx) => console.log(`${idx} : ${val}`)); // 배열의 값이 undefined이면 반복에서 제외

// push. unshift
arr.push('Apple'); // 추가
arr.unshift('Banana'); // 맨 첫번째에 추가

arr.forEach((val, idx) => console.log(`${idx} : ${val}`)); // 배열의 값이 undefined이면 반복에서 제외

// pop, shift
arr.pop() // 삭제
arr.shift() // 맨 첫번째 걸 삭제

arr.forEach((val, idx) => console.log(`${idx} : ${val}`)); // 배열의 값이 undefined이면 반복에서 제외

console.log('-------------------- splice')
arr.splice(0, 0, 'Apple'); // 0을 Apple로 추가
arr.splice(0, 1, 'Apple'); // Hello 를 Apple로 대체
arr.splice(0, 2, 'Apple'); // Hello랑 100을 Apple로 대체
arr.splice(1, 1); // 대체할 값을 넣어주지 않으면 삭제, 100 삭제

arr.forEach((val, idx) => console.log(`${idx} : ${val}`)); // 배열의 값이 undefined이면 반복에서 제외

let names = [];
names.push('이희수');
names.push('인은지');
names.unshift('박소현'); // 박소현 이희수 인은지
names.splice(1, 0, '오지민'); // 박소현 오지민 이희수 인은지
names.splice(3, 0, '김가윤', '박경아'); // 박소현 오지민 이희수 김가윤 박경아 인은지
names.splice(1, 2, '김가윤', '박경아'); //박소현 김가윤 박경아 김가윤 박경아 인은지
names.splice(names.length, 0, '조현진'); // 맨 끝에 조현진 추가

console.log(names); // ['박소현', '김가윤', '박경아', '김가윤', '박경아', '인은지', '조현진']

let newNames = [];
names.forEach(function (val, idx) {
    // 배열 복사
    // newNames.push(val);

    // names의 홀수번째 있는 값만 newNames에 넣기
    if (idx % 2 == 0) {
        newNames.push(val);
    }
})

console.log(newNames); // ['박소현', '박경아', '박경아', '조현진']