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
            <h2>Retrospective</h2>
            <hr/>

            <h4>1. 足し算のメソッドを作成しよう </h4>
            <form action="retro_method" method="post">
                <input type="number" name="input11" size="2" value="${input11}" min = "1" max = "99" required placeholder="1-99" />
                &nbsp; ＋ &nbsp;
                <input type="number" name="input12" size="2" value="${input12}" min = "1" max = "99" required placeholder="1-99" />
                &nbsp; ＋ &nbsp;
                <input type="number" name="input13" size="2" value="${input13}" min = "1" max = "99" required placeholder="1-99" />
                <input type="hidden" name="workno" value="1" />
                <input type="submit" value="＝" />
                <input type="number" name="result1" size="2" value="${result1}" min = "1" max = "99" disabled="disabled" placeholder="answer" />
            </form>
            <hr/>

            <h4>2. あいさつするメソッドを作成しよう </h4>
            <form action="retro_method" method="post">
                <label>name：</label>
                <input type="text" name="input2" size="50" value="${input2}" required placeholder="国際りこ" />
                <input type="hidden" name="workno" value="2" />
                <input type="submit" />
            </form>
            <p>こんにちは．．．</p>
            <textarea rows="3" cols="80" name="result2" disabled placeholder="結果は．．．"><c:out value="${result2}"/></textarea>
            <hr/>

            <h4>3. 数字を当てるメソッドを作成しよう </h4>
            <form action="retro_method" method="post">
                <label>input：</label>
                <input type="number" name="input3" size="2" value="${input3}" min = "0" max = "9" required placeholder="0-9" />
                <input type="hidden" name="workno" value="3" />
                <input type="submit" />
            </form>
            <p>当てる数は．．．
                <c:if test="${!empty result3}">
                    <span class="target"><c:out value="${result3.target}"/></span>
                </c:if>
            </p>
            <textarea rows="3" cols="80" name="result3" disabled placeholder="結果は．．．"><c:out value="${result3.score}"/></textarea>
            <hr/>

            <h4>4. メソッドを使ってなんかやってみよう</h4>
            <form action="retro_method" method="post">
                <label>input：</label>
                <input type="text" name="input4" size="10" value="${input4}" required placeholder="なんでもOK" />
                <input type="hidden" name="workno" value="4" />
                <input type="submit" />
            </form>
            <p>どんなのができるか．．．</p>
            <textarea rows="3" cols="80" name="result3" disabled placeholder="結果は．．．"><c:out value="${result4}"/></textarea>
            <hr/>
        </div>
    </main>

    <footer class="footer mt-auto fixed-bottom py-3 bg-secondary"></footer>

    <script src="<c:url value="/assets/bootstrap.bundle.min.js" />"></script>
    <script src="<c:url value="/assets/script.js" />"></script>
</body>

</html>