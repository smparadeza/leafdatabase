<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Leaf Database</title>

  <!-- Bootstrap -->
  <spring:url value="/resources/core/css/bootstrap.css" var="bootstrapCss"/>
  <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapMinCss"/>

  <spring:url value="/resources/core/css/bootstrap-theme.css" var="bootstrapThemeCss"/>
  <spring:url value="/resources/core/css/bootstrap-theme.min.css" var="bootstrapThemeMinCss"/>

  <spring:url value="/resources/core/css/view_leaf.css" var="viewleaf"/>
  <spring:url value="/resources/core/js/bootstrap.js" var="bootstrapJs"/>
  <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapMinJs"/>
  <spring:url value="/resources/core/js/jquery.min.js" var="jqueryJs"/>
  <spring:url value="/resources/images/loader.GIF" var="loader"/>
  <link href="${bootstrapCss}" rel="stylesheet"/>
  <link href="${bootstrapMinCss}" rel="stylesheet"/>
  <link href="${bootstrapThemeCss}" rel="stylesheet"/>
  <link href="${bootstrapThemeMinCss}" rel="stylesheet"/>
  <link href="${viewleaf}" rel="stylesheet"/>


  <script src="${jqueryJs}" type="text/javascript"></script>

  <script src="${bootstrapJs}" type="text/javascript"></script>
  <script src="${bootstrapMinJs}" type="text/javascript"></script>


</head>
<body>
<c:set var="req" value="${pageContext.request}"/>
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}"/>

<nav class="navbar navbar-inverse navbar-fixed">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
              aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Leaf Database</a>
    </div>

  </div>
</nav>

