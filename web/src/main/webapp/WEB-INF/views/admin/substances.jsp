<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="buildings" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="error" class="java.lang.String" scope="request"/>

<s:message var="newMaterial" code="material.new"/>
<s:message var="name" code="material.name"/>
<s:message var="air" code="material.air"/>
<s:message var="heat" code="material.heat"/>
<s:message var="speed" code="material.speed"/>
<s:message var="send" code="material.send"/>
<s:message var="size" code="material.change.size"/>
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
    <s:url value="/admin/materials/edit" var="formUrl"/>
    <form class="center-block" action="${formUrl}" method="POST">

        <div class="row">

            <div class="col-md-6">

                <div id="accordion" class="panel-group">
                    <c:forEach items="${leftSubstances}" var="sub">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a href="#collapse-${sub.id}" data-parent="#accordion"
                                       data-toggle="collapse">${sub.nameOfSubstance}</a>
                                </h4>
                            </div>
                            <div id="collapse-${sub.id}" class="panel-collapse collapse">
                                <div class="panel-body">

                                    <input type="hidden" name="idSubstance" value="${sub.id}">

                                    <div class="form-group">
                                        <label>${name}</label>
                                        <input type="text" name="nameOfSubstance" class="form-control"
                                               placeholder="${name}" value="${sub.nameOfSubstance}">
                                    </div>
                                    <div class="form-group">
                                        <label>${air}</label><br>
                                        <input type="text" name="amountOfCombustionAir" class="form-control"
                                               placeholder="${air}" value="${sub.amountOfCombustionAir}">
                                    </div>
                                    <div class="form-group">
                                        <label>${heat}</label>
                                        <input type="text" name="combustionHeat" class="form-control"
                                               placeholder="${heat}" value="${sub.combustionHeat}">
                                    </div>
                                    <div class="form-group">
                                        <label>${speed}</label>
                                        <input type="text" name="averageSpeedBurnout" class="form-control"
                                               placeholder="${speed}" value="${sub.averageSpeedBurnout}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
            <div class="col-md-6">
                <div id="accordion2" class="panel-group">
                    <c:forEach items="${rightSubstances}" var="sub">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a href="#collapse-${sub.id}" data-parent="#accordion2"
                                       data-toggle="collapse">${sub.nameOfSubstance}</a>
                                </h4>
                            </div>
                            <div id="collapse-${sub.id}" class="panel-collapse collapse">
                                <div class="panel-body">

                                    <input type="hidden" name="idSubstance" value="${sub.id}">

                                    <div class="form-group">
                                        <label>${name}</label>
                                        <input type="text" name="nameOfSubstance" class="form-control"
                                               placeholder="${name}" value="${sub.nameOfSubstance}">
                                    </div>
                                    <div class="form-group">
                                        <label>${air}</label><br>
                                        <input type="text" name="amountOfCombustionAir" class="form-control"
                                               placeholder="${air}" value="${sub.amountOfCombustionAir}">
                                    </div>
                                    <div class="form-group">
                                        <label>${heat}</label>
                                        <input type="text" name="combustionHeat" class="form-control"
                                               placeholder="${heat}" value="${sub.combustionHeat}">
                                    </div>
                                    <div class="form-group">
                                        <label>${speed}</label>
                                        <input type="text" name="averageSpeedBurnout" class="form-control"
                                               placeholder="${speed}" value="${sub.averageSpeedBurnout}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
            </div>
            <!--Поля для нового материала-->

            <div class="col-md-8">
                <div id="accordion3" class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#collapse-0" data-parent="#accordion3"
                                   data-toggle="collapse">${newMaterial}</a>
                            </h4>
                        </div>
                        <div id="collapse-0" class="panel-collapse collapse">
                            <div class="panel-body">

                                <input type="hidden" name="idSubstance">

                                <div class="form-group">
                                    <label>${name}</label>
                                    <input type="text" name="nameOfSubstance" class="form-control"
                                           placeholder="${name}">
                                </div>
                                <div class="form-group">
                                    <label>${air}</label><br>
                                    <input type="text" name="amountOfCombustionAir" class="form-control"
                                           placeholder="${air}">
                                </div>
                                <div class="form-group">
                                    <label>${heat}</label>
                                    <input type="text" name="combustionHeat" class="form-control"
                                           placeholder="${heat}">
                                </div>
                                <div class="form-group">
                                    <label>${speed}</label>
                                    <input type="text" name="averageSpeedBurnout" class="form-control"
                                           placeholder="${speed}">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" onclick="validateSubstance()"
                           class="btn btn-block btn-primary"
                           value="${send}">
                </div>
            </div>

            <div class="col-md-2">
            </div>
        </div>

        <input type="hidden" name="amountOfSubstances" value="<c:out value="${amountOfSubstances}"/>">
        <input type="hidden" name="page" value="<c:out value="${page}"/>">
    </form>


    <div class="row">
        <div class="center-block">

            <c:if test="${previousPage!=0}">
                <a href="${pageContext.request.contextPath}/admin/materials?page=${previousPage}">
                    <img src="${pageContext.request.contextPath}/asserts/images/leftArrow.png" WIDTH="20" HEIGHT="20"
                         BORDER="0"></a>
            </c:if>

            <c:if test="${showFirstPage==true}">
                <a href="${pageContext.request.contextPath}/admin/materials?page=1">
                    <button class="btn btn-default">1</button>
                </a>
            </c:if>

            <c:if test="${showFirstDots==true}">
                <span>...</span>
            </c:if>

            <c:forEach items="${beforeThisPage}" var="number">
                <a href="${pageContext.request.contextPath}/admin/materials?page=${number}">
                    <button class="btn btn-default">${number}</button>
                </a>
            </c:forEach>

            <button class="btn btn-danger">${page}</button>

            <c:forEach items="${afterThisPage}" var="number">
                <a href="${pageContext.request.contextPath}/admin/materials?page=${number}">
                    <button class="btn btn-default">${number}</button>
                </a>
            </c:forEach>

            <c:if test="${showLastDots==true}">
                <span>...</span>
            </c:if>

            <c:if test="${showLastPage==true}">
                <a href="${pageContext.request.contextPath}/admin/materials?page=${countOfPages}">
                    <button class="btn btn-default">${countOfPages}</button>
                </a>
            </c:if>

            <c:if test="${nextPage!=0}">
                <a href="${pageContext.request.contextPath}/admin/materials?page=${nextPage}">
                    <img src="${pageContext.request.contextPath}/asserts/images/rightArrow.png" WIDTH="20" HEIGHT="20"
                         BORDER="0"></a>
            </c:if>

            <span class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <button class="btn btn-primary">${size}</button><b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/setsize?paginationSize=2">2</a></li>
                    <li><a href="${pageContext.request.contextPath}/setsize?paginationSize=10">10</a></li>
                    <li><a href="${pageContext.request.contextPath}/setsize?paginationSize=20">20</a></li>
                    <li><a href="${pageContext.request.contextPath}/setsize?paginationSize=40">40</a></li>
                </ul>
            </span>
            <br>
            <br>
        </div>
    </div>
    <br>
    <br>
    <br>
</div>