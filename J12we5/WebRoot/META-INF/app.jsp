<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>发帖</title>
<script
	src="https://cdn.ckeditor.com/ckeditor5/12.0.0/classic/ckeditor.js"></script>
</head>



<style>
<!--
-->
.ck {

	height: 300px
 
}
</style>
<body>

	<div class="txt">
		<form action="dofileupload.jsp" method="post" enctype="multipart/form-data" >
			新闻标题：<input type="text" value="" name="title" /><br /> 内容：
			<textarea name="content" id="editor" class="ck"></textarea></br>
			图片:<input type="file" name="myimg" /> <br /> <input type="submit"
				value="提交" />
		</form>
	</div>
	<script>
        ClassicEditor
            .create(document.querySelector('#editor')).catch(error=>){
                console.error( error ); 
            } );
    </script>
</body>
</html>