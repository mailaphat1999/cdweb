<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <!--/tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <link rel="stylesheet" type="text/css" href="<c:url value = '/css/myProfile.css'/>"/>
    <%@ include file="css.jsp" %>
</head>
<body>
<!-- header -->
<%--<jsp:include page="header.jsp"/>--%>
<!-- //header -->

<div class="container bootstrap snippet" style="margin-top: 8vh;margin-bottom: 5vh">
    <div class="row">
        <div class="col-sm-3"><!--left col-->
            <div class="text-center">
                <img src="${user.image}" class="avatar img-circle img-thumbnail" style="width: 65%;max-height: 14vw;"
                     alt="avatar">
                <h5>Upload Avatar</h5>
                <input type="file" class="text-center center-block file-upload">
            </div>
            <br>

            <ul class="list-group">
                <li class="list-group-item text-muted" style="text-align: center"><span
                        style="font-size: 20px">Activity </span></li>
                <li class="list-group-item text-right"><span
                        class="pull-left"><strong>Product Buyed</strong></span> ${user.totalBuy}</li>
                <li class="list-group-item text-right"><span
                        class="pull-left"><strong>Product Loved</strong></span> ${user.wishLists.size()}</li>
                <li class="list-group-item text-right"><span
                        class="pull-left"><strong>Order</strong></span> ${user.orders.size()} </li>
            </ul>

        </div>
        <!--/col-3-->
        <div class="col-sm-8 custompanel">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#userinfo">Info</a></li>
                <li><a data-toggle="tab" href="#userpassword">Password</a></li>
                <li><a data-toggle="tab" href="#wishlist">Wish List</a></li>
                <li><a data-toggle="tab" href="#order">My Order</a></li>
            </ul>


            <div class="tab-content">
                <div class="tab-pane active" id="userinfo">
                    <div class="row">
                        <div class="col-md-8 mx-auto">
                            <div class="card">
                                <div class="card-body">
                                    <div class="col-md-12">
                                        <form action="" method="post">
                                            <div class="form-group row">
                                                <label for="username" class="col-4 col-form-label">Name*</label>
                                                <div class="col-8">
                                                    <input id="name" name="name" placeholder="Username"
                                                           class="form-control here" required="required"
                                                           type="text" value="${user.name}">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="email" class="col-4 col-form-label">Email*</label>
                                                <div class="col-8">
                                                    <input id="email" name="email" placeholder="Email"
                                                           class="form-control here" required="required"
                                                           type="email" value="${user.email}">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="username" class="col-4 col-form-label">Phone</label>
                                                <div class="col-8">
                                                    <input id="phone" name="phone" placeholder="Phone"
                                                           class="form-control here" value="${user.phone}"
                                                           required="required"
                                                           type="text">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="address" class="col-4 col-form-label">Address</label>
                                                <div class="col-8">
                                                        <textarea id="address" name="address" cols="40" rows="4"
                                                                  class="form-control">${user.address}</textarea>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="username" class="col-4 col-form-label">Dob</label>
                                                <div class="col-8">
                                                    <input id="dob" name="dob" placeholder="Username"
                                                           class="form-control here" value="${user.dob}"
                                                           type="text">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="username" class="col-4 col-form-label">Date Create</label>
                                                <div class="col-8">
                                                    <input id="dateCreate" name="dateCreate" disabled
                                                           placeholder="Date Create"
                                                           class="form-control here" value="${user.dateCreate}"
                                                           type="text">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="username" class="col-4 col-form-label">Last Update</label>
                                                <div class="col-8">
                                                    <input id="lastChange" name="lastChange" disabled
                                                           placeholder="Last Update"
                                                           class="form-control here" value="${user.lastChange}"
                                                           type="text">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="offset-4 col-8">
                                                    <button style="height: 40px" name="submit" type="submit"
                                                            class="btn btn-primary">Update My Profile
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!--/tab-pane-->
                <div class="tab-pane" id="userpassword">
                    <div class="col-md-8 mx-auto">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form action="" method="post">
                                            <div class="form-group row">
                                                <label for="username" class="col-4 col-form-label">User
                                                    Name*</label>
                                                <div class="col-8">
                                                    <input id="username" name="username" placeholder="Username"
                                                           class="form-control here" required="required"
                                                           type="text">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="password" class="col-4 col-form-label">Password*</label>
                                                <div class="col-8">
                                                    <input id="password" name="password" placeholder="Current Password"
                                                           class="form-control here" required="required"
                                                           type="password">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="newpassword" class="col-4 col-form-label">New
                                                    Password*</label>
                                                <div class="col-8">
                                                    <input id="newpassword" name="newpassword"
                                                           placeholder="New Password" class="form-control here"
                                                           required="required" type="password">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="repassword" class="col-4 col-form-label">Confirm
                                                    Password*</label>
                                                <div class="col-8">
                                                    <input id="repassword" name="repassword"
                                                           placeholder="Confirm Password" class="form-control here"
                                                           required="required" type="password">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="offset-4 col-8">
                                                    <button style="height: 40px" name="submit" type="submit"
                                                            class="btn btn-primary">Change Password
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>
                <!--/tab-pane-->
                <div class="tab-pane" id="wishlist">
                    <div class="col-md-12">
                        <div class="padding-top-2x mt-2 hidden-lg-up"></div>
                        <!-- Wishlist Table-->
                        <div class="table-responsive wishlist-table margin-bottom-none">
                            <c:if test="${user.wishLists.size() eq 0}">
                                <div class="container-fluid mt-100" style="margin: 10vw 0px;">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="card">
                                                <div class="card-body cart">
                                                    <div class="col-sm-12 empty-cart-cls text-center"><img
                                                            src="https://i.imgur.com/dCdflKN.png" width="130"
                                                            height="130"
                                                            class="img-fluid mb-4 mr-3">
                                                        <h3><strong>Your Wish List is Empty</strong></h3>
                                                        <h4>Add something save it in your profile</h4> <a href=""
                                                                                                          class="btn btn-success cart-btn-transform m-3"
                                                                                                          data-abc="true">continue
                                                            shopping</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${user.wishLists.size() > 0}">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>
                                            <div style="margin-left: 9%;">Wish List</div>
                                        </th>
                                        <th class="text-center"><a class="btn btn-sm btn-outline-danger" href="">Clear
                                            Wishlist</a></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="wishlist" items="${user.wishLists}">
                                        <tr>
                                            <td>
                                                <a href="">
                                                    <div class="product-item">
                                                        <img class="col-md-4" src="${wishlist.item.image}"
                                                             alt="Product"/>
                                                        <div class="product-info col-md-8"
                                                             style="margin-top: 5%;text-align: center">
                                                            <a href="">
                                                                <h4 class="product-title">${wishlist.item.name}</h4>
                                                                <div class="text-lg text-medium text-muted">${wishlist.item.price}</div>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </a>
                                            </td>
                                            <td class="text-center "><a class="remove-from-cart" href=""
                                                                        data-toggle="tooltip"
                                                                        title="" data-original-title="Remove item"><i
                                                    class="fa fa-trash"></i> Remove </a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="order">
                    <div class="col-md-12">
                        <div class="padding-top-2x mt-2 hidden-lg-up"></div>
                        <article class="card">
                            <c:if test="${user.orders.size() eq 0}">
                                <div class="container-fluid mt-100" style="margin: 10vw 0px;">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="card">
                                                <div class="card-body cart">
                                                    <div class="col-sm-12 empty-cart-cls text-center"><img
                                                            src="https://i.imgur.com/dCdflKN.png"
                                                            width="130" height="130"
                                                            class="img-fluid mb-4 mr-3">
                                                        <h3><strong>No order History</strong></h3>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                            <c:if test="${user.orders.size() > 0}">
                            <header class="card-header"> My Orders / Tracking</header>

                            <c:forEach var="order" items="${user.orders}">
                            <div class="card-body">
                                <h5 style="float: left;">Order ID: ${order.id} </h5>
                                <c:if test="${order.status eq 1}">
                                <div style="float: left;padding: 15px;"><a style="padding: 13px;"
                                                                           class="btn-danger"
                                                                           href="">Cancel</a></div>
                                </c:if>
                                <article class="card">
                                    <div class="card-body">
                                        <div class="col"><strong>Estimated
                                            Delivery: </strong><br>${order.dayCreate}</div>
                                        <div class="col"><strong>Address:</strong><br> ${order.address} <br>
                                        </div>
                                        <c:choose>
                                            <c:when test="${order.status eq 1}">
                                                <div class="col"><strong>Status:</strong> <br> Pending</div>
                                            </c:when>
                                            <c:when test="${order.status eq 2}">
                                                <div class="col"><strong>Status:</strong> <br> Delivering</div>
                                            </c:when>
                                            <c:when test="${order.status eq 3}">
                                                <div class="col"><strong>Status:</strong> <br> Delivered</div>
                                            </c:when>
                                            <c:when test="${order.status eq 4}">
                                                <div class="col"><strong>Status:</strong> <br> Cancel</div>
                                            </c:when>
                                        </c:choose>

                                            ${order.updateTotal()}
                                        <div class="col"><strong>Total :</strong> <br> ${order.total}</div>
                                    </div>
                                </article>
                                <div class="track">
                                    <div class="step <c:out
        value="${order.status ge 1 && order.status lt 4? 'active': ''}"/>"><span class="icon"> <i
                                            class="fa fa-pause"></i> </span>
                                        <span class="text">Waiting confirmed</span></div>
                                    <div class="step <c:out
        value="${order.status ge 2 && order.status lt 4? 'active': ''}"/>"><span class="icon"> <i
                                            class="fa fa-truck"></i> </span>
                                        <span class="text"> On Delivering</span></div>
                                    <div class="step <c:out
        value="${order.status ge 3 && order.status lt 4? 'active': ''}"/>"><span class="icon"> <i
                                            class="fa fa-check"></i> </span> <span
                                            class="text"> Delivered </span></div>
                                    <div class="step <c:out
        value="${order.status eq 4 ? 'active': ''}"/>"><span class="icon"> <i class="fa fa-times"></i> </span> <span
                                            class="text">Cancel</span></div>
                                </div>
                                <hr>

                                <ul class="row">
                                    <c:forEach var="detail" items="${order.items}">
                                        <li class="col-md-6">
                                            <figure class="itemside mb-3">
                                                <div class="aside"><img
                                                        src="${detail.item.image}"
                                                        class="img-sm border"></div>
                                                <figcaption class="info align-self-center"
                                                            style="display: flex;justify-content: center;align-items: center;">
                                                    <p class="title">${detail.item.name} x ${detail.amount} <br> <span
                                                            class="text-muted">${detail.total} </span>
                                                </figcaption>
                                            </figure>
                                        </li>

                                    </c:forEach>
                                </ul>
                                </c:forEach>
                                </c:if>
                        </article>
                    </div>
                </div>
            </div>
        </div>

    </div><!--/tab-pane-->
</div><!--/tab-content-->

</div><!--/col-9-->
</div><!--/row-->

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
            fit: true, // 100% fit in a container
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
