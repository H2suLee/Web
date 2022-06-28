/**
 * 
 */
// 'DOMContentLoaded' html을 먼저 다 읽고 js document 실행하는 이벤트
document.addEventListener('DOMContentLoaded', function() {
	let tbl = document.querySelector('#show table');
	let capt = document.createElement('caption');
	capt.innerHTML = '회원리스트';
	tbl.append(capt);

	// 리스트 출력
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', 'MemberServlet?cmd=select'); // ★★★★ cmd 파라미터 안 주고 그냥 'MemberServlet'으로 하니까 500오류
	xhtp.send();
	xhtp.onload = function() {

		let parsed = JSON.parse(this.responseText);
		let tbody = document.querySelector('#show tbody')
		parsed.forEach(member => {
			tbody.append(makeTr(member));
		});
	}
	document.forms.memberForm.addEventListener('submit', function(e) {
		e.preventDefault();
		let formData = new FormData(e.target); // e.target = memberForm
		// .entries(): form의 key와 value 데이터를 스트링으로
		for (let ent of formData.entries()) {
			console.log(ent);
		}
		// fetch 요청, p246
		fetch('memberUpload', {
			method: 'post',
			body: formData
		})
			.then(function(result) {
				// 이 then()을 빠져먹으면 json object가 콘솔에 그래도 출력됨
				return result.json();
			})
			.then(function(result) {
				console.log(result);
			})
			.catch(function(err) {
				console.error(err);
			})
	})
});


let fields = ['membNo', 'membName', 'membPhone', 'membAddr', 'membBirth', 'membImage'];

function makeTr(member) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', member.membNo); // ★★★★
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = member[field] ? (field == 'membImage' ? '<img width="60px" src="images/' + member[field] + '">' : member[field]) : '';
		tr.append(td);
	});

	// 삭제 컬럼 - 삭제 버튼
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	let td = document.createElement('td');
	td.append(btn);
	tr.append(td);

	// 삭제 버튼에 이벤트 넣기
	btn.addEventListener('click', delBtnFnc, false); // bubble, capture

	// 선택 컬럼 - 체크박스
	let input = document.createElement('input');
	input.setAttribute('type', 'checkbox');
	td = document.createElement('td');
	td.append(input);
	tr.append(td);
	return tr;
}

// 삭제 버튼 이벤트 구현
function delBtnFnc() {
	let delNo = this.parentElement.parentElement.getAttribute('id');
	document.querySelector('form[name="memberForm"]');
	let formData = new FormData();
	// 밑에 두 줄은 isMulti = true일 때 효용
	/*    formData.append("cmd", "remove");
		formData.append("no", delNo);*/

	fetch('memberUpload', {
		method: 'post',
		headers: {
			'Content-type': 'application/x-www-form-urlencoded'
		}, // isMulti = false
		body: `cmd=remove&no=${delNo}`
	})
		.then(function(result) {
			return result.json();
		})
		.then(function(result) {
			console.log(result);
		})
		.catch(function(err) {
			console.error(err);
		})
}
/*document.forms.memberForm.addEventListener('submit', function(e) {
	e.preventDefault();
	console.log(this);
	let No = this.no.value;
	let Nm = this.name.value;
	let Ar = this.address.value;
	let Ph = this.phone.value;
	let Br = this.birth.value;

	xhtp = new XMLHttpRequest();
	xhtp.open('post', 'MemberServlet'); // 요청방식이 포스트: 매개값이 몸체에 담겨 넘어감
	xhtp.setRequestHeader('Content-type',
		'application/x-www-form-urlencoded'); // 넘어가는 데이터의 타입을 지정해 줘야 
	// application/x-www-form-urlencoded여야 request.getParameter()로 데이터 읽을 수 잇다
	// multipart/form-data 서블릿 메소드 안에 MultipartRequest 객체 생성 따로 해줘야 됨
	xhtp.send(`name=${Nm}&addr=${Ar}&phone=${Ph}&birth=${Br}&cmd=add`);
	xhtp.onload = function() {
		let parseData = JSON.parse(this.responseText);
		document.querySelector('#show tbody').append(makeTr(parseData));
	}

})*/