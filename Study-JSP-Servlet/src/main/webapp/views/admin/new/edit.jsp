<%@ page contentType="text/html;charset=UTF-8" language="java"%>
    <%@include file="/common/taglib.jsp"%>
        <c:url var="APIurl" value="/api-admin-new" />
        <c:url var="NewURL" value="/admin-new" />
        <html>

        <head>
            <title>Chỉnh sửa bài viết</title>
        </head>

        <body>
            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs" id="breadcrumbs">
                        <script type="text/javascript">
                            try {
                                ace.settings.check('breadcrumbs', 'fixed')
                            } catch (e) {}
                        </script>
                        <ul class="breadcrumb">
                            <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
                            <li class="active">Chỉnh sửa bài viết</li>
                        </ul>
                        <!-- /.breadcrumb -->
                    </div>
                    <div class="page-content">
                        <div class="row">
                            <div class="col-xs-12">

                                <c:if test="${not empty messageResponse}">
                                    <div class="alert alert-${alert}">${messageResponse}</div>
                                </c:if>

                                <form id="formSubmit">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Thể
									loại </label>
                                        <div class="col-sm-9">
                                            <select class="form-control" id="categoryCode" name="categoryCode">
										<c:if test="${empty model.categoryCode}">
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${category}">
												<option value="${item.code}">${item.name}</option>
											</c:forEach>
										</c:if>

										<c:if test="${not empty model.categoryCode}">

											<c:forEach var="item" items="${category}">
												<option value="${item.code}"
													<c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
													${item.name}</option>
											</c:forEach>
											<option value="">Chọn loại bài viết</option>
										</c:if>

									</select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Tiêu
									đề </label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" value="${model.title}" name="title" id="title" />
                                        </div>
                                    </div>
                                    <br /> <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Hình
									đại diện </label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" value="${model.thumbnail}" name="thumbnail" id="thumbnail" />
                                        </div>
                                    </div>
                                    <br /> <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Mô
									tả ngán </label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" value="${model.shortDescripTion}" name="shortDescripTion" id="shortDescripTion" />
                                        </div>
                                    </div>
                                    <br /> <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Nội
									dung </label>
                                        <div class="col-sm-9">
                                            <!-- <input type="text" class="form-control" value="${model.content}" name="content" id="content" /> -->
                                            <textarea name="content" id="content" cols="123" rows="20">${model.content}</textarea>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <c:if test="${not empty model.categoryCode}">
                                                <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật bài viết" id="btnAddOrUpdateNew" />
                                            </c:if>
                                            <c:if test="${empty model.categoryCode}">
                                                <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm bài viết" id="btnAddOrUpdateNew" />
                                            </c:if>

                                        </div>
                                    </div>
                                    <input type="hidden" value="${model.id}" id="id" name="id">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                var editor = '';
                $(document).ready(function() { // những thú trong đây sẽ chạy đầu tiên khi chạy sever giông hàm main() bên lap trinh console
                    editor = CKEDITOR.replace('content');
                });
                $('#btnAddOrUpdateNew').click(function(e) {
                    e.preventDefault(); //Tránh submit nhầm url 
                    // var title = $('#title').val();
                    // var categoryCode = $('#categoryCode').val();
                    // var thumbnail = $('#thumbnail').val();
                    // var shortDescripTion = $('#shortDescripTion').val();
                    // var content = $('#content').val();
                    var data = {};
                    var formData = $('#formSubmit').serializeArray(); // lay gia tri cua các thẻ index là name && value tạo thành mảng
                    $.each(formData, function(i, v) {
                        data["" + v.name + ""] = v.value; // lập để lấy dữ liệu name value vào data
                    });
                    data["content"] = editor.getData(); // dùng để get data từ textaria CKEDITOR
                    var id = $('#id').val();
                    if (id == "") {
                        addNew(data);
                    } else {
                        upDataNew(data);
                    }
                });

                function addNew(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function(result) {
                            window.location.href = "${NewURL}?type=edit&id=" + result.id + "&message=insert_success";
                        },
                        error: function(error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
                        },
                    });
                }

                function upDataNew(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'PUT',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function(result) {
                            window.location.href = "${NewURL}?type=edit&id=" + result.id + "&message=updata_success";
                        },
                        error: function(error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
                        },
                    });
                }
            </script>
        </body>

        </html>