<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "th" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
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

<!-- banner -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <%--    stylecss:580--%>
    <ol class="carousel-indicators">
        <% int slideTo = 0;%>
        <c:set var="active" value="false"/>
        <c:forEach var="slider" items="${carousel}">
        <c:if test="${active eq false}">
            <li data-target="#myCarousel" data-slide-to="<%=slideTo%>" class="active"></li>
        </c:if>
        <c:if test="${active eq true}">
            <li data-target="#myCarousel" data-slide-to="<%=slideTo%>" class=""></li>
        </c:if>
            <c:set var="active" value="true"/>
            <% slideTo++;%>
</c:forEach>



    </ol>
    <div class="carousel-inner" role="listbox">
        <c:set var="active" value="false"/>
        <c:forEach var="slider" items="${carousel}">
            <c:if test="${active eq false}">
            <div class="item active" style='background:linear-gradient(rgba(23, 22, 23, 0.2), rgba(23, 22, 23, 0.5)), url(<c:out value="${slider.image}"/>) no-repeat;
	                                    background-size:cover;'>
                <div class="container">
                    <div class="carousel-caption">
<%--                        <h3>The Biggest <span>Sale</span></h3><p>Special for today</p><a class="hvr-outline-out button2" href="mens.html">Shop Now </a>--%>
                    </div>
                </div>
            </div>

            </c:if>
            <c:if test="${active eq true}">
                <div class="item item2" style='background:linear-gradient(rgba(23, 22, 23, 0.2), rgba(23, 22, 23, 0.5)), url(<c:out value="${slider.image}"/>) no-repeat;
                        background-size:cover;'>
                    <div class="container">
                        <div class="carousel-caption">
                                <%--                        <h3>The Biggest <span>Sale</span></h3><p>Special for today</p><a class="hvr-outline-out button2" href="mens.html">Shop Now </a>--%>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:set var="active" value="true"/>

    </c:forEach>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="schedule-bottom">
    <div class="col-md-6 agileinfo_schedule_bottom_left">

        <img src="${bottom.get(0).image}" alt="" class="img-responsive" style="height:70.5vh "/>

    </div>
    <div class="col-md-6 agileits_schedule_bottom_right">
        <div class="w3ls_schedule_bottom_right_grid">
            <h3>Save up to <span>50%</span> in this week</h3>
            <p>Suspendisse varius turpis efficitur erat laoreet dapibus.
                Mauris sollicitudin scelerisque commodo.Nunc dapibus mauris sed metus finibus posuere.</p>


            <div class="col-md-4 w3l_schedule_bottom_right_grid1">
                <i class="fa fa-shield" aria-hidden="true"></i>
                <h4>Products</h4>
                <h5 class="counter">${countProduct}</h5>
            </div>
            <div class="col-md-4 w3l_schedule_bottom_right_grid1">
                <i class="fa fa-calendar-o" aria-hidden="true"></i>
                <h4>Events</h4>
                <h5 class="counter">${countSale}</h5>
            </div>
            <div class="col-md-4 w3l_schedule_bottom_right_grid1">
                <i class="fa fa-user-o" aria-hidden="true"></i>
                <h4>Users</h4>
                <h5 class="counter">${countUser}</h5>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
<!-- //schedule-bottom -->
<!-- banner-bootom-w3-agileits -->

