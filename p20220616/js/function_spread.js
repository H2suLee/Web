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