let data = `
[{"id":1,"first_name":"Ario","last_name":"Izkovicz","email":"aizkovicz0@epa.gov","gender":"Male","salary":1118},
{"id":2,"first_name":"Shurwood","last_name":"Crombleholme","email":"scrombleholme1@globo.com","gender":"Male","salary":1371},
{"id":3,"first_name":"Edik","last_name":"Zelley","email":"ezelley2@smugmug.com","gender":"Male","salary":3486},
{"id":4,"first_name":"Derick","last_name":"Slaughter","email":"dslaughter3@nationalgeographic.com","gender":"Male","salary":1020},
{"id":5,"first_name":"Lock","last_name":"Swadling","email":"lswadling4@hatena.ne.jp","gender":"Male","salary":2834},
{"id":6,"first_name":"Cammy","last_name":"Elcoux","email":"celcoux5@utexas.edu","gender":"Female","salary":1805},
{"id":7,"first_name":"Michail","last_name":"Cough","email":"mcough6@cnn.com","gender":"Male","salary":1468},
{"id":8,"first_name":"Agneta","last_name":"Bernhard","email":"abernhard7@edublogs.org","gender":"Female","salary":1386},
{"id":9,"first_name":"Kylie","last_name":"Gatus","email":"kgatus8@imdb.com","gender":"Female","salary":3675},
{"id":10,"first_name":"Cally","last_name":"Illes","email":"cilles9@smugmug.com","gender":"Female","salary":2350},
{"id":11,"first_name":"Raffarty","last_name":"Rimour","email":"rrimoura@godaddy.com","gender":"Male","salary":4131},
{"id":12,"first_name":"Sonnie","last_name":"Thornhill","email":"sthornhillb@cbslocal.com","gender":"Female","salary":1691},
{"id":13,"first_name":"Barbabas","last_name":"Whyatt","email":"bwhyattc@reuters.com","gender":"Male","salary":3131},
{"id":14,"first_name":"Mac","last_name":"Tidbold","email":"mtidboldd@fc2.com","gender":"Male","salary":2041},
{"id":15,"first_name":"Carla","last_name":"Crop","email":"ccrope@imgur.com","gender":"Female","salary":4480}]`;

// JSON.parse(): 문자열 -> 오브젝트
let objAry = JSON.parse(data);


// reduce메소드 .reduce(함수, 초기값) 집계 처리를 가능하게 해 준다
// 때에 따라 filter, map 기능을 reduce로 구현 가능
// 1: 초기값
// 2: 현재 인덱스의 값
// 3: 현재 인덱스
// 4: 배열 그자체
let result = [1, 2, 3, 4].reduce(function (accum, curr, curIdx, ary) {
    console.log(`누적 요소(accum+curr): ${accum}`);
    console.log(`현재 인덱스의 값: ${curr}`);
    console.log(`현재 인덱스: ${curIdx}`);
    console.log('---------------------------');
    return curr + accum; // 그다음 순번의 초기값이 됨
}, 0);

console.log(`최종 결과(마지막 턴의 curr+acumm): ${result}`); // 4

// 초기값을 텅 빈 배열로 줬을 때
result = [1, 2, 3, 4].reduce(function (accum, curr) {
    console.log(`accum : ${accum}, curr: ${curr}`);
    accum.push(curr);
    return accum;
}, [10]);
// 첫번째 턴: accum = []; curr: 1 -> push
// 두번째 턴: accum = [1]; curr: 2 -> push
// 세번째 턴: accum = [1,2]; curr: 3 -> push
// 네번째 턴: accum = [1,2,3]; curr: 4 -> push
// result: [1,2,3,4];

console.log(result);

result = result.map(val => val); // [1,2,3,4]
result = result.filter(val => {
    if (val % 2 == 0) {
        return val;
    }
    // return val % 2 == 0;
});
console.log(result); // [10, 2,4]

console.clear();

