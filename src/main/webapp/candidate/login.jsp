<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!doctype html>
<html lang="en">
<jsp:include page="/header.jsp" />
<script>
    function validate() {
        document
            .querySelector('#form-auth-data')
            .onsubmit = function (evt) {
            if ($('#user-name').val() === '' || $('#user-pwd').val() === '') {
                alert($('#user-email').attr('title'));
                evt.preventDefault();
            }
        }
    }
</script>
<body>
<div class="container pt-3">

    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Авторизация
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/auth.do"
                      id="form-auth-data"
                      method="post">
                    <div class="form-group">
                        <label>Почта</label>
                        <input type="text"
                               class="form-control"
                               id="user-email"
                               name="email"
                               required>
                    </div>
                    <div class="form-group">
                        <label>Пароль</label>
                        <input type="text"
                               class="form-control"
                               id="user-pwd"
                               name="password" required >
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="validate()">Войти</button>
                    <a class="btn btn-secondary" href="<%=request.getContextPath()%>/candidate/reg.jsp">Регистрация</a>
                    <c:if test="${not empty error}">
                        <div style="color:red; font-weight: bold; margin: 30px 0;">
                            <c:out value="${error}"/>
                        </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>