<div class="new_arrivals_agile_w3ls_info">
    <div class="container">
        <h3 class="wthree_text_info">New <span>Arrivals</span></h3>
        <div id="horizontalTab">
            <ul class="resp-tabs-list">
                <li> New</li>
                <li> Hot</li>
                <li> Sale</li>
                <li> Other</li>
            </ul>
            <div class="resp-tabs-container">
                <!--/tab_one-->
                <div class="tab1">
                    <c:forEach var="product" items="${newProduct}">
                    <div class="col-md-3 product-men">
                        <div class="men-pro-item simpleCart_shelfItem">
                            <div class="men-thumb-item">
                                <img src="${product.image1}" class="pro-image-front">
                                <img src="${product.image2}"  class="pro-image-back">
                                <div class="men-cart-pro">
                                    <div class="inner-men-cart-pro">
                                        <a href="" class="link-product-add-cart">Quick View</a>
                                    </div>
                                </div>
                                <span class="product-new-top">New</span>
                            </div>
                            <div class="item-info-product" style="margin-top:-9px">

                                <h4><a href="/product/detail?id=${product.id}">${product.name}</a></h4>
                                <div class="info-product-price">
                                    <span class="item_price">${product.priceFormat}</span>
                                </div>
                                <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                                    <form action="" method="post">
                                        <input type="submit" name="submit" value="Add to cart" class="button"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    <div class="col-md-12">
                        <button class="btn btn-success moreproduct" onclick="" type="button">
                            View More Product</button>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <!--//tab_one-->
                <!--/tab_two-->
                <div class="tab2">

                    <c:forEach var="product" items="${hotProduct}">
                        <div class="col-md-3 product-men">
                            <div class="men-pro-item simpleCart_shelfItem">
                                <div class="men-thumb-item">
                                    <img src="${product.image1}" class="pro-image-front">
                                    <img src="${product.image2}"  class="pro-image-back">
                                    <div class="men-cart-pro">
                                        <div class="inner-men-cart-pro">
                                            <a href="" class="link-product-add-cart">Quick View</a>
                                        </div>
                                    </div>
                                    <span class="product-new-top">Hot</span>
                                </div>
                                <div class="item-info-product" style="margin-top:-9px">

                                    <h4><a href="detail?id=">${product.name}</a></h4>
                                    <div class="info-product-price">
                                        <span class="item_price">${product.priceFormat}</span>
                                    </div>
                                    <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                                        <form action="" method="post">
                                            <input type="submit" name="submit" value="Add to cart" class="button"/>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="col-md-12">
                        <button class="btn btn-success moreproduct" onclick="" type="button">
                            View More Product</button>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <!--//tab_two-->
                <div class="tab3">

                    <c:forEach var="product" items="${saleProduct}">
                        <div class="col-md-3 product-men">
                            <div class="men-pro-item simpleCart_shelfItem">
                                <div class="men-thumb-item">
                                    <img src="${product.image1}" class="pro-image-front">
                                    <img src="${product.image2}"  class="pro-image-back">
                                    <div class="men-cart-pro">
                                        <div class="inner-men-cart-pro">
                                            <a href="" class="link-product-add-cart">Quick View</a>
                                        </div>
                                    </div>
                                    <span class="product-new-top">Sale</span>
                                </div>
                                <div class="item-info-product" style="margin-top:-9px">

                                    <h4><a href="detail?id=">${product.name}</a></h4>
                                    <div class="info-product-price">
                                        <span class="item_price">${product.priceFormat}</span>
                                    </div>
                                    <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                                        <form action="" method="post">
                                            <input type="submit" name="submit" value="Add to cart" class="button"/>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="col-md-12">
                        <button class="btn btn-success moreproduct" onclick="location.href='product?status=3'" type="button">
                            View More Product</button>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="tab4">

                    <c:forEach var="product" items="${otherProduct}">
                        <div class="col-md-3 product-men">
                            <div class="men-pro-item simpleCart_shelfItem">
                                <div class="men-thumb-item">
                                    <img src="${product.image1}" class="pro-image-front">
                                    <img src="${product.image2}"  class="pro-image-back">
                                    <div class="men-cart-pro">
                                        <div class="inner-men-cart-pro">
                                            <a href="" class="link-product-add-cart">Quick View</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="item-info-product" style="margin-top:-9px">

                                    <h4><a href="detail?id=">${product.name}</a></h4>
                                    <div class="info-product-price">
                                        <span class="item_price">${product.priceFormat}</span>
                                    </div>
                                    <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                                        <form action="" method="post">
                                            <input type="submit" name="submit" value="Add to cart" class="button"/>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="col-md-12">
                        <button class="btn btn-success moreproduct" onclick="location.href='product?status=0'" type="button">
                            View More Product</button>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- //new_arrivals -->
<!-- /we-offer -->

<div class="sale-w3ls" style= "background: url(${foot.get(0).image})no-repeat 0px 0px;background-attachment: fixed;background-size: cover;min-height:380px;">
    <div class="container">
        <h6 style="color: black">We Offer Flat 40% Discount</h6>

        <a class="hvr-outline-out button2" href="product">Shop Now </a>
    </div>
</div>

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
