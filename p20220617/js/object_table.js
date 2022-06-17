// table.js

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
    }
]

class Table {

    // 생성자
    constructor(ary) {
        this.aryData = ary;
    }
    // 메소드
    createTable() {
        // this.tag = '';
        // 헤더 정보 <thead> </thead>
        this.tag += '<table border = 1><tr>';
        for (let field in this.aryData[0]) { //sname, age,
            this.tag += '<th>' + field + '</th>';
        }
        this.tag += '</tr>';

        // 바디 정보 <tbody> </tbody>
        this.aryData.forEach((val, idx) => {
            // console.log(val);
            this.tag += '<tr>';
            for (let field in val) {
                this.tag += '<td>' + val[field] + '</td>';
            }
            this.tag += '</tr>';
        });
        this.tag += '</table>'

        return this.tag;
    }
}

let table = new Table(data);
let str = table.createTable(); // 표 형식으로 호출될 수 있도록
console.log(str);
document.write(str);