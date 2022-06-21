// 펼침 연산자 p75 ...
let args = [1, 3, 5];

// 배열 합치기
let another = [4, 5, 6];
console.log(args.concat(another)); // args + another = // 1,3,5,4,5,6

// 펼침 연산자를 사용하면 배열이 쉽게 합쳐진다.
let otherArgs = [-1, -2, ...args];
console.log(otherArgs); // -1, -2, 1, 3, 5

otherArgs = [-1, ...args, -2];
console.log(otherArgs); // -1, 1, 3, 5 -2

let obj1 = {
    name: 'Hong',
    age: 20,
    weight: 60
}; // 오브젝트 선언과 동시에 값 초기화
let obj2 = {
    name: 'Choi',
    age: 25,
    height: 170
};
let obj3 = {
    ...obj1,
    ...obj2
};
let obj4 = {
    ...obj2,
    ...obj1
};
let obj5 = {
    sno: '1234'
};
let obj6 = {
    ...obj2,
    ...obj5,
    ...obj1
};
let obj7 = {
    obj2,
    obj5,
    obj1
}; // 펼침 연산자 없이
let obj8 = {
    ...obj3,
    ...obj4,
    ...obj6
};
console.log(obj1);
console.log(obj3); // choi, 25, 60, 170 // 있는 값들은 새로운 값으로 대치, 없던 값들은 추가
console.log(obj4); // Hong, 20, 170, 60 // 뒤에 위치한 값들이 최신값
console.log(obj6); // Hong, 20, 170, 1234, 60
console.log(obj7);
console.log(obj8); // hong, 20, 60, 170, 1234