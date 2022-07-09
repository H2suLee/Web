/**
 * 
 */
// HTML 스크립트 특성상 순차적으로 코드를 읽기 때문에 script 태그를 먼저 읽고 body 태그를 읽어버리면 nullpointer 에러가 날 수도 있음
// document.addEventListener('DOMContentLoaded', function(){})을 통해 HTML을 다 읽고 나서 자바 스크립트 코드를 읽을 수 있도록 함
document.addEventListener('DOMContentLoaded', function() {

	// caption
	let capt = document.createElement('caption');
	capt.innerHTML = "회원 리스트";
	document.querySelector('#show table').append(capt);

	let xhtp = new XMLHttpRequest();
	xhtp.open('get', 'MemberServlet?cmd=select'); // ★★★★
	// xhtp.open('get', 'MemberServlet'); // 일케하면 리스트는 뜨는데 콘솔에 404, 500 오류남 
	xhtp.send();
	xhtp.onload = function() {
		let parsed = JSON.parse(this.responseText);
		parsed.forEach(member => {
			document.querySelector('#show tbody').append(makeTr(member));
		});
	}

	// 이벤트를 밖에 빼면 read undefined 오류남, DONContentLoaded 안에 넣어줘야
	document.forms.memberForm.addEventListener('submit', function(e) {
		e.preventDefault();

		// isMulti => true

		//FormData 객체 생성
		let formData = new FormData(e.target); // e.target = memberForm
		console.log('formData', formData);

		// .entries() = form의 key와 value 데이터를 String 타입으로
		for (let ent of formData.entries()) {
			console.log('entries()', ent);
		}

		fetch('fileUpload', {
			method: 'post',
			body: formData
		})
			.then(function(result) {
				return result.json();
			})
			.then(result => console.log(result))
			.catch(err => console.error(err));
	})

});

let fields = ['membNo', 'membName', 'membPhone', 'membAddr', 'membBirth', 'membImage'];

function makeTr(member) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', member.membNo);
	fields.forEach(field => {
		let td = document.createElement('td');
		// td.innerHTML = member[field];
		// <img src="images/member[field]">
		td.innerHTML = member[field] ? (field == 'membImage' ? '<img width="60px" src="images/' + member[field] + '">' : member[field]) : '';
		tr.append(td);
	});

	// 버튼 만들기
	let btn = document.createElement('button')
	btn.innerHTML = '삭제';
	let td = document.createElement('td');
	td.append(btn);
	tr.append(td);

	// 삭제 버튼에 이벤트 넣기
	btn.addEventListener('click', delBtnFnc, false); // bubble, capture

	// 체크박스 만들기
	let input = document.createElement('input')
	input.setAttribute('type', 'checkbox');
	td = document.createElement('td');
	td.append(input);
	tr.append(td);

	return tr;
}

function delBtnFnc() {
	// isMulti = false

	let delNo = this.parentElement.parentElement.getAttribute('id') // tr
	console.log(delNo);

	// 밑에 세 줄은 isMulti = true일 때 효용
	/*	
		let formData = new FormData();
		formData.append("cmd", "remove");
		formData.append("no", delNo);
	*/
	// 이러고 body만 formData로 넘기면 됨~

	fetch('fileUpload', {
		method: 'post',
		headers: {
			'Content-type': 'application/x-www-form-urlencoded'
		},
		body: `cmd=remove&no=${delNo}`
	})
		.then(result => result.json())
		.then(result => console.log(result))
		.catch(err => console.error(err));

	this.parentElement.parentElement.remove();

}