// 초기값이 ''
result = ['Apple', 'Banana', 'Cherry'].reduce((accum, curr, idx, ary) => {
    // 아래와 같이 조건문을 짜는 대신 초기값을 <ul>로 줘도 되는 듯
    // if (idx == 0) {
    //     accum = '<ul>'
    // }
    accum += `<li>${curr}</li>`;
    // console.log(accum);
    if (idx == ary.length - 1) {
        accum += '</ul>';
    }
    return accum; // 리턴 값을 안주면 두번째 순번부터 undefined
}, '<ul>');
console.log(result);
document.write(result);

result = ['Apple', 'Banana', 'Cherry'].reduce((accum, curr, idx, ary) => {
    if (idx == 0) {
        accum += '<table border=1><thead><tr><th>과일</th></tr></thead>';
    }
    accum += '<tr>'
    accum += `<td>${curr}</td>`
    accum += '</tr>'
    if (idx == ary.length - 1) {
        accum += '</table>';
    }
    return accum;
}, '');
console.log(result);
document.write(result);



result = ['Apple', 'Banana', 'Cherry'].reduce((accum, curr, idx, ary) => {
    console.log(curr);
    return accum + curr;
}, '');

console.log(result); // AppleBananaCherry

// max 값 구하기
result = [3, 2, 4, 1, 5].reduce((accum, curr) => {
    // console.log(`accum : ${accum} || curr: ${curr}`)
    // 내가 한 거
    // if (accum < curr) {
    //     console.log(accum, curr)
    //     accum = curr;
    // }
    // return accum;

    // 샘 거
    if (accum < curr) {
        return curr;
    }
    return accum;
}, 0);

console.log(`최대값: ${result}`);

// 합 구하기
result = [3, 2, 4, 1, 5].reduce((accum, curr) => {
    // console.log(`accum : ${accum} || curr: ${curr}`)
    return accum + curr;
}, 0);

console.log('총합: ' + result); // 15

// 평균 구하기
result = [3, 2, 4, 1, 5].reduce((accum, curr, idx, ary) => {
    // console.log(`accum : ${accum} || curr: ${curr} || idx: ${idx} || ary.length: ${ary.length}`)
    if (ary.length - 1 == idx) {
        accum += curr
        return accum / ary.length;
    }
    return accum + curr;
}, 0);

console.log('평균: ' + result); // 3

// reduce를 사용해서, 프롬프트에 성별(Male or Female)을 입력하면
// 그에 맞는 배열요소만 표로 출력해 주는 프로그램
// console.clear();
console.log(objAry);

let gender = prompt('Male or Female');
<<<<<<< HEAD
=======

result = objAry.reduce((acc, curr, idx, ary) => {
    // console.log(`accum : ${acc} || curr: ${curr.id} || idx: ${idx} || ary.length: ${ary.length}`)

    if (idx == 0) {
        acc += '<table border=1><thead><tr>'; //<thead><tr><th>과일</th></tr></thead>

        for (let field in curr) { // field는 key
            acc += `<th>${field}</th>`
        }
        acc += '</tr></thead>';
    }
    acc += '<tr>'

    for (let field in curr) {
        if (curr.gender == gender) {
            acc += `<td>${curr[field]}</td>`; // curr.field or curr[field]는 value
        }
    }
    acc += '</tr>'
    if (idx == ary.length - 1) {
        acc += '</table>';
    }
    return acc;

}, '');

document.write('<br><br>');
console.log(result);
document.write(result);
document.write('<br><br>');

>>>>>>> ec7b9eac03679c6683694f20c8d2b1df73096ca9
let resultTable = objAry.reduce((acc, curr, idx, ary) => {
    // console.log(`accum : ${acc} || curr: ${curr} || idx: ${idx} || ary.length: ${ary.length}`)
    acc += '<tr>';
    if (curr.gender == gender) {
        for (let field in curr) {
            acc += `<td>${curr[field]}</td>` // ${curr}로 해주면 [object Object]
        }
    }
    acc += '</tr>';
    if (idx == ary.length - 1) {
        acc += '</table>'
    }
    return acc;
}, '<table border=1>');

console.log(resultTable);
document.write(resultTable);
