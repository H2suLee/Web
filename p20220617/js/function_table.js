// 테이블 생성 함수
function createTable(ary) {
    let fields = ['name', 'age', 'height', 'weight'];
    let tag = '<table border=1>';

    // 헤더
    let header = createHeader(fields);
    tag += header;

    // 바디
    let body = createBody(ary);
    tag += body;
    tag += '</table>';
    return tag;
}

// 테이블 헤더 생성 함수
function createHeader(fields) {
    let tag = '<thead><tr>'
    // for(let field in fields){
    //     tag += '<td>' + field + '</td>';
    //     console.log(field);
    // }
    fields.forEach(val => {
        tag += '<td>' + val + '</td>';
        // console.log(tag);
    });

    tag += '</tr></thead>';
    return tag; // ★★★★★ return문이 없으면 undefiend 나온다@@
}

// 테이블 바디 생성 함수
function createBody(ary) {
    let tag = '<tbody>';
    // 바깥 for문에 forEach 대신 for of 써도 됨
    ary.forEach(val => {
        tag += '<tr>'; //★★★★★
        // for in 일반 객체의 모든 속성을 돈다 
        // for of 속성이 있는 객체에만 사용할 수 있기 때문에 일반객체에는 사용할 수 없다
        // 아래 중첩 for in 을 for of라고 쓰면 val is not iterable 오류남
        for (let field in val) { // 
            tag += '<td>' + val[field] + '</td>'
        } // val.field라고 하면 undefined party
        tag += '</tr>';
    });
    tag += '</tbody>';
    return tag; // ★★★★★
}

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

let str = createTable(data);
console.log(str);
document.write(str);