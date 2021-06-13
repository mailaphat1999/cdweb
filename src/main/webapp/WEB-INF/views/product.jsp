<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Products</title>
    <!--/tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <%@ include file="css.jsp" %>
</head>
<body>
<!-- header -->
<jsp:include page="header.jsp"/>
<!-- //header -->

<div class="container">
    <div class="row" style="margin-top: 5vh">
        <div class="col-md-3">
            <div class="card">
                <article class="card-group-item">
                    <header class="card-header"><h3 class="title">Brand </h3></header>
                    <div class="filter-content">
                        <div class="list-group list-group-flush">
                            <c:forEach var="data" items="${brand}">
                                <a href="/product?brand=${data.id}" class="list-group-item"> <c:out value="${data.name}"/> <span class="float-right badge badge-light round"><c:out value="${data.items.size()}"/></span> </a>
                            </c:forEach>
                        </div>
                    </div>
                </article>
            </div>
            <div class="card">
                <article class="card-group-item">
                    <header class="card-header"><h3 class="title">Ram </h3></header>
                    <div class="filter-content">
                        <div class="list-group list-group-flush">
                            <c:forEach var="data" items="${ram}">
                                <a href="/product?ram=${data.id}" class="list-group-item"> <c:out value="${data.content}"/> <span class="float-right badge badge-light round"><c:out value="${data.items.size()}"/></span> </a>
                            </c:forEach>
                        </div>
                    </div>
                </article>
            </div>
            <div class="card">
                <article class="card-group-item">
                    <header class="card-header"><h3 class="title">Rom </h3></header>
                    <div class="filter-content">
                        <div class="list-group list-group-flush">
                            <c:forEach var="data" items="${rom}">
                                <a href="/product?rom=${data.id}" class="list-group-item"> <c:out value="${data.content}"/> <span class="float-right badge badge-light round"><c:out value="${data.items.size()}"/></span> </a>
                            </c:forEach>
                        </div>
                    </div>
                </article>
            </div>
            <div class="card">
                <article class="card-group-item">
                    <header class="card-header"><h3 class="title">Battery </h3></header>
                    <div class="filter-content">
                        <div class="list-group list-group-flush">
                            <c:forEach var="data" items="${battery}">
                                <a href="/product?battery=${data.id}" class="list-group-item"> <c:out value="${data.content}"/> <span class="float-right badge badge-light round"><c:out value="${data.items.size()}"/></span> </a>
                            </c:forEach>
                        </div>
                    </div>
                </article>
            </div>
            <div class="card">
                <article class="card-group-item">
                    <header class="card-header"><h3 class="title">Price </h3></header>
                    <div class="filter-content">
                        <div class="list-group list-group-flush">
                            <c:forEach var="data" items="${price}">
                                <c:if test = "${data.end > data.start}">
                                    <a href="/product?price=${data.id}" class="list-group-item"> <c:out value="${data.start}"/>đ to <c:out value="${data.end}"/>đ <span class="float-right badge badge-light round">${data.items.size()}</span> </a>
                                </c:if>
                                <c:if test = "${data.end < data.start}">
                                    <a href="/product?price=${data.id}" class="list-group-item"> <c:out value="${data.start}"/>đ and above <span class="float-right badge badge-light round">${data.items.size()}</span> </a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </article>
            </div>
        </div>
        <div class="col-md-9">
            <c:forEach var="product" items="${listProduct}">
            <div class="col-md-4 col-sm-6">
                <div class="product-grid2">
                    <div class="product-image2">
                        <a href="/product/detail?id=${product.id}">
                            <img class="pic-1" src="${product.image1}">
                            <img class="pic-2" src="${product.image2}">
                        </a>
                        <ul class="social">
                            <li><a href="/product/detail?id=${product.id}" data-tip="Quick View"><i class="fa fa-eye"></i></a></li>
                            <li><a href="" data-tip="Add to Wishlist"><i class="fa fa-shopping-bag"></i></a></li>
                            <li><a href="" data-tip="Add to Cart"><i class="fa fa-shopping-cart"></i></a></li>
                        </ul>
                    </div>
                    <div class="product-content">
                        <h3 style="height: 36px;" class="title"><a  href="/product/detail?id=${product.id}">${product.name}</a></h3>
                        <span class="price">${product.priceFormat} VNĐ</span>
                    </div>
                </div>
            </div>
            </c:forEach>
            <nav class="col-md-12" aria-label="" style="text-align: center;">
                <ul class="pagination text-center" style="width:auto">
                    <%
                        boolean firstPara = false;
                        if (request.getParameter("ram") != null) firstPara = true;
                        if (request.getParameter("rom") != null) firstPara = true;
                        if (request.getParameter("battery") != null) firstPara = true;
                        if (request.getParameter("brand") != null) firstPara = true;
                        if (request.getParameter("price") != null) firstPara = true;
                        if(firstPara){
                    %>
                    <li class="page-item">
                        <a class="page-link" href="/product${parameter}&page=${currentPage-1 gt 1? currentPage-1: 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="1" end="${maxPage}" var="val">
                        <c:if test="${val eq currentPage}">
                        <li class="page-item"><a style="color: darkgray" class="page-link" href="/product${parameter}&page=${val}">${val}</a></li>
                         </c:if>
                        <c:if test="${val ne currentPage}">
                        <li class="page-item"><a class="page-link" href="/product${parameter}&page=${val}">${val}</a></li>
                        </c:if>
                    </c:forEach>

                    <li class="page-item">
                        <a class="page-link" href="/product${parameter}&page=${currentPage+1 gt maxPage? maxPage: currentPage+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>

                    <%}else{%>
                    <li class="page-item">
                        <a class="page-link" href="/product${parameter}?page=${currentPage-1 gt 1? currentPage-1: 1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="1" end="${maxPage}" var="val">
                        <c:if test="${val eq currentPage}">
                            <li class="page-item"><a style="color: darkgray" class="page-link" href="/product${parameter}?page=${val}">${val}</a></li>
                        </c:if>
                        <c:if test="${val ne currentPage}">
                            <li class="page-item"><a class="page-link" href="/product${parameter}?page=${val}">${val}</a></li>
                        </c:if>
                    </c:forEach>

                    <li class="page-item">
                        <a class="page-link" href="/product${parameter}?page=${currentPage+1 gt maxPage? maxPage: currentPage+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>


                    <%}%>
                </ul>
            </nav>
        </div>
    </div>
</div>
<hr>

<!-- footer -->
<%@ include file="footer.jsp" %>
<!-- //footer -->

<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script src="js/modernizr.custom.js"></script>

<script src="js/easy-responsive-tabs.js"></script>
<script>
    $(document).ready(function () {
        $('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true,   // 100% fit in a container
            closed: 'accordion', // Start closed if in accordion view
            activate: function(event) { // Callback function if tab is switched
                var $tab = $(this);
                var $info = $('#tabInfo');
                var $name = $('span', $info);
                $name.text($tab.text());
                $info.show();
            }
        });
        $('#verticalTab').easyResponsiveTabs({
            type: 'vertical',
            width: 'auto',
            fit: true
        });
    });
</script>
<script src="js/jquery.flexslider.js"></script>
<script>
    $(window).load(function() {
        $('.flexslider').flexslider({
            animation: "slide",
            controlNav: "thumbnails"
        });
    });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
    });
</script>
<script type="text/javascript">
    $(document).ready(function() {
        $().UItoTop({ easingType: 'easeOutQuart' });
    });
</script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</body>
</html>
