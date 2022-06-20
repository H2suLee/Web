let str = 'Hello';
str = 'Hello';

let person = {
    name: "hong",
    age: 20,
    showInfo: function () {
        // return '이름은 ' + this.name + ', 나이는 ' + this.age + '입니다.';
        return `이름은 ${this.name}, 나이는 ${this.age} 입니다.`;
    }
}

console.log(person.showInfo());
console.log(`나의 이름은 ${person.name}`)
console.log(`${person.age > 20? '성인':'청소년'}`); // 문자 표현식 안에 연산 표현 가능

let strings = 'This\nis\na\nboy';
console.log(strings)
strings = `This
is
a
boy`;
console.log(strings)

console.log('This is an apple'.indexOf('apple'));
console.log('This is an apple'.charAt(11));

// 주민번호 일곱번째 자리로 성별 구분하기
let jm = '950101-1234567';
jm = '000423-3696854';

// 스트링 리터럴과 삼항 연산자로
console.log(`${jm.charAt(7) == 1 || jm.charAt(7) == 3? '남자':'여자'}`); // 문자 표현식 안에 연산 표현 가능

// 함수와 스위치문으로
function checkGender(num) {
    let gender = num.charAt(7);
    gender = num.substr(-7, 1); // 더 정확하게 하려면 뒤에서 숫자 세기
    switch (gender) {
        case '1':
        case '3':
            return '남자';
        case '2':
        case '4':
            return '여자';
        default:
    }
}
console.log(checkGender(jm));