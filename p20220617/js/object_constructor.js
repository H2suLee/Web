// 객체 생성

// 함수를 통해 객체를 생성..? 그러면 함수 이름 첫 글자를 대문자로 쓴다..
function Student(sno, sname, age) {
    // 함수 안에서 this = window
    this.sno = sno;
    this.sname = sname;
    this.age = age;

    this.showInfo = function () {
        return '이름은 ' + this.sname + ', 나이는 ' + this.age + '입니다.';
    }
}

// new 연산자를 붙여줘야 객체가 생성
let s1 = new Student('22-1111', '홍길동', 19);

// 안 붙이면 그냥 함수 호출하는 것.. 그렇지만 함수로 치면 리턴 값이 없기 때문에 undefined 반환
let f1 = Student('22-1111', '홍길동', 19);

console.log(s1); // 객체를 리턴
console.log(window);
console.log(f1); // undefined

let s2 = s1;
s2.sno = '22-2222';
console.log(s1); // sno가 22-2222로 반환됨.

console.log(s1.showInfo());


function Table(data) {
    this.data = data;
    this.tag = '';
    this.createTable = function () {
        this.tag = '<table border=1>';
        this.tag += this.createHead(); // this.createHead라고 하면 정의문이 출력됨
        this.tag += this.createbody();
        // // 이런 식으로 호출할 거라면 각 함수 내에 첫 this.tag부터 += 걸어주고 리턴값 없애면 됨
        // this.createHead();
        // this.createbody();
        this.tag += '</table>';
        return this.tag;
    }

    this.createHead = function () {
        // 
        this.tag = '<thead><tr>';
        for (let field in this.data[0]) { //field : sname, age, height, weight; // for of는 안 됨
            this.tag += '<th>' + field + '</th>';
        }
        this.tag += '</tr></thead>';
        return this.tag;
    }


    this.createbody = function () {
        this.tag = '<tbody>'; // 안 해주니까 head 두번 뜸
        // val이 key field가 value
        // forOf로
        // for (let val of this.data) {
        //     this.tag += '<tr>';
        //     for (let field in val) { // val[field] : Hong, 15, 180, 72 ...
        //         this.tag += '<td>' + val[field] + '</td>';
        //     }
        //     this.tag += '</tr>';
        // }

        // forEach로
        // 화살표 안 쓰면 this.tag 가 undefined 이 되어요..
        // this.data.forEach((val, idx) => {
        //     this.tag += '<tr>';
        //     for (let field in val) { // val[field] : Hong, 15, 180, 72 ...
        //         this.tag += '<td>' + val[field] + '</td>'; // 여기 this.tag는 window
        //     }
        //     this.tag += '</tr>';
        // });
        // this.tag += '</tbody>';

        // 화살표 안 쓰고 바깥 for문을 function()으로 처리하고 싶으면
        // this.tag를 새로운 변수에 담아주어야 한다        
        let str = this.tag;
        this.data.forEach(function(val, idx){
            str += '<tr>';
            for (let field in val) { // val[field] : Hong, 15, 180, 72 ...
                str += '<td>' + val[field] + '</td>'; // 여기 this.tag는 window
            }
            str += '</tr>';
        });
        str += '</tbody>';


        return str;
    }

}
console.clear;
// raw data
let data = [{
        sname: 'Hong',
        age: 15,
        height: 180,
        weight: 72
    },
    {
        sname: 'Kim',
        age: 20,
        height: 185,
        weight: 79
    },
    {
        sname: '이찬희',
        age: 20,
        height: 175.3,
        weight: 72.3
    },
    {
        sname: '김민수',
        age: 24,
        height: 182.3,
        weight: 79.3
    }
]

let t1 = new Table(data);
let str = t1.createTable()
console.log(str);
document.write(str);