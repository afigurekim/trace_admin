<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file ="../template/header.jsp" %>
<script>
$(function(){
var thema = "";
var period="";

$(".modify").click(function(){
var index=$(".modify").index($(this));
var index2;
var bno=0;
bno=$(".bno").eq(index).text();
console.log(bno+"bno에요");
console.log("인덱스입니다"+index);
	$(".period:eq("+index+")>input[name=period]:checked").each(function(idx){
			period=$(this).val();

		console.log(period)
	});
	$(".thema:eq("+index+")>input[name=thema]:checked").each(function(idx){

			thema+=$(this).val()+" ";
		console.log(thema);
	});
	
	$.ajax({
		url:"/modifyCategory",
		type:'post',
		data:{
			sbno:bno,
			speriod:period,
			sthema:thema,
		},
		beforeSend:function(xhr){
			xhr.setRequestHeader("${_csrf.headerName}","${_csrf.token}");
		},
		success:function(data){
			alert("수정되었습니다");
			thema="";
			period="";
		}
	});
});
});  
</script>    
    <div id="content-wrapper">

      <div class="container-fluid">
        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            카테고리 테마 분류</div>
          
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <colgroup>
                	<col width="10%"/>
                	<col width="15%"/>
                	<col width="10%"/>
                	<col width="15%"/>
                	<col width="20%"/>
                	<col width="20%"/>
           	    	<col width="5%"/>
               
                </colgroup>
                <thead>
                  <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>시대</th>
                    <th>테마</th>
                    <th></th>
                    <th></th>
                    <th>수정</th>
                  </tr>
                </thead>
               
                <tbody>
                  <c:forEach items="${list}" var="list">
                  
                  <tr>
                    <td class="bno">${list.bno}</td>
                    <td>${list.site_name}</td>
					<td>${list.period}</td>
					<td>${list.thema}</td>
					<td>
					<form class="period">
					<input type="radio" name="period" value="선사">선사
					<input type="radio" name="period" value="삼국">삼국
					<input type="radio" name="period" value="고려">고려
					<input type="radio" name="period" value="조선">조선
					<input type="radio" name="period" value="근현대">근현대
					</form>
					</td>      
					<td>
					<form class="thema" >
					<input type="checkbox" name="thema" value="고육">교육
					<input type="checkbox" name="thema" value="데이트">데이트
					<input type="checkbox" name="thema" value="가족">가족
					<input type="checkbox" name="thema" value="종교">종교
					</form>
					</td>
					
					<td>
					<button type="button" class="modify">수정</button>
					</td>
                  </tr>
                  </c:forEach>
                  
                   
                 
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <!-- /.container-fluid -->
<%@ include file ="../template/footer.jsp" %>