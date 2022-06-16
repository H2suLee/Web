// 변수에 복합적으로 복잡한 값 넣고 불러오기
let comObj = {
    sno: '22-123456',
    sname: 'Kim',
    score: 80,
    hobby: ['reading', 'eating'],
    pet: [{
        cname: '야옹이',
        age: 2
    }, {
        dname: '멍멍이',
        age: 3
    }]
}

comObj.sname; // Kim
comObj.hobby[0]; // reading
comObj.pet[0].age; // 2
comObj.pet[1].dname; // 멍멍이
console.log(comObj.pet[1]);
console.log(comObj.pet[1].dname);

