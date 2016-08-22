<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <c:forEach var="img" items="${images}" varStatus="stat">
        <img class="leaf-img" width="100px" height="100px" src="/resources/images/leaves/${img}"  data-toggle="popover" data-placement="auto top" data-content=""/>
    </c:forEach>
</div>

<script>
  $(document).ready(function(){
    $('.leaf-img').hover(function(){
      var src = $(this).attr("src");
      $(this).attr("data-content", '<img width="250px" src="'.concat(src, '"/>'));
    });
    $('.leaf-img').popover({trigger:'hover', html:true});
  });
</script>