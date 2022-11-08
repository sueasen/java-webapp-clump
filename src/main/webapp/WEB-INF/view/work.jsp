<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>JavaDevelop</title>
    <link rel="shortcut icon" href="<c:url value="/assets/favicon.ico" />">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/assets/bootstrap-icons.css" />">
    <link rel="stylesheet" href="<c:url value="/assets/styles.css" />">
</head>

<body>

    <%@ include file="./_headerNavbar.jsp" %>

    <main>
        <div class="container workspace">
            <h2>Hello World!</h2>
            <form action="web_app_work" method="post" enctype="multipart/form-data">
                <label>入力：</label>
                <input type="text" name="input1" />
                <br/>
                <label>ファイル：</label>
                <input type="file" name="file1" required />
                <input type="submit" />
            </form>
            <hr/>
            <p>返ってきた値は．．．<c:out value="${result1}"/></p>
            <p>出るけど危険．．．${result1}</p>
            <hr/>
            <p>DTOつかってみると．．．</p>
            <p>getter は変数名で取得できる：<c:out value="${resultDto.input}"/></p>
            <p>メソッドも使える：<c:out value="${resultDto.tekito()}"/></p>
            <p>メソッドも使える：<c:out value="${resultDto.tekito(1)}"/></p>
            <p>DTOだけだと：<c:out value="${resultDto}"/></p>
            <hr/>
            <div class="back_red">てきとうなわく</div>
            <div class="back_blue">てきとうなわく</div>
            <div class="back_pink">てきとうなわく</div>
            <div class="back_green">てきとうなわく</div>
            <hr/>
            <div class="upload">
                <p>アップロードファイルを表示してみる</p>
                    <c:if test="${!empty resultDto.filePath}">
                    <div class="spinner-border d-none uploadFileLoading"></div>
                    <video class="uploadFile" src="<c:url value="${resultDto.filePath}" />" controls></video>
                </c:if>
            </div>
            <hr/>
        </div>
    </main>

    <footer class="footer mt-auto fixed-bottom py-3 bg-secondary"></footer>

    <script src="<c:url value="/assets/bootstrap.bundle.min.js" />"></script>
    <script src="<c:url value="/assets/script.js" />"></script>
</body>

</html>