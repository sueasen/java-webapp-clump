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

            <h4>1. クラス ShapeArea にメソッド追加してインスタンス生成してみよう </h4>
            <form action="retro_class" method="post">
                <label>サイズ：</label>
                <input type="number" name="input1" size="2" value="${input1}" min = "1" max = "99" required placeholder="1-99" />
                <input type="hidden" name="workno" value="1">
                <input type="submit" />
            </form>
            <p>面積は．．．</p>
            <textarea rows="3" cols="80" name="result1" disabled placeholder="結果は．．．">円：<c:out value="${result1.calcCircle()}"/>&#13;正方形：<c:out value="${result1.calcSquare()}"/></textarea>
            <hr/>

            <h4>2. クラス Memo を実装してインスタンス生成してみよう </h4>
            <form action="retro_class" method="post">
                <label>name：</label>
                <input type="text" name="input21" size="50" value="${input21}" required placeholder="例：国際りこ" /><br/>
                <label>message：</label>
                <input type="text" name="input22" size="50" value="${input22}" required placeholder="例：こにちはー" /><br/>
                <input type="hidden" name="workno" value="2" />
                <input type="submit" />
            </form>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>name</th>
                        <th>message</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${!empty result2}">
                        <tr>
                            <td><c:out value="${result2.name}"/></td>
                            <td><c:out value="${result2.message}"/></td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
            <hr/>

            <h4>3. クラス MemoDate を実装してインスタンス生成してみよう </h4>
            <form action="retro_class" method="post">
                <label>name：</label>
                <input type="text" name="input31" size="50" value="${input31}" required placeholder="例：国際りこ" /><br/>
                <label>message：</label>
                <input type="text" name="input32" size="50" value="${input32}" required placeholder="例：こにちはー" /><br/>
                <input type="hidden" name="result" value="${result3}" />
                <input type="hidden" name="workno" value="3">
                <input type="submit" />
            </form>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>name</th>
                        <th>message</th>
                        <th>createDate</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${result3memoDates}" var="memo">
                        <tr>
                            <td><c:out value="${memo.name}"/></td>
                            <td><c:out value="${memo.message}"/></td>
                            <td><fmt:formatDate value="${memo.createDate}" pattern="yyyy/MM/dd HH:mm:ss(E)" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <hr/>

            <h4>4. メソッドを使ってなんかやってみよう</h4>
            <form action="retro_class" method="post">
                <label>input：</label>
                <input type="text" name="input4" size="10" value="${input4}" required placeholder="なんでもOK" />
                <input type="hidden" name="workno" value="4">
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