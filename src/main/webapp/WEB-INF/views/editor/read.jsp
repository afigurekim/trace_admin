<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../template/header.jsp"%>

<!-- include summernote css/js -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" 	rel="stylesheet">
<script	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<script src="../../../resources/js/summernote/summernote-ko-KR.js"></script>
<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		//수정하기로 넘어가는 버튼 이벤트
		$(".btn-success").on("click",function(){
				formObj.attr("action", "/editor/modify");
				formObj.attr("method","get");
				formObj.submit();
		});
		//글 삭제로 넘어가는 버튼 이벤트
		$(".btn-danger").on("click",function(){
			formObj.attr("action", "/editor/remove");
			formObj.submit();
	});
		//목로보기로 넘어가는 버튼 이벤트
		$(".btn-default").on("click",function(){
			self.location="/editor/listAll";
	});
	});
	//summernote 호출 함수
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 500,
			minHeight : null,
			maxHeight : null,
			focus : true,
		}); 
		$('#summernote').summernote('disable');
	});
	
	
	
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
					<form role = "form" method="POST">
						<input type = "hidden" name = 'bno' value = "${boardVO.bno} "/>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						
					</form>
						<!--  form title -->
						<div class="form-group">
							<div class="col-md-12">
								<div class="form-label-group">
									<input type="text" id="title" name ="title" readonly class="form-control-plaintext"
										placeholder="title name" required="required"  value = "${boardVO.title } " > <label for="title">Title</label>
								</div>
							</div>
						</div>
						<!-- form writer -->
						<div class="form-group" id="cwriter">
							<div class="col-md-12">
								<div class="form-label-group">
									<input type="text" id="writer" name = "writer" readonly class="form-control-plaintext"
										placeholder="title name" required="required"
										 value = "${boardVO.writer }"> <label for="writer">Writer</label>
								</div>
							</div>
						</div>
						<!-- 테마 설정  -->
						<div class="form-group" id="cselect">
							<div class="col-md-12">
						 <!--  테마값을 이용해 불러오기 위한 el if문  -->
						 <label for="theme">Theme</label>
									<c:if test="${boardVO.theme == 0}">
									<input type="text" readonly class="form-control-plaintext"
										placeholder="title name" required="required"
										 value = "미정"> 
									</c:if>
									<c:if test="${boardVO.theme == 1}">
									<input type="text" readonly class="form-control-plaintext"
										placeholder="title name" required="required"
										 value = "가족"> 
									</c:if><c:if test="${boardVO.theme == 2}">
									<input type="text" readonly class="form-control-plaintext"
										placeholder="title name" required="required"
										 value = "연인"> 
									</c:if><c:if test="${boardVO.theme == 3}">
									<input type="text" readonly class="form-control-plaintext"
										placeholder="title name" required="required"
										 value = "교육"> 
									</c:if>
							</div>
						</div>
						<!--  form content -->
						<div class="form-group">
							<div class="col-md-12">
							<label>Content</label>
								<div class="form-label-group">
								
								<textarea class="form-control" id="summernote" name="content" readonly class="form-control-plaintext"
									placeholder="content">${boardVO.content }</textarea>

								</div>
							</div>
						</div>
						
						<button type="submit" class="btn btn-success">수정하기</button>
						<button type="submit" class="btn btn-default">돌아가기</button>
						<button type="submit" class="btn btn-danger">삭제하기</button>
						

				</div>


				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
	<%@ include file="../template/footer.jsp"%>