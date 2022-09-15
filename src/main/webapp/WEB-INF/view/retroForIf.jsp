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

            <h4>1. if 文を使って数字を当ててみよう </h4>
            <form action="retro_forif" method="post">
                <label>input：</label>
                <input type="number" name="input1" size="2" value="${input1}" min = "0" max = "9" required placeholder="0-9" />
                <input type="hidden" name="workno" value="1" />
                <input type="submit" />
            </form>
            <p>当てる数は．．．
                <c:if test="${!empty target1}"><span class="target"><c:out value="${target1}"/></span></c:if>
            </p>
            <textarea rows="3" cols="80" name="result1" disabled placeholder="結果は．．．"><c:out value="${result1}"/></textarea>
            <hr/>

            <h4>2. for 文を使って数字を出してみよう </h4>
            <form action="retro_forif" method="post">
                <label>input：</label>
                <input type="number" name="input2" size="2" value="${input2}" min = "1" max = "99" required placeholder="1-99" />
                <input type="hidden" name="workno" value="2" />
                <input type="submit" />
            </form>
            <p>数は出るか．．．</p>
            <textarea rows="3" cols="80" name="result2" disabled placeholder="結果は．．．"><c:out value="${result2}"/></textarea>
            <hr/>

            <h4>3. if, for 文を使って数字を当ててみよう </h4>
            <form action="retro_forif" method="post">
                <label>input：</label>
                <input type="number" name="input3" size="2" value="${input3}" min = "1" max = "99" required placeholder="1-99" />
                <input type="hidden" name="workno" value="3" />
                <input type="submit" />
            </form>
            <p>当てる数は．．．
                <c:if test="${!empty targets3}">
                    <span class="target"><c:out value="${targets3[0]}"/></span>
                    <span class="target"><c:out value="${targets3[1]}"/></span>
                    <span class="target"><c:out value="${targets3[2]}"/></span>
                </c:if>
            </p>
            <textarea rows="3" cols="80" name="result3" disabled placeholder="結果は．．．"><c:out value="${result3}"/></textarea>
            <hr/>

            <h4>4. if, for 文を使ってなんかやってみよう</h4>
            <form action="retro_forif" method="post">
                <label>input：</label>
                <input type="text" name="input4" size="10" value="${input4}" required placeholder="なんでもOK" />
                <input type="hidden" name="workno" value="4" />
                <input type="submit" />
            </form>
            <p>どんなのできるか．．．</p>
            <textarea rows="3" cols="80" name="result3" disabled placeholder="結果は．．．"><c:out value="${result4}"/></textarea>
            <hr/>
        </div>
    </main>

    <footer class="footer mt-auto fixed-bottom py-3 bg-secondary"></footer>

    <script src="<c:url value="/assets/bootstrap.bundle.min.js" />"></script>
    <script src="<c:url value="/assets/script.js" />"></script>
</body>

</html>