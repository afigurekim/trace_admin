<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file ="../template/header.jsp" %>
<script>
$(function(){

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
                	<col width="20%"/>
                	<col width="10%"/>
                	<col width="35%"/>
                	<col width="10%"/>
                	<col width="15%"/>
                	<col width="5%"/>
           	    
                </colgroup>
                <thead>
                  <tr>
                    <th>유적지이름</th>
                    <th>댓글 번호</th>
                    <th>내용</th>
                    <th>날짜</th>
                    <th>글쓴이</th>
                    <th>삭제</th>
                  </tr>
                </thead>
               		
                <tbody>
               	
                  
                   
                 
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <!-- /.container-fluid -->
<%@ include file ="../template/footer.jsp" %>