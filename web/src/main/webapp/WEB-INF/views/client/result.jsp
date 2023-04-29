<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="userName" class="java.lang.String" scope="session"/>
<jsp:useBean id="buildName" class="java.lang.String" scope="session"/>
<jsp:useBean id="error" class="java.lang.String" scope="request"/>
<jsp:useBean id="chartNames" class="java.util.ArrayList" scope="session"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div class="container">
    <div class="row">
        <div class="col-md-2">

        </div>
        <div class="col-md-8">
            <h3>${error}</h3>
        </div>
        <div class="col-md-2">

        </div>
    </div>
    <div class="row">
        <div class="col-md-3">

        </div>
        <div class="col-md-6">
            <c:forEach items="${chartNames}" var="name">
                <img src="${pageContext.request.contextPath}/asserts/reports/<c:out value="${userName}"/>/${name}"
                     WIDTH="600" HEIGHT="400" BORDER="0" alt="">
            </c:forEach>
            <br>
            <a href="${pageContext.request.contextPath}/asserts/reports/<c:out value="${userName}"/>/<c:out value="${buildName}"/>.docx"
               download>
                <button class="btn btn-block btn-lg btn-primary"><s:message code="result.download"/></button>
            </a>

            <c:if test="${saveBuilding}">
                <a href="${pageContext.request.contextPath}/client/result/save">
                    <button class="btn btn-block btn-lg btn-primary"><s:message code="result.save"/></button>
                </a>
            </c:if>

            <a href="${pageContext.request.contextPath}/client/recalculate">
                <button class="btn btn-block btn-lg btn-primary"><s:message code="result.change"/></button>
            </a>
        </div>
        <div class="col-md-3">

        </div>
    </div>

    <br>
    <br>
    <br>

</div>
