function common_func() {
	// Custom Select Box에 대한 공통 이벤트 처리
	$(".select-enabled").each(function(index) {
		$(this).on("click", function() {
			$(this).closest("ul").siblings(".selected-item").text($(this).text());
			$(this).closest("ul").siblings("input").val($(this).attr("key"));
		});
		$(this).on("mouseover", function() {
			$(this).siblings().removeClass("select-hovering-item");
			$(this).addClass("select-hovering-item");
		});
	});

}

// Upload를 위한 이미지 파일 체크
function checkUploadFile(file, size) {
	if (size == 'undefined')
		size = 10000000;
	else
		size = size * 1000;

	var rtnVal = false;
	if (file.name.length < 1) {

	} else if (file.size > size) {
		alert("파일이 너무 큽니다.");
	} else if (file.type != 'image/png' && file.type != 'image/jpg' && file.type != 'image/gif' && file.type != 'image/jpeg') {
		alert("jpg, png, gif, jpeg 파일만 Upload 가능 합니다.");
	} else {
		rtnVal = true;
	}
	return rtnVal;
}

// 오류 메시지를 제거한다.
function clearRequiredErrorMessage(sFrm) {
	$(sFrm).find(".error-status").each(function () {
		$(".error-status").remove();
	});
	$("#errormsg").html("");
	$("#successmsg").html("");
}

// 필수 입력항목을 검사후 오류 메시지를 출력한다.
function checkRequired(sFrm) {
	var valid = true;
	$(sFrm).find('select, textarea, input').each(function() {
		if (!$(this).prop('required')) {

		} else {
			if (!$(this).val()) {
				name = $(this).attr('name');
				$(this).after('<div class="error-status"><span id="' + name + '" class="error-message">이 필드는 필수 항목입니다.</span></div>');
				$(this).focus();
				valid = false;
				return false;
			}
		}
	});
	return valid;
}
