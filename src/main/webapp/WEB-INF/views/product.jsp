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
<%--<jsp:include page="header.jsp"/>--%>
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
                                <a href="" class="list-group-item"> <c:out value="${data.name}"/> <span class="float-right badge badge-light round"><c:out value="${data.items.size()}"/></span> </a>
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
                                <a href="" class="list-group-item"> <c:out value="${data.content}"/> <span class="float-right badge badge-light round"><c:out value="${data.items.size()}"/></span> </a>
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
                                <a href="" class="list-group-item"> <c:out value="${data.content}"/> <span class="float-right badge badge-light round"><c:out value="${data.items.size()}"/></span> </a>
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
                                <a href="" class="list-group-item"> <c:out value="${data.content}"/> <span class="float-right badge badge-light round"><c:out value="${data.items.size()}"/></span> </a>
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
                                    <a href="" class="list-group-item"> <c:out value="${data.start}"/>đ to <c:out value="${data.end}"/>đ <span class="float-right badge badge-light round">${data.items.size()}</span> </a>
                                </c:if>
                                <c:if test = "${data.end < data.start}">
                                    <a href="" class="list-group-item"> <c:out value="${data.start}"/>đ and above <span class="float-right baVNĐdge badge-light round">${data.items.size()}</span> </a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </article>
            </div>
        </div>
        <div class="col-md-9">
            <div class="col-md-4 col-sm-6">
                <div class="product-grid2">
                    <div class="product-image2">
                        <a href="">
                            <img class="pic-1" src="">
                            <img class="pic-2" src="">
                        </a>
                        <ul class="social">
                            <li><a href="" data-tip="Quick View"><i class="fa fa-eye"></i></a></li>
                            <li><a href="" data-tip="Add to Wishlist"><i class="fa fa-shopping-bag"></i></a></li>
                            <li><a href="" data-tip="Add to Cart"><i class="fa fa-shopping-cart"></i></a></li>

                        </ul>
                    </div>
                    <div class="product-content">
                        <h3 class="title"><a href=""></a></h3>
                        <span class="price">VNĐ</span>
                    </div>
                </div>
            </div>

            <nav class="col-md-12" aria-label="" style="text-align: center;">
                <ul class="pagination text-center" style="width:auto">

                    <li class="page-item">
                        <a class="page-link" href="" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="">1</a></li>
                    <li class="page-item"><a class="page-link" href="">2</a></li>
                    <li class="page-item">
                        <a class="page-link" href="" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<hr>

<!-- footer -->
<%@ include file="footer.jsp" %>
<!-- //footer -->
<script type="text/javascript" src="./js/jquery-2.1.4.min.js"></script>
<!-- for bootstrap working -->

<a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover"
                                                                         style="opacity: 1;"> </span></a>

<script src="./js/modernizr.custom.js"></script>
<!-- Custom-JavaScript-File-Links -->

<!-- script for responsive tabs -->
<script src="./js/easy-responsive-tabs.js"></script>
<script>
    $(document).ready(function () {
        $('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true,   // 100% fit in a container
            closed: 'accordion', // Start closed if in accordion view
            activate: function (event) { // Callback function if tab is switched
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
<!-- //script for responsive tabs -->
<!-- stats -->
<script src="./js/jquery.waypoints.min.js"></script>
<script src="./js/jquery.countup.js"></script>
<script>
    $('.counter').countUp();
</script>
<!-- //stats -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="./js/move-top.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $(".scroll").click(function (event) {
            event.preventDefault();
            $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
        });
    });
</script>
<!-- here stars scrolling icon -->
<script type="text/javascript">
    $(document).ready(function () {
        $().UItoTop({easingType: 'easeOutQuart'});
    });
</script>
<!-- //here ends scrolling icon -->
<script type="text/javascript" src="./js/bootstrap.js"></script>

</body>
</html>