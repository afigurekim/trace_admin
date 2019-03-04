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

input {

  margin: 40px 25px;

  width: 200px;

  display: block;

  border: none;

  padding: 10px 0;

  border-bottom: solid 1px #1abc9c;

  -webkit-transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);

  transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);

  background: -webkit-linear-gradient(top, rgba(255, 255, 255, 0) 96%, #1abc9c 4%);

  background: linear-gradient(to bottom, rgba(255, 255, 255, 0) 96%, #1abc9c 4%);

  background-position: -200px 0;

  background-size: 200px 100%;

  background-repeat: no-repeat;

  color: #0e6252;
}
 

input:focus, input:valid {

 box-shadow: none;

 outline: none;

 background-position: 0 0;

}

input::-webkit-input-placeholder {
 font-family: 'roboto', sans-serif;
 -webkit-transition: all 0.3s ease-in-out;
 transition: all 0.3s ease-in-out;
}

input:focus::-webkit-input-placeholder, input:valid::-webkit-input-placeholder {
 color: #1abc9c;
 font-size: 15px;
 -webkit-transform: translateY(-5px);
 transform: translateY(-5px);
 visibility: visible !important;
}

//

div {
    display: inline-block;
    position: relative;
}
hr {
    border-bottom: 2px solid rgb(0, 188, 212);
    bottom: -1px;
    margin: 0;
    position: relative;
    top:-10px;
 //   width: 100%;
    transform: scaleX(0);
    transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms;
}

textarea:hover + hr,
textarea:focus + hr {
    transform: scaleX(1);
}




</style>

   <!-- body -->

  <div class="container" style="height: 730px; margin-top: 50px; padding-top: 40px;">
	 <div style="position: relative; left: 110px; border-left: 5px solid gray; ">
   <h3 style="font-weight: bold; margin-left: 7px;">공지사항 수정</h3>
   </div> 
   
   <form action="/notice/update" method="post">
   <input type="hidden" name="bno" value='<c:out value="${board.bno }"/>'>
	<div style="margin: auto;  height: 70px; margin-top: 20px; width: 900px;" >
  		<input type="text" class="form-control" id="title" name="title" value='<c:out value="${board.title }"/>' style="width: 100%; height: 50px; position: relative; left: -24px; " required>
	</div>
	<div style="margin: auto;  height: 370px; margin-top: 10px; width: 900px; " >
		<textarea id="content" name="content" style="width: 100%; height: 100%;" placeholder="내용을 작성해주세요" ><c:out value="${board.content }"/></textarea><hr>
   	</div>
	<div style="margin: auto;  height: 50px; margin-top: 20px; width: 900px; margin-bottom: 20px;" >
		 <div class="form-group mx-sm-3 mb-2">
		 <label style="position: relative; top: 2px; left: 590px; font-weight: bold; font-size: 15px;">작성자</label>
	  	<input type="text" id="writer" name="writer"  value='<c:out value="${board.writer }"/>' readonly="readonly" style="width: 26%; height:48px; position: relative; left:40px; top:-48px; float: right; margin-left: 5px;">
	           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	 
	  </div> 
	</div>

	<div style="width: 150px; margin: auto; padding-bottom: 12px;">
		<button type="submit" class="btn btn-outline-info">수정</button>
		<button type="reset" class="btn btn-outline-dark"><%-- <a href="/notice/read?bno=<c:out value="${board.bno }"/>'"> --%><a href="/notice/list">취소</a></button>
	</div>
   	</form>
   	
    </div>

    <!-- body end -->
 
   <!-- /.container-fluid -->
<%@ include file="../template/footer.jsp"%>