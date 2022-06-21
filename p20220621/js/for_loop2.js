let data = `[{"id":1,"first_name":"Ario","last_name":"Izkovicz","email":"aizkovicz0@epa.gov","gender":"Male","salary":1118},
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

let ary = JSON.parse(data);
console.log(ary);

// id가 홀수이고, 성별이 여자인 요소의 id, name, gender만 출력하기
// forEach, void
ary.forEach((val, idx) => {
    if (val.id % 2 == 1 && val.gender == 'Female') {
        let newObj = {};
        newObj.id = val.id;
        newObj.name = val.first_name + ' 0' + val.last_name;
        newObj.gender = val.gender;
        console.log(newObj);
    }
});

// Filter, 필터 후 배열값 그대로를
let filteredAry = ary.filter(val => val.gender == 'Female');
console.log(filteredAry);

// map
// console.clear();
let result = ary.map(val => {
    return val.salary * 2 
    // ★ val.salary*2 만 담고있는 배열 생성됨..obj 형태로 출력하고 싶으면 let newObj = [] 이런 거 해야되나..?
}); // 
console.log(result);

// 연봉이 4천 이하인 사람들
let newCompany = ary.map(val => {
    let newObj = {};
    newObj.nId = val.id;
    newObj.name = val.first_name + ', ' + val.last_name;
    newObj.salary = val.salary * 1.5;
    newObj.isNew = newObj.salary > 4000 ? false : true;
    return newObj;
}).filter(val => val.isNew); //.forEach(val => console.log(val));
console.log(newCompany);

// 연봉이 4천 이하인 사람들의 합
result = newCompany.reduce((acc, curr, idx, ary) => {
    // console.log(`${acc}  ${curr.salary}  ${idx}`);
    acc += curr.salary;
    return acc;
}, 0);
console.log(result);