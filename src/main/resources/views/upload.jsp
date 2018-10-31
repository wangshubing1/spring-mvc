<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    upload文件上传
    <meta http-equiv="Content-Type" contentType="text/html; charset=utf-8">
    <title>upload page</title>
</head>
<body>
<%-- "<%=request.getContextPath()%>/UploadServlet"--%>
<div class="upload">
<form action="upload" method="post" enctype="multipart/form-data">

            <input type="file" name="file" size="20" maxlength="80"><br/>
            <input type="submit" value="上传">
</form>
</div>
</body>
</html>
