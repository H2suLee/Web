document.addEventListener('DOMContentLoaded', function() {

	// listBook
	fetch('BookServlet')
		.then(result => result.json())
		.then(result => {
			let tbody = document.querySelector('#show tbody');
			result.forEach(data => {
				// console.log(data); // {}				
				tbody.append(makeTr(data));
			});
		})
		.catch(error => console.error(err));

	// insertBook
	document.forms.bookForm.addEventListener('submit', insertTr);


	// deleteBook
	// console.log('call', document.querySelector('input#chkDel'));
	document.querySelector('input#chkDel').addEventListener('click', chkDelFnc);

});


function makeTr(book) { // {}
	// console.log('book?', book);
	let tr = document.createElement('tr');
	tr.setAttribute('id', book.no); // ★★★★

	// 선택 컬럼 - 체크박스
	let input = document.createElement('input');
	input.setAttribute('type', 'checkbox');
	let td = document.createElement('td');
	td.append(input);
	tr.append(td);

	// td에 데이터 입력
	for (let field in book) {
		let td = document.createElement('td');
		td.innerHTML = book[field];
		tr.append(td);
	}

	// 삭제 컬럼 - 삭제 버튼
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	td = document.createElement('td');
	td.append(btn);
	tr.append(td);

	// 삭제 버튼에 이벤트 넣기
	btn.addEventListener('click', delBtnFnc, false);

	return tr;
}


// insertBook
function insertTr(e) {
	e.preventDefault();

	let No = this.no.value;
	let Nm = this.name.value;
	let Wr = this.writer.value;
	let Pb = this.publisher.value;
	let Pr = this.price.value;

	fetch('BookServlet', {
		method: 'post',
		headers: {
			'Content-type': 'application/x-www-form-urlencoded'
		},
		body: `cmd=insert&no=${No}&name=${Nm}&writer=${Wr}&publisher=${Pb}&price=${Pr}`
	})
		.then(result => result.json())
		.then(result => {
			document.querySelector('#show tbody').append(makeTr(result));
		})
		.catch(function(err) {
			console.error(err);
		})

	// 폼 인풋 초기화
	this.no.value = '';
	this.name.value = '';
	this.writer.value = '';
	this.publisher.value = '';
	this.price.value = '';

}

// deleteBook
function delBtnFnc(e) {
	e.stopPropagation();
	e.preventDefault();

	let delNo = this.parentElement.parentElement.getAttribute('id');
	console.log('선택된 도서코드: ' + delNo);
	delFetch(delNo);
}

// deleteBook (선택삭제)
function chkDelFnc() {
	let ifChecked = document.querySelectorAll('#show > table > tbody > tr > td > input:checked');
	ifChecked.forEach(elem => {
		let delNo = elem.parentElement.parentElement.getAttribute('id');
		// console.log('선택된 도서코드: ' + delNo);
		delFetch(delNo);
	});
}

// deleteFetch
function delFetch(delNo) {
	fetch('BookServlet', {
		method: 'post',
		headers: {
			'Content-type': 'application/x-www-form-urlencoded'
		},
		body: `cmd=remove&no=${delNo}`
	})
		.then(result => result.json())
		.then(result => {
			// console.log(result);
			if (result.retCode == 'Success') {
				document.getElementById(delNo).remove()
			} else {
				alert('처리중 에러 발생!')
			}
		})
		.catch(function(err) {
			console.error(err);
		})
}
