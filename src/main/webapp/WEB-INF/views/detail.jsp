<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Detail</title>
    <!--/tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <%@ include file="css.jsp" %>
    <link rel = "stylesheet" type ="text/css" href="<c:url value = '/css/detail.css'/>" />
</head>
<body>
<!-- header -->
<%--<jsp:include page="header.jsp"/>--%>
<!-- //header -->


<div class="banner-bootom-w3-agileits">
    <div class="container">
        <div class="col-md-5 single-right-left ">
            <div class="grid images_3_of_2">
                <div class="flexslider">
                    <ul class="slides">
                        <li data-thumb="${pageContext.request.contextPath}/${product.image1}">
                            <div class="thumb-image"><img src="${pageContext.request.contextPath}/${product.image1}" data-imagezoom="true"
                                                          class="img-responsive"></div>
                        </li>
                        <li data-thumb="${pageContext.request.contextPath}/${product.image2}">
                            <div class="thumb-image"><img src="${pageContext.request.contextPath}/${product.image2}" data-imagezoom="true"
                                                          class="img-responsive"></div>
                        </li>
                        <li data-thumb="${pageContext.request.contextPath}/${product.image3}">
                            <div class="thumb-image"><img src="${pageContext.request.contextPath}/${product.image3}" data-imagezoom="true"
                                                          class="img-responsive"></div>
                        </li>
                        <li data-thumb="${pageContext.request.contextPath}/${product.image4}">
                            <div class="thumb-image"><img src="${pageContext.request.contextPath}/${product.image4}" data-imagezoom="true"
                                                          class="img-responsive"></div>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class="col-md-7 single-right-left simpleCart_shelfItem">
            <h3>${product.name}</h3>
            <p><span class="item_price">${product.priceFormat}</span>
                <%--                <del>- $900</del>--%>
            </p>
            <p><span class="item_price">Front Camera: ${product.frontCam} </span></p>
            <p><span class="item_price">Rear Camera: ${product.rearCam} </span></p>
            <p><span class="item_price">Rom: ${product.rom.content}</span></p>
            <p><span class="item_price">Ram: ${product.ram.content}</span></p>
            <p><span class="item_price">Screen: ${product.screen}</span></p>
            <c:if test="${product.storage lt 0}">
            <p><span class="item_price">Storage: ${product.storage}</span></p>
            </c:if>
<c:if test="${product.storage eq 0}">
            <p><span class="item_price">Storage: Sold Out</span></p>
