<%@ page import="nlu.project.cdweb.entity.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel = "stylesheet" type ="text/css" href="<c:url value = '/css/order.css'/>" />
</head>
<body>
<!-- header -->
<jsp:include page="header.jsp"/>
<!-- //header -->

<c:if test="${user eq null}">

<div class="container-fluid mt-100" style="margin: 10vw 0px;">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-body cart">
                    <div class="col-sm-12 empty-cart-cls text-center"><img src="https://i.imgur.com/dCdflKN.png"
                                                                           width="130" height="130"
                                                                           class="img-fluid mb-4 mr-3">
                        <h3><strong>Your Need Login To CheckOut</strong></h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</c:if>


<c:if test="${user ne null}">
<div class="container">
    <div class="carddata">
        <div class="card-body">
            <div class="row">
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
                <div class="col-md-6">
                    <div class="left--content border">
                        <div class="row"><h2>Payment</h2></div>
                        <form id="customform" action="/order/checkout" method="post"
                              style="max-width: 89%;">
                            <div class="row">
                                <div class="col-4">
                                    <input name="iduser" type="hidden" value="${user.id}">
                                    <span class="mycustomspan">Receiver</span> <input name="name" class="inputcustom"
                                                                                      placeholder="Receiver"
                                                                                      value="${user.name}">
                                    <span class="mycustomspan">Phone</span> <input name="phone" class="inputcustom"
                                                                                   placeholder="Phone Number"
                                                                                   value="${user.phone}">
                                    <span class="mycustomspan">Address:</span> <textarea name="address" cols="52"
                                                                                         rows="5"
                                                                                         placeholder="Address">${user.address}</textarea>
                                </div>
                                <div class="col-4"></div>
                            </div>
                            <div class="row">
                                <input type="checkbox" id="save_card" class="align-left"> <label for="save_card">I agree
                                terms and conditions of website</label>
                            </div>
                            <div class="row">
                                <button type="submit" class="checkoutbtn">Place order</button>
                                <p class="text-muted text-center">Complimentary Shipping & Returns</p>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-6" style="border: 3px solid #22bb33;">
                    <div class="rightdata border">
                        <h2>Order Summary</h2>
                        <h3> Items: ${cart.size()}
                        </h3>

                        <c:forEach var="detail" items="${cart.details}">
                        <div class="row cartitemdata">
                            <div class="col-4"></div>
                            <div class="col-8"></div>
                        </div>
                        <div class="row cartitemdata">
                            <div class="col-4"><img class="img-fluid-data"
                                                    src="${detail.value.product.image1}">
                            </div>
                            <div class="col-8">
                                <div class="detailorderdatadata"><b>${detail.value.product.priceFormat}
                                </b></div>
                                <div class="detailorderdata">${detail.value.product.name}
                                </div>
                                <div class="detailorderdata">Qty: ${detail.value.quatity}
                                </div>
                            </div>
                        </div>
                        <hr>
                        </c:forEach>

                        <div class="row lowerdata" style="">
                            <div class="totalpricedata">
                                <b>Total to pay</b>
                                <br/>
                                <b> ${cart.updateTotal()}
                            </div>
                        </div>
                    </div>
                </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
</c:if>
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
