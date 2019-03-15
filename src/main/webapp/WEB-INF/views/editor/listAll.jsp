<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../template/header.jsp"%>
<style>
a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	color: blue;
	text-decoration: underline;
}
</style>

<script>
	var result = '${msg}';
	if (result == 'success') {
		alert("처리가 완료되었습니다.");
	}
</script>
<div id="content-wrapper">

	<div class="container-fluid">
		<!-- DataTables Example -->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> 에디터 추천코스 관리
				<button id="regBtn" class="btn btn-primary float-right"
					type="Button">새글 등록 하기</button>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>글번호</th>
								<th>글제목</th>
								<th>테마</th>
								<th>글쓴이</th>
								<th>작성날짜</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>글번호</th>
								<th>글제목</th>
								<th>테마</th>
								<th>글쓴이</th>
								<th>작성날짜</th>
								<th>조회수</th>
							</tr>
						</tfoot>
						<tbody>

							<c:forEach items="${list }" var="vo">
								<tr>
									<td><c:out value="${vo.bno }" /></td>
									<td width="50%"><a href='/editor/read?bno=${vo.bno }&${vo.theme}'><c:out
												value="${vo.title }" /></a></td>
									<%-- 	<td><c:out value = "${vo.theme }"/>	</td> --%>

									<!--  테마값을 이용해 불러오기 위한 el if문  -->
									<c:if test="${vo.theme == 0}">
									<td>미정</td>
									</c:if>
									<c:if test="${vo.theme == 1}">
									<td>가족</td>
									</c:if><c:if test="${vo.theme == 2}">
									<td>연인</td>
									</c:if><c:if test="${vo.theme == 3}">
									<td>교육</td>
									</c:if><c:if test="${vo.theme == 4}">
									<td>종교</td>
									</c:if>
									
									
									<td><c:out value="${vo.writer }" /></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd"
											value="${vo.regdate }" /></td>
									<td><c:out value="${vo.viewcnt }" /></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated yesterday at
				11:59 PM</div>
		</div>

		<script>
			$(document).ready(function() {
				$("#regBtn").on("click", function() {
					self.location = "/editor/register";
				});
			});
		</script>

		<!-- /.container-fluid -->
		<%@ include file="../template/footer.jsp"%>