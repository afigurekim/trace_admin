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

tr>td>a{
 text-decoration: none;
}


</style>

<div class="container" style="margin-top: 100px;">
	<h3>공지사항</h3>
	<p style="margin-bottom: 20px;">발자취의 공지사항을 확인하세요</p>

	  <table class="table">
	   
	      <tr style="border-top: 1px solid #ddd;">
		<th >No</th>
		<th  id="d">제목</th>
		<th >작성자</th>
		<th>날짜</th>
		<th >조회수</th>
		 </tr>

  <c:forEach items="${list1 }" var="vo">
	      <tr style="border-top: 1px solid #ddd;">
		<td><a href="/notice/read${pageMaker.makeSearch(pageMaker.cri.page)}& bno=${vo.bno }" ><c:out value="${vo.bno}"/></a></td>
		<td><a href="/notice/read?bno=${vo.bno }" ><c:out value="${vo.title }"/></a></td> 
		<td><a href="/notice/read?bno=${vo.bno }" >${vo.writer }</a></td>
		<td><a href="/notice/read?bno=${vo.bno }" ><fmt:formatDate pattern="yy-MM-dd" value="${vo.reg_date }"/></a></td>
		<td ><c:out value="${vo.view_cnt }"></c:out> </td>
	      </tr>
  </c:forEach>
	   
	  </table>
		<button class="btn btn-outline-primary" style="float: right;"><a href="/notice/register">등록</a></button>

	<div class="text-center" style="margin: auto;  width: 500px; height: 80px; margin-top: 70px;">
	<ul class="pagination">
		<c:if test="${pageMaker.prev }">
			<li><a href="list${pageMaker.makeSearch(pageMaker.startPage-1)}">&laquo;</a> </li>
		</c:if>
		
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage }" var="idx">
			<li
				<c:out value="${pageMaker.cri.page==idx?'class=active':''}"/>>
				<a href="list${pageMaker.makeSearch(idx)}">${idx }</a>
			</li>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage>0 }">
			<li><a href="list${pageMaker.makeSearch(pageMaker.endPage+1)}">&raquo;</a> </li>
		</c:if>
	</ul>
</div>
<!--paging 처리 end -->

	<div class="box-body" style="width: 580px; margin: auto;">
		<div style="display: inline; float: left; width:115px;">
		<select name="searchType" class="selectpicker" style="height: 37px;">
			<option value="t"
			<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
			제목</option>
			<option value="c"
			<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
			내용</option>
			<option value="tc"
			<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
			제목 + 내용</option>
		</select>
		</div>
		<div style="display: inline; float: left; width: 305px;">
		<input type="text" name="keyword" id="keywordInput" class="form-control" value='${cri.keyword }' placeholder="검색어를 입력해주세요" style=" width: 300px;">
		</div>
		<div style="display: inline; float: left; width: 150px;">
		<button class="btn btn-outline-primary" id="searchBtn" style="">Search</button>
		</div>
	</div>
	
<script>
$(document).ready(function() {
			$('#searchBtn').on(
				"click",
				function(event) {
					str = "list"
					+ '${pageMaker.makeQuery(1)}'
					+ "&searchType="
					+ $("select option:selected").val()
					+ "&keyword=" + encodeURIComponent($('#keywordInput').val());
					self.location = str;
				});
		});
	</script>
</div>	<!-- 테이블 end -->


	<!-- body end-->
<%@ include file="../template/footer.jsp"%>
