<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
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
    <div class="row masonry" data-columns>
        <div class="item">
            <div class="thumbnail">
                <a href="${pageContext.request.contextPath}/client/history"><img
                        src="${pageContext.request.contextPath}/asserts/images/buildings.png" alt=""/></a>
                <div class="caption">
                    <h3><a href="${pageContext.request.contextPath}/client/history"><s:message
                            code="functions.history"/></a></h3>
                    <p><s:message code="functions.history.discription"/></p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnail">
                <a href="${pageContext.request.contextPath}/client/calculate"><img
                        src="${pageContext.request.contextPath}/asserts/images/calculate.png" alt=""/></a>
                <div class="caption">
                    <h3><a href="${pageContext.request.contextPath}/client/calculate"><s:message
                            code="functions.calculation"/></a></h3>
                    <p><s:message code="functions.calculation.discription"/></p>
                </div>
            </div>
        </div>

        <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')">
            <div class="item">
                <div class="thumbnail">
                    <a href="${pageContext.request.contextPath}/admin/materials"><img
                            src="${pageContext.request.contextPath}/asserts/images/substances.png" alt=""/></a>
                    <div class="caption">
                        <h3><a href="${pageContext.request.contextPath}/admin/materials"><s:message
                                code="functions.substances"/></a></h3>
                        <p><s:message code="functions.substances.discription"/></p>
                    </div>
                </div>
            </div>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_SUPER_ADMIN')">
            <div class="item">
                <div class="thumbnail">
                    <a href="${pageContext.request.contextPath}/moder/registration"><img
                            src="${pageContext.request.contextPath}/asserts/images/register.png" alt=""/></a>
                    <div class="caption">
                        <h3><a href="${pageContext.request.contextPath}/moder/registration"><s:message
                                code="functions.register"/></a></h3>
                        <p><s:message code="functions.register.discription"/></p>
                    </div>
                </div>
            </div>
        </sec:authorize>
    </div>

    <br/>
    <br/>
    <br/>

</div>