<%@ page import="nlu.project.cdweb.entity.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <!--/tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <%@ include file="css.jsp" %>
    <link rel="stylesheet" type="text/css" href="<c:url value = '/css/cart.css'/>"/>
</head>
<body>
<!-- header -->
<jsp:include page="header.jsp"/>
<!-- //header -->

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <c:if test="${cart.size() lt 1}">
                    <div class="container-fluid mt-100" style="margin: 10vw 0px;">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-body cart">
                                        <div class="col-sm-12 empty-cart-cls text-center"><img
                                                src="https://i.imgur.com/dCdflKN.png" width="130" height="130"
                                                class="img-fluid mb-4 mr-3">
                                            <h3><strong>Your Cart is Empty</strong></h3>
                                            <h4>Add something to make me happy :)</h4> <a
                                                    href="/product"
                                                    class="btn btn-success cart-btn-transform m-3" data-abc="true">continue
                                                shopping</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${cart.size() ge 1}">
                    <table class="table table-image">
                        <thead>
                        <tr>
                            <th scope="col">Product</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Qty</th>
                            <th scope="col">Total</th>
                            <th scope="col">Actions</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="detail" items="${cart.details}">

                            <tr>
                                <td class="col-md-3">
                                    <img src="${detail.value.product.image1}" class="img-fluid img-thumbnail"
                                         alt="Sheep">
                                </td>
                                <td>${detail.value.product.name}</td>
                                <td class="dataPrice">${detail.value.product.price}</td>
                                <td id="qty"><input name="dataQuanlity" onchange="update()" type="text"
                                                    class="form-control"
                                                    id="input1" value="${detail.value.quatity}"></td>
                                <td class="dataTotal">${detail.value.total}</td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/cart/remove?id=${detail.value.product.id}"
                                          method="post">
                                        <input type="hidden" name="locate" value="<%= request.getRequestURL() %>"/>
                                        <button type="submit" class="btn btn-danger">
                                            <i class="fa fa-times"></i>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="d-flex justify-content-end" style="width: 32%;float: right; margin-bottom: 2vw;">
                        <h3>Sub Total:
                            <div id="subtotal" style="float: right;" class="price text-success">
                                <b>${cart.updateTotal()}</b>
                            </div>
                        </h3>
                        <br/>
                        <h3>Estimated Shipping:
                            <div style="float: right;" class="price text-success"><b>10000</b></div>
                        </h3>
                        <br/>
                        <h3>Total:
                            <div id="carttotal" style="float: right;margin-bottom: 8px" class="price text-success">
                                <b>${cart.updateTotal()+10000}</b></div>
                        </h3>
                        <br/>
                        <a type="button" onclick="clear();" class="btn btn-warning">Clear Cart</a>
                        <a type="button" style="float: right;" href="/order"
                           class="btn btn-success">Check Out</a>
                    </div>
                </c:if>
            </table>
        </div>
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
<script src="js/jquery.flexslider.js"></script>
<script>
    $(window).load(function () {
        $('.flexslider').flexslider({
            animation: "slide",
            controlNav: "thumbnails"
        });
    });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $(".scroll").click(function (event) {
            event.preventDefault();
            $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
        });
    });
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $().UItoTop({easingType: 'easeOutQuart'});
    });
</script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
<script type="text/javascript" src="js/myValidation/customRule.js"></script>
<script type="text/javascript" src="js/myValidation/headerForm.js"></script>
</body>
</html>
