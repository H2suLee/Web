
$(document).ready(function() {
	// listBook
	$.ajax({
		url: 'BookServlet',
		method: 'get',
		success: makeList,
		error: function(error) {
			console.log(error);
		}
	});

	// insertBook
	$('form[name="bookForm"]').on('submit', insertTr);

	// deleteBook
	$('input#chkDel').on('click', chkDelFnc);
});

function makeList(result) { // []
	let tbody = $('#show tbody');
	$(result).each((idx, elem) => {
		tbody.append(makeTr(elem));
	});
}

function makeTr(book) { // {}

	let input = $('<input />').attr('type', 'checkbox');
	let btn = $('<button />').text('삭제');
	btn.on('click', delBtnFnc)

	return $('<tr/ >').attr('id', book.no)
		.append(
			$('<td />').append(input),
			$('<td />').text(book.no),
			$('<td />').text(book.name),
			$('<td />').text(book.writer),
			$('<td />').text(book.publisher),
			$('<td />').text(book.price),
			$('<td />').append(btn)
		)
}

// insertBook
function insertTr(e) {
	e.preventDefault();

	let No = this.no.value;
	let Nm = this.name.value;
	let Wr = this.writer.value;
	let Pb = this.publisher.value;
	let Pr = this.price.value;

	$.ajax({
		url: 'BookServlet',
		method: 'post',
		contentType: 'application/x-www-form-urlencoded',
		data: `cmd=insert&no=${No}&name=${Nm}&writer=${Wr}&publisher=${Pb}&price=${Pr}`,
		dataType: 'json',
		success: makeList,
		error: function(error) {
			alert('처리 중 오류 발생!');
		}
	});
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

	let delNo = $(e.target).parent().parent().attr('id');
	console.log('선택된 도서코드: ' + delNo);
	delFetch(delNo);
}

// deleteBook (선택삭제)
function chkDelFnc() {
	//let ifChecked = document.querySelectorAll('#show > table > tbody > tr > td > input:checked');
	let ifChecked = $('#show > table > tbody > tr > td > input');
	console.log(ifChecked);

	ifChecked.filter((idx, elem) => {
		return elem.checked
	}).forEach(elem => {
		let delNo = elem.parentElement.parentElement.getAttribute('id'); //$(elem).parent().parent().attr('id');
		delFetch(delNo);
	});

	/*
	ifChecked.forEach(elem => {
		let delNo = $(elem).parent().parent().attr('id');
		delFetch(delNo);
	});*/
}

// deleteFetch
function delFetch(delNo) {
	$.ajax({
		url: 'BookServlet',
		method: 'post',
		// contentType: 'application/x-www-form-urlencoded', // default가 이거라서 생략 가능
		data: `cmd=remove&no=${delNo}`,
		dataType: 'json',
		success: function(result) {
			if (result.retCode == 'Success') {
				$('#' + delNo).remove();
			} else {
				console.log(result);
			}
		},
		error: function(error) {
			alert('처리중 에러 발생!');
		}
	});
}