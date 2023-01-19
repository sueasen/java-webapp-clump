<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <h2>WebAPI やってみる</h2>
            <hr/>

            <h4>1. JSP から WebAPI 実行 </h4>
            <button id="apicat" class="btn btn-info">ねこ情報取得</button>
            <p>WebAPI から取得した 情報（JSON）</p>
            <textarea id="apicat_json" rows="2" cols="80" disabled placeholder="結果は．．．"></textarea>
            <p>WebAPI から取得した画像</p>
            <img id="apicat_img" src="">
            <hr/>
            <button id="apiuser" class="btn btn-info">ユーザ情報取得</button>
            <p>WebAPI から取得した 情報（JSON）</p>
            <textarea id="apiuser_json" rows="3" cols="80" disabled placeholder="結果は．．．"></textarea>
            <p>WebAPI から取得した画像</p>
            <img id="apiuser_img" src="">
            <hr/>
            <button id="apifox" class="btn btn-info">きつね情報取得</button>
            <p>WebAPI から取得した 情報（JSON）</p>
            <textarea id="apifox_json" rows="2" cols="80" disabled placeholder="結果は．．．"></textarea>
            <p>WebAPI から取得した画像</p>
            <img id="apifox_img" src="">
            <hr/>
            <button id="apistar" class="btn btn-info">星座情報取得</button>
            <p>WebAPI から取得した 情報（JSON）</p>
            <textarea id="apistar_json" rows="2" cols="80" disabled placeholder="結果は．．．"></textarea>
            <p>WebAPI から取得した画像</p>
            <img id="apistar_img" src="">
            <hr/>
            <button id="apipokemon" class="btn btn-info">ポケモン取得</button>
            <p>WebAPI から取得した 情報（JSON）</p>
            <textarea id="apipokemon_json" rows="2" cols="80" disabled placeholder="結果は．．．"></textarea>
            <p>WebAPI から取得した画像</p>
            <img id="apipokemon_img" src="">
            <hr/>

        </div>
    </main>

    <footer class="footer mt-auto fixed-bottom py-3 bg-secondary"></footer>

    <script src="<c:url value="/assets/bootstrap.bundle.min.js" />"></script>
    <script src="<c:url value="/assets/script.js" />"></script>
</body>

</html>