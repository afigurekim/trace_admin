<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../template/header.jsp"%>
<div id="content-wrapper">

	<div class="container-fluid">
		<div class="col-md-6">
			<!-- DataTables Example -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-table"></i> 카테고리 게시글 등록하기
				</div>
				<div class="card-body">
					<!-- 게시글 등록하기구나   -->

					<!--  form title -->
					<div class="form-group">
						<div class="col-md-12">
							<div class="form-label-group">
								<input type="text" id="title" class="form-control"
									placeholder="title name" required="required"
									autofocus="autofocus"> <label for="title">Title</label>
							</div>
						</div>
					</div>

					<!--  form content -->
					<div class="form-group">
						<div class="col-md-12">
							<div class="form-label-group">
								<textarea id="content" class="form-control" required="required"
									autofocus="autofocus"></textarea>
								<label for="title">Content</label>
							</div>
						</div>
					</div>
					<!-- form writer -->
					<div class="form-group">
						<div class="col-md-12">
							<div class="form-label-group">
								<input type="text" id="writer" class="form-control"
									placeholder="title name" required="required"
									autofocus="autofocus"> <label for="writer">Writer</label>
							</div>
						</div>
					</div>
				</div>
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
	<%@ include file="../template/footer.jsp"%>