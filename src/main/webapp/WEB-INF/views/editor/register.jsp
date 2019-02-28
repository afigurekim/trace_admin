<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../template/header.jsp"%>

<!-- include summernote css/js -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<script src="../resources/js/summernote/summernote-ko-KR.js"></script>

<script>
	//파일 확장자 존재 검사
	function checkImageType(fileName) {
		var pattern = /jpg|gif|png|jpeg/i;
		return fileName.match(pattern);
	}

	//화면에 데이터 출력 함수 

	//summernote 기본 설정 
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 500,
			minHeight : null,
			maxHeight : null,
			focus : true,
			// 이미지 업로드를 위한 함수 
		 	/* callbacks : {
				onImageUpload : function(files) {
					console.log(files);
					 for (var i = files.length - 1; i >= 0; i--) {
						sendFile(files[i], this);
					} 
				}
			}  */
		});
	});
	/* function sendFile(file, editor) { //summernote 에서 파일저장을 위한 함수 
		var form_data = new FormData();
		form_data.append('file', file);

		$.ajax({
			url : 'register',
			data : form_data,
			type : "POST",
			contentType : false,
			processData : false,
			cache : false,
			enctype : 'multipart/form-data',
			success : function(url) { // 이미지 처리가 성공한경우
				//에디터에 이미지 출력
				$(editor).summernote('editor.insertImage', url);
			}
		});
	} */
	//파일이름 길이 줄여주는 함수

	function getOriginalName(fileName) {
		if (checkImageType(fileName)) {
			return;
		}
		var idx = fileName.indexOf("_") + 1;
		return fileName.substr(idx);
	}
</script>
<style>
#cwriter {
	display: inline-block;
}

#cselect {
	display: inline-block;
}
</style>

<div id="content-wrapper">

	<div class="container-fluid">
		<div class="col-md-6">
			<!-- DataTables Example -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-table"></i> 에디터 추천코스 등록하기
				</div>
				<div class="card-body">
					<!-- 게시글 등록하기구나   -->
					<form method="POST">
						<!--  form title -->
						<div class="form-group">
							<div class="col-md-12">
								<div class="form-label-group">
									<input type="text" id="title" name="title" class="form-control"
										placeholder="title name" required="required"
										autofocus="autofocus"> <label for="title">Title</label>
								</div>
							</div>
						</div>
						<!-- form writer -->
						<div class="form-group" id="cwriter">
							<div class="col-md-12">
								<div class="form-label-group">
									<input type="text" id="writer" name="writer"
										class="form-control" placeholder="title name"
										required="required" autofocus="autofocus"> <label
										for="writer">Writer</label>
								</div>
							</div>
						</div>
						<!-- 테마 설정  -->
						<div class="form-group" id="cselect">
							<div class="col-md-12">
								<label>Theme</label> <select class="form-control" id = "theme" name = 'theme'>
									<option value ="0" >테마선택</option> 
									<option value = "1">가족</option>
									<option value = "2" >연인</option>
									<option value = "3" >교육</option>
								</select>
							</div>
						</div>

						<!--  form content -->
						<div class="form-group">
							<div class="col-md-12">
								<label>Content</label>
								<div class="form-label-group">

									<textarea class="form-control" id="summernote" name="content"
										placeholder="content"></textarea>

								</div>
							</div>
						</div>

						<button type="reset" class="btn btn-default">취소하기</button>
						<button type="submit" class="btn btn-primary">등록하기</button>
					</form>
				</div>


				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
	<%@ include file="../template/footer.jsp"%>