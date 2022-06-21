// indexOf, split, find, findIndex, some, every
// indexOf(val):  val의 인덱스 값 반환
// indexOf() != -1 -> 값이 있는지 여부 확인
let str = 'roadmap.sh is a community effort to create roadmaps, guides and other educational content to help guide the developers.';
console.log(str.indexOf('z') == -1); // true, 위 문장 내에 'z'가 없단 뜻

// split: 리턴값이 []
let strAry = str.split(' '); //구분자가 공백
console.log(strAry);
let idx = strAry.indexOf('a');
console.log(idx); // 2, 'roadmap.sh'의 a가 아니라 2번째 자리에 있는 'a'
let names = ['박은지', '윤정은', '박지혜', '김나희'];
idx = names.indexOf('김나희s');
console.log(idx); // -1

// t가 몇 개 있는지
// forEach로
strAry = 'Littering'.split('');
console.log(strAry);
let cnt = 0;
strAry.forEach((val) => {
    cnt += val == 't' ? 1 : 0
});
console.log('forEach-ed cnt: ' + cnt);

// reduce로
cnt = strAry.reduce((acc, curr) => {
    acc += curr == 't' ? 1 : 0;
    return acc;
}, 0);
console.log('reduced cnt: ' + cnt);

// 쪼개진 값을 또 쪼개기
strAry = names[0].split('');
console.log(strAry);

// find: 배열 내 해당되는 값의 첫번째 요소를 반환
result = names.find(function (elem, idx, ary) {
    console.log(elem, idx, ary);
    return elem == '김나희'
});
console.log(typeof result + ':' + result); // 김나희

// find와 filter의 차이점, 
// 리턴하는 값의 타입이 다르다. 
// find는 한 개의 값만 리턴하고 filter는 만족하는 모든 값을 리턴한다
result = names.filter(function (elem, idx, ary) {
    // console.log(elem, idx, ary);
    return elem == '김나희'
});
console.log(typeof result + ':' + result); // 김나희

// 만족하는 값이 없으면 undefined
result = [6, 4, 3, 21, 14].find(elem => {
    return elem > 100;
});
console.log(typeof result + ':' + result); // 김나희

// findindex
result = [6, 4, 3, 21, 14].findIndex(elem => {
    return elem > 10;
});
console.log(typeof result + ':' + result); // 3, 만족하는 첫번째 값의 인덱스

// 만족하는 값이 없으면 -1
result = [6, 4, 3, 21, 14].findIndex(elem => {
    return elem > 100;
});
console.log(typeof result + ':' + result); // 김나희

// some: 조건을 만족하는 요소 하나 true/false 하나라도 만족하면  true
result = [6, 4, 3, 21, 14].some((elem, idx, ary) => {
    console.log(`${elem} || ${idx} || ${ary}`);
    // 만족하는 값을 찾으면 바로 boolean 값 리턴, 14까진 가지도 않음
    return elem > 20;
});
console.log(typeof result + ':' + result); // boolean: true

// every: 조건을 만족하는 요소 true/false 무조건 다 만족해야 true
result = [6, 4, 3, 21, 14].every((elem, idx, ary) => {
    console.log(`${elem} || ${idx} || ${ary}`);
    // 첫번째 값부터 조건 만족 안 해서 이후의 것들을 훑지도 않음
    return elem > 20;
});
console.log(typeof result + ':' + result); // boolean: false

result = [6, 4, 3, 21, 14].every((elem, idx, ary) => {
    console.log(`${elem} || ${idx} || ${ary}`);
    return elem > 0;
});
console.log(typeof result + ':' + result); // boolean: true

console.clear();
let tempAry = [];
for (let i = 0; i < 5; i++) {
    let temp = parseInt(Math.random() * 10) + 1;
    tempAry.push(temp);
}
console.log(tempAry);
// 1. tempAry에 담긴 값이 모두 짝수인 지
result = tempAry.every((elem) => {
    return elem % 2 == 0;
});
console.log('1. 모두 짝수?: ' + result);

// 2. tempAry에 담긴 값 중에서 3의 배수가 존재하는 지
result = tempAry.some((elem) => {
    return elem % 3 == 0;
});
console.log('2. 3의 배수?: ' + result);

// 3. 5보다 큰 값이 있으면 그 값을 반환
result = tempAry.find(elem => elem > 5);
console.log('3. 5보다 큰 값: ' + result);

//
result = tempAry.filter(elem => elem > 5);
console.log('3. 5보다 큰 값(filtered ' + typeof result + '): ' + result);