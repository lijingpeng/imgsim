<%--
  Created by IntelliJ IDEA.
  User: frank
  Date: 16/8/1
  Time: 下午10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image Similarity</title>
</head>
<body>
    <form action="/home.do" method="get">
        Image URL1: <input name="url1" type="text" style="width: 100%" />

        Image URL2: <input name="url2" type="text" style="width: 100%" />

        <input value="确定" type="submit"/>
    </form>

    <img src=${url1} />
    <img src=${url2} />
    <p/>
    URL1 Hash：${url1_hash}
    <p/>
    URL2 Hash：${url2_hash}
    <h5>相似度(Binary)： ${message1} </h5>

</body>
</html>
