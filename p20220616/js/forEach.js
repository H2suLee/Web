// for문
// 배열길이에 상관하지 않고 전체 요소에 접근할 경우 for of, of in


// for of, Array, String, Map, Set 에 사용할 수 있다. 
//(for let 요소변수이름 of 배열이름){
// 반복 실행문
// }

// for in, 전체 속성 키를 나열
// Array, String, Map, Set에 사용할 경우 객체 인덱스 값만 반환

// For each, 기본 순환 구문은 아니며 배열 전용의 메소드. 콜백 함수를 이용해 배열 요소에 다양한 처리 가능
// 배열.forEach(function(value, index, array)){
// 실행할 내용
// }

let friends = [{
        name: '라이언',
        age: 5
    },
    {
        name: '어피치',
        age: 4
    },
    {
        name: '콘',
        age: 2
    },
    {
        name: '무지',
        age: 3
    }
];

friends.forEach(function (friend, idx) {
    console.log('이름 : ' + friend.name + ' / 나이 : ' + friend.age);
});

// 화살표 함수 연습
console.log('----------- 화살표 함수로 -------------')
friends.forEach((friend, idx) => console.log('이름 : ' + friend.name + ' / 나이 : ' + friend.age));