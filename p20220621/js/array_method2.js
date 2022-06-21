// sort, join

// sort
// sort() 가나다순
// sort(콜백함수)로 정렬 기준을 정할 수 있다
// sort의 콜백함수의 매개값 (a, b)
// return -1 : a와 b의 위치를 바꾸지 않겠다
// return 1 : a와 b의 위치를 바꾸겠다
result = [6, 4, 3, 21, 14].sort();
console.log(result); // 14 21 3 4 6, 가나다 순
result = [6, 4, 3, 21, 14].sort((a, b) => {
    //오름차순 정렬해라
    // if (a < b) {
    //     return -1;
    // } 
    // else {
    //     return 1;
    // }

    // 내림차순 정렬해라
    if (a < b) {
        return 1;
    } else {
        return -1;
    }

    // 정렬 안하기 
    // if (a == b) {
    //     return 0;
    // }
});
console.log('>: ' + result); // 

result = [6, 4, 3, 21, 14].sort((a, b) => {
    return b - a; // 내림차순
    // return a - b; // 오름차순
});
console.log('>>: ' + result); // 

result = [6, 4, 3, 21, 14].sort((a, b) => {
    // return -1; // 유지
    return 1; // 바꾸겠다 가나다순으로 리턴됨
});
console.log('?>>: ' + result); // 

let objAry = [{
        name: '홍길동',
        age: 18
    },
    {
        name: '김민수',
        age: 20
    },
    {
        name: '박세민',
        age: 19
    }
];
console.log("홍" < "박"); // false, 오름차순 정렬시 박이 더 작은 값
result = objAry.sort((a, b) => a.name < b.name ? -1 : 1);
console.log(result); // 

// join
// 배열을 문자열로 변환해 준다
result = ['홍길동', '박민규', '김상우'].join('-');
console.log(result); // 홍길동-박민규-김상우

names = '권소정, 김하은, 유선희, 김가윤';
result = names.split(', ').sort((a, b) => a < b ? -1 : 1).join(', '); // 공백 처리 잘 안하면 정렬에 공백까지 비교함
console.log(result);
// sort에서 조건을 a-b 권소정, 김하은, 유선희, 김가윤
// sort에서 조건을 b-a 권소정, 김하은, 유선희, 김가윤
// sort에서 조건을 1 권소정, 김하은, 유선희, 김가윤
// sort에서 조건을 -1 김가윤, 유선희, 김하은, 권소정
// 뭐지.?\ㅋ