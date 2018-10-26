<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<html>
<head>
<title>首页</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
</head>
<body>
	hello！
	<form action="${pageContext.request.contextPath}/uploadFile"
		enctype="multipart/form-data" method="POST">
		文件：<input type="file" name="file" /> <input type="submit" value="提交">
	</form>

	<div class="file-upload-file-wrap">
		<div class="file-upload-file-btn">上传文件</div>
		<form id="creditFileForm" enctype="multipart/form-data" method="post">
			<input type="hidden" id="xxx" name="id" value="1"> <input
				type="file" name="file" class="file-upload-file-ipt"
				onchange="fileupload()">
		</form>
	</div>

	<a href="${pageContext.request.contextPath}/deleteFile">删除文件</a>

	<a href="${pageContext.request.contextPath}/201805160516/3/2/02.pdf"
		target="_blank">预览pdf</a>
	<a href="" target="_blank">预览pdf</a>
	<a href="${pageContext.request.contextPath}/201805160516/3/2/11.png"
		target="_blank">预览图片</a>

	<button onclick="timeOutTest()">测试ajax请求超时</button>



	<script type="text/javascript">
		//文件上传
		function fileupload() {
			$('#creditFileForm').ajaxSubmit({
				url : '${pageContext.request.contextPath}/uploadFile',
				type : 'post',
				data : {
					id : $("#xxx").val()
				},
				success : function(res) {
					alert(res);
				}
			});
		}

		function timeOutTest() {
			$.ajax({
				url : "${pageContext.request.contextPath}/timeOutTest",
				timeout: 7000,          // 设置超时时间
				beforeSend : function(xhr) {
					/* $.showLoading(); */ // 数据加载成功之前，使用loading组件
				},
				success : function(json) {
					/* $.hideLoading(); */ // 成功后，隐藏loading组件
					/* if (callback && callback instanceof Function === "true") {
						callback(json);
					} */
					console.log(json);
				},
				error: function (textStatus) {
	                console.error(textStatus);
	            },
		            complete: function (XMLHttpRequest,status) {
		                if(status == 'timeout') {
			                console.log("网络超时，请刷新");
		                    /* xhr.abort();    // 超时后中断请求 */
		                   /*  $.alert("网络超时，请刷新", function () {
		                        location.reload();
		                    }) */
		                }
		            }
			});
		}
	</script>
</body>
</html>