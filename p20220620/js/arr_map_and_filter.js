let names = ['이희수', '인은지', '박소현', '오지민', '조현진'];

// map: A를 매핑해서 B라는 새로운 배열로, 같은 배열 길이의 배열로 생성된다
let mapIdx = names.map((val, idx) => {
    if (idx % 2 == 0) {
        return idx;
    }
});
console.log(mapIdx); //[0, undefined, 2, undefined, 4]

mapIdx = names.map((val, idx) => idx % 2 == 0);
console.log(mapIdx); // [true, false, true, false, true]

let mapVal = names.map((val, idx) => {
    if (idx % 2 == 0) {
        return val;
    }
});
console.log(mapVal); //[이희수, undefined, 박소현, undefined, 조현진]

// filter: undefined이나 false인 것을 걸러준다
let filterIdx = names.filter((val, idx) => {
    if (idx % 2 == 0) {
        return idx;
    }
});
console.log(filterIdx); //[박소현, 조현진]

filterIdx = names.filter((val, idx) => idx % 2 == 0);
console.log(filterIdx); //[이희수, 박소현, 조현진]

let filterVal = names.filter((val, idx) => {
    if (idx % 2 == 0) {
        return val;
    }
});
console.log(filterVal); //[이희수, 박소현, 조현진]

// map과 filter 같이 쓰기
// 홀수번째 값 출력하기
let mnF = names.map((val, idx) => {
    if (idx % 2 == 1) {
        return val;
    }
}).filter((val, idx) => {
    return val
});

console.log(mnF); // 인은지, 오지민

// 교과서 실습
// p208~

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
console.log(objAry);

// p208
let males = objAry.filter(val => val.gender == 'Male');
console.log(males);
let over3000 = objAry.filter(val => val.salary >= 3000)
    .map(val => {
        let newObj = {};
        newObj.id = val.id;
        newObj.salary = val.salary;
        return newObj;
    });
console.log(over3000);
let over10 = objAry.filter(val => val.id >= 10 ? val : null); // null 은 생성되는 배열 요소에서 제외된다
console.log(over10);

// map - filter 순서 바꿔서
let over3500 = objAry.map(val => val.salary >= 3500 ? val : null).filter(val => val);
console.log(over3500);

// 여사원의 급여 평균
let cnt = 0;
let sum = 0;
objAry.filter(val => val.gender == 'Female').forEach(val => {
    sum += val.salary;
    cnt++;
});
let avg = sum / cnt;
console.log(`여사원의 급여 평균 ${avg}`);
console.clear();
// 배열복사
let salaries = [];
// map으로
salaries = objAry.map(val => val.salary);

// for each로도
// objAry.forEach(val => salaries.push(val.salary));
console.log(salaries);

// 최대값 구하기
function getMaxValue(ary) {
    let max = ary[0];
    for (let i = 1; i < ary.length; i++) {
        if (ary[i] > max) {
            max = ary[i];
        }
    }
    return max;
}
let maxVal = getMaxValue(salaries);
console.log(`가장 큰 값 : ${maxVal}`);

// 오름차순 정렬하기
function sortAscend(ary) {
    let temp;
    for (let i = 0; i < ary.length; i++) {
        for (let j = 0; j < ary.length; j++) {
            if (ary[i] < ary[j]) {
                temp = ary[i];
                ary[i] = ary[j];
                ary[j] = temp;
            }
        }
    }
    return ary;
}

sortAscend(salaries);
console.log(salaries);