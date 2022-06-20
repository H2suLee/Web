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

// thead 추가
// prompt 메소드 
let gender = prompt('Male or Female 을 입력');
console.log(gender);

let objAry = JSON.parse(data);

console.log(objAry);

let gender = prompt('Male or Female');

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