</c:if>
            <p><span class="item_price">Quanlity <input class="mycartquantity" name="quantity" type="number" min="1" max="<c:out value="${product.storage}"/>" value="1" autocomplete="off"></span></p>

            <div class="occasion-cart">
                <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                    <form action="" method="post">
                        <fieldset>
                            <input type="submit" name="submit" value="Add to cart" class="button cartbutton">
                            <span class="fa fa-shopping-cart carticondata"></span>
                        </fieldset>
                    </form>
                </div>
            </div>

            <div class="occasion-cart">
                <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                    <form action="" method="post">
                        <fieldset>
                            <input type="hidden" name="id" value="1">
                            <input type="submit" name="submit" value="Wishlist" class="button cartbutton">
                            <span class="fa fa-heart lovedicondata"></span>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
        <!-- /new_arrivals -->
        <div class="responsive_tabs_agileits">
            <div id="horizontalTab">
                <ul class="resp-tabs-list">
                    <li>Information</li>
                    <li>Description</li>
                    <li>Reviews</li>
                </ul>
                <div class="resp-tabs-container">
                    <!--/tab_one-->
                    <div class="tab1">

                        <div class="single_page_agile_its_w3ls">
                            <table class="table">
                                <tbody>
                                <tr class="active">
                                    <td>Name</td>
                                    <td>${product.name}</td>
                                </tr>
                                <tr>
                                    <td>Brand</td>
                                    <td>${product.brand.name}</td>
                                </tr>
                                <tr class="active">
                                    <td>Storage</td>
                                    <td>${product.storage}</td>
                                </tr>
                                <tr>
                                    <td>OS</td>
                                    <td>Android</td>
                                </tr>
                                <tr class="active">
                                    <td>Rom</td>
                                    <td>${product.rom.content}</td>
                                </tr>
                                <tr>
                                    <td>Ram</td>
                                    <td>${product.ram.content}</td>
                                </tr>
                                <tr class="active">
                                    <td>Battery</td>
                                    <td>${product.battery.content}</td>
                                </tr>
                                <tr>
                                    <td>Guarantee</td>
                                    <td>${product.guarantee}</td>
                                </tr>
                                <tr class="active">
                                    <td>Screen</td>
                                    <td>${product.screen}</td>
                                </tr>
                                <tr>
                                    <td>Front Camera</td>
                                    <td>${product.frontCam}</td>
                                </tr>
                                <tr class="active">
                                    <td>Rear Camera</td>
                                    <td>${product.rearCam}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!--//tab_one-->
                    <div class="tab2">
                        <div class="single_page_agile_its_w3ls">
                            <h6>${product.description.title1}</h6>
                            <p>${product.description.detail1}</p>
                            <img style="width: 80%" src="${pageContext.request.contextPath}/${product.description.image1}"/>
                            <h6>${product.description.title2}</h6>
                            <p>${product.description.detail2}</p>
                            <img style="width: 80%" src="${pageContext.request.contextPath}/${product.description.image2}"/>
                            <h6>${product.description.title3}</h6>
                            <p>${product.description.detail3}</p>
                            <img style="width: 80%" src="${pageContext.request.contextPath}/${product.description.image3}"/>
                        </div>
                    </div>
                    <div class="tab3">
                        <div class="single_page_agile_its_w3ls">
                            <div class="bootstrap-tab-text-grids">
                                <div class="bootstrap-tab-text-grid">
                                    <div class="bootstrap-tab-text-grid-left">
                                        <img src="${pageContext.request.contextPath}/images/user/1.gif" alt=" " class="img-responsive">
                                    </div>
                                    <div class="bootstrap-tab-text-grid-right">
                                        <ul>
                                            <li><a href="#">Admin</a></li>
                                            </li>
                                        </ul>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elPellentesque vehicula
                                            augue eget.Ut enim ad minima veniam, quis nostrum exercitationem ullam
                                            corporis
                                            suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem
                                            vel eum iure reprehenderit.</p>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="add-review">
                                    <h4>add a review</h4>
                                    <form action="#" method="post">
                                        <input type="text" name="Name" required="Name">
                                        <input type="email" name="Email" required="Email">
                                        <textarea name="Message" required=""></textarea>
                                        <input type="submit" value="SEND">
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- //new_arrivals -->
        <!--/slider_owl-->

        <div class="w3_agile_latest_arrivals">
            <h3 class="wthree_text_info">Featured <span>Arrivals</span></h3>
            <c:forEach var="i" begin="0" end="7" step="1" varStatus="loop">


                <div class="col-md-3 product-men single">
                    <div class="men-pro-item simpleCart_shelfItem">
                        <div class="men-thumb-item">
                            <img src="${pageContext.request.contextPath}/${related.get(loop.end - i + loop.begin).image1}" alt="" class="pro-image-front">
                            <img src="${pageContext.request.contextPath}/${related.get(loop.end - i + loop.begin).image2}" alt="" class="pro-image-back">
                            <div class="men-cart-pro">
                                <div class="inner-men-cart-pro">
                                    <a href="" class="link-product-add-cart">Quick View</a>
                                </div>
                            </div>
                        </div>
                        <div class="item-info-product ">
                            <h4><a href="">${related.get(loop.end - i + loop.begin).name}</a></h4>
                            <div class="info-product-price">
                                <span class="item_price">${related.get(loop.end - i + loop.begin).priceFormat}</span>
                            </div>
                            <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                                <form action="#" method="post">
                                    <fieldset>
                                        <input type="submit" name="submit" value="Add to cart" class="button">
                                    </fieldset>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </c:forEach>

            <div class="clearfix"></div>

            <!--//slider_owl-->
        </div>
    </div>
</div>

<!-- footer -->
<%@ include file="footer.jsp" %>
<!-- //footer -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/modernizr.custom.js"></script>

<script src="${pageContext.request.contextPath}/js/imagezoom.js"></script>
<script src="${pageContext.request.contextPath}/js/easy-responsive-tabs.js"></script>
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
<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
<script>
    $(window).load(function() {
        $('.flexslider').flexslider({
            animation: "slide",
            controlNav: "thumbnails"
        });
    });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js"></script>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

</body>
</html>
