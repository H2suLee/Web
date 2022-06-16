// object.js
// 객체 생성하기
const student = {
    sno: '22-0123',
    sname: '홍길동',
    mathScore: 80,
    engScore: 90,
    age: 20,
    showInfo: function () {
        return '이름은 ' + this.sname + '이고, 나이는 ' + this.age;
    }
}

const student2 = {
    sno: '22-0124',
    sname: '김길동',
    mathScore: 80,
    engScore: 90,
    age: 22,
    showInfo: function () {
        return '이름은 ' + this.sname + '이고, 나이는 ' + this.age;
    }
}

// 클래스를 통해 객체 생성하기
// 객체 == 인스턴스(클래스의 구조를 실체화)
class Student {
    // 속성(필드)은 정의할 필요 없다. this.가 붙으면 그것이 속성
    // 생성자 constructor로 통일
    constructor(sno, sname, age) {
        this.sno = sno;
        this.sname = sname;
        this.age = age;
    }
    setMathScore(mathScore) {
        this.mathScore = mathScore;
    }
    setEngScore(engScore) {
        this.engScore = engScore;
    }
    showInfo() {
        return '이름은 ' + this.sname + '이고, 나이는 ' + this.age + '입니다.';
    }

}

const student3 = new Student('22-0111', '김익수', 23);
student3.setEngScore(90);
student3.setMathScore(70);

console.log(student2);
console.log(student3);
console.log(student3.showInfo());

// find 메소드 알고 가기

let names = ['Hong', 'Kim', 'Lee', 'Park'];
// 배열에서 조건을 만족하는 값을 반환해 주는 메소드 
let searchName = names.find(function (val) {
    // true이면 그것을 만족하는 첫번째 값을 반환
    return val == 'Kim'; // Kim 
    // return val.length == 4; // Hong
    // return val.length < 4; // Kim
});

console.log(searchName);

// p100 예제
class Estimate {
    // 생성자
    constructor(param) { // 배열을 받을 예정
        this.unit = param;
    }

    // 메소드
    // 견적가 얻기 메소드
    // getEstimate(unittype, width, height){
    //     let priceinfo = this.unit.find(item => item.type == unittype); // 만약 unittype이 wood면 {type: 'wood', price: 100}임
    //     return priceinfo.price * width * height;
    // }

    // 화살표함수 안쓴걸로
    getEstimate2(unittype, width, height) {
        let priceinfo = this.unit.find(function (val, idx, ary) {
            return val.type == unittype; // 이를 만족하는 첫번째 값(오브젝트) {}을 반환 
        });
        return priceinfo.price * width * height;
    }
    // 배열에 요소 추가 메소드
    addUnit(unit) {
        this.unit.push(unit); // 스택
    }
}
let unitinfo = [{
    type: "wood",
    price: 100
}, {
    type: "iron",
    price: 300
}, {
    type: "plastic",
    price: 200
}];

const estimator = new Estimate(unitinfo);
let result = estimator.getEstimate2('wood', 20, 20);
console.log(result);

let push = {
    type: "glass",
    price: 500
};
estimator.addUnit(push);
result = estimator.getEstimate2('glass', 20, 20);
console.log(result);

// 이 똑같은 걸 오브젝트 타입으로

let obj = {
    // unit: unitinfo, 바로 아래 라인을 이런 식으로 추가할 수도 있다
};
obj.unit = unitinfo; // obj 안에 unitInfo 추가
obj.getEstimate = function(unittype, height, weight){ // obj 안에 getEstimate 추가
    let priceInfo = this.unit.find(item => item.type == unittype);
    return priceInfo.price * height * weight;
}
obj.addUnit=function(unit){
    this.unit.push(unit);
}

let result2 = obj.getEstimate('wood', 20, 20);
console.log(result2);