<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header -->

<div class="header" id="home">
    <div class="container">
        <ul>
            <c:if test="${user eq null}">
                <li><a href="#" data-toggle="modal" data-target="#myModal"><i class="fa fa-unlock-alt"
                                                                              aria-hidden="true"></i> Sign In </a></li>
                <li><a href="#" data-toggle="modal" data-target="#myModal2"><i class="fa fa-pencil-square-o"
                                                                               aria-hidden="true"></i> Sign Up </a></li>
            </c:if>
            <c:if test="${user ne null}">
                <li><a href="/profile"> <i class="fa fa-user" aria-hidden="true"></i> Welcome: ${user.name} </a></li>
                <li><a href="/logout"> <i class="fa fa-sign-out" aria-hidden="true"></i> Sign out </a></li>
            </c:if>
        </ul>
    </div>
</div>
<!-- //header -->
<!-- header-bot -->
<div class="header-bot">
    <div class="header-bot_inner_wthreeinfo_header_mid">
        <div class="col-md-4 header-middle">
            <form action="/search" method="post">
                <input type="search" name="search" id="search" onkeypress="autoSearch()" placeholder="Search here..." >
                <input type="submit" value=" ">
                <div class="clearfix"></div>
            </form>
        </div>
        <!-- header-bot -->
        <div class="col-md-4 logo_agile">
            <h1><a href="/home"><span>E</span>lite Shoppy <i
                    class="fa fa-shopping-bag top_logo_agile_bag" aria-hidden="true"></i></a></h1>
        </div>
        <!-- header-bot -->
        <div class="clearfix"></div>
    </div>
</div>
<!-- //header-bot -->
<!-- banner-top -->
<div class="ban-top">
    <div class="container">
        <div class="top_nav_left">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse menu--shylock" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav menu__list">
                            <li class="active menu__item menu__item--current"><a class="menu__link" href="/home">Home
                                <span class="sr-only">(current)</span></a></li>
                            <li class="dropdown menu__item">
                                <a href="#" class="dropdown-toggle menu__link" data-toggle="dropdown" role="button"
                                   aria-haspopup="true" aria-expanded="false">Brand <span class="caret"></span></a>
                                <ul class="dropdown-menu multi-column columns-3">
                                    <div class="agile_inner_drop_nav_info">
                                        <div class="col-sm-12 multi-gd-img">
                                            <ul class="multi-column-dropdown">
                                                <c:forEach var="brand" items="${brands}">
                                                    <div class="col-md-6">
                                                        <li><a href="/product?brand=${brand.id}">${brand.name}</a></li>
                                                    </div>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </ul>
                            </li>
                            <li class="dropdown menu__item">
                                <a href="#" class="dropdown-toggle menu__link" data-toggle="dropdown" role="button"
                                   aria-haspopup="true" aria-expanded="false">Product <span class="caret"></span></a>
                                <ul class="dropdown-menu multi-column columns-2">
                                    <div class="agile_inner_drop_nav_info">
                                        <div class="col-sm-12 multi-gd-img">
                                            <ul class="multi-column-dropdown">
                                                <li><a href="/product">All</a></li>
                                                <li>
                                                    <a href="/product?status=1">Hot</a>
                                                </li>
                                                <li>
                                                    <a href="/product?status=2">Sale</a>
                                                </li>
                                                <li>
                                                    <a href="/product?status=3">New</a>
                                                </li>
                                                <li>
                                                    <a href="/product?status=0">Other</a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="top_nav_right">
            <div class="wthreecartaits wthreecartaits2 cart cart box_1">
                <button type="button" data-toggle="modal" data-target="#cartModal" class="w3view-cart"><i
                        class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- //banner-top -->

<!-- Modal1 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body modal-body-sub_agile">
                <div class="col-md-8 modal_body_left modal_body_left1">
                    <h3 class="agileinfo_sign">Sign In <span>Now</span></h3>
                    <form id="loginForm" action="${pageContext.request.contextPath}/login" method="post">
                        <div class="styled-input agile-styled-input-top">
                            <input type="text" name="username" >
                            <label>Username</label>
                            <span></span>
                        </div>
                        <div class="styled-input">
                            <input type="password" name="password" >
                            <label>Password</label>
                            <span></span>
                        </div>

                        <input type="submit" value="Sign In">
                    </form>
                    <ul class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
                        <li><a href="#" class="facebook">
                            <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
                            <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div>
                        </a></li>
                        <li><a href="#" class="twitter">
                            <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
                            <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div>
                        </a></li>
                        <li><a href="#" class="instagram">
                            <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
                            <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div>
                        </a></li>
                        <li><a href="#" class="pinterest">
                            <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
                            <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
                        </a></li>
                    </ul>
                    <div class="clearfix"></div>
                    <div>
                        <p><a style="float: left" href="#myModal2" data-toggle="modal" data-target="#myModal2"> Don't have an
                            account?</a></p>
                        <p style="width: 154%"><a style="float: right" href="/forgetpass">Or forget your
                            password?</a></p>
                    </div>

                </div>
                <div class="col-md-4 modal_body_right modal_body_right1">
                    <img src="${pageContext.request.contextPath}/images/default/log-pic.png" alt=" "/>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //Modal content-->
    </div>
</div>
<!-- //Modal1 -->
<!-- Modal2 -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body modal-body-sub_agile">
                <div class="col-md-8 modal_body_left modal_body_left1">
                    <h3 class="agileinfo_sign">Sign Up <span>Now</span></h3>
                    <form id="registerform" action="register" method="post">
                        <div class="styled-input agile-styled-input-top">
                            <input type="text" name="username" id="username">
                            <label>Username</label>
                            <span></span>
                        </div>
                        <div class="styled-input">
                            <input type="email" name="email" id="email">
                            <label>Email</label>
                            <span></span>
                        </div>
                        <div class="styled-input">
                            <input type="password" name="password" id="password">
                            <label>Password</label>
                            <span></span>
                        </div>
                        <div class="styled-input">
                            <input type="password" name="confirm" id="confirm">
                            <label>Confirm Password</label>
                            <span></span>
                        </div>
                        <input type="submit" value="Sign Up">
                    </form>
                    <ul class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
                        <li><a href="#" class="facebook">
                            <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
                            <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div>
                        </a></li>
                        <li><a href="#" class="twitter">
                            <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
                            <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div>
                        </a></li>
                        <li><a href="#" class="instagram">
                            <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
                            <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div>
                        </a></li>
                        <li><a href="#" class="pinterest">
                            <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
                            <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
                        </a></li>
                    </ul>
                    <div class="clearfix"></div>
                    <p>By clicking register, I agree to your terms</p>

                </div>
                <div class="col-md-4 modal_body_right modal_body_right1">
                    <img src="${pageContext.request.contextPath}/images/default/log-pic.png" alt=" "/>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //Modal content-->
    </div>
</div>
<!-- //Modal2 -->


<div class="modal fade" id="cartModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header border-bottom-0">
                <h3 style="margin-left: 1.5vw;font-weight: 800;color: darkblue;float:left;" id="exampleModalLabel">
                    Your Shopping Cart
                </h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
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
                                    <img src="${pageContext.request.contextPath}/${detail.value.product.image1}" class="img-fluid img-thumbnail"
                                         alt="Sheep">
                                </td>
                                <td>${detail.value.product.name}</td>
                                <td class="dataPrice">${detail.value.product.price}</td>
                                <td id="qty"><input name="dataQuanlity" onchange="updateCart_Head()" type="text"
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
                    <div class="d-flex justify-content-end" style="width: 100%;float: right; margin-bottom: 1vw;margin-top: 3vw;">
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
                    </div>
                </c:if>
            </div>
            <div class="modal-footer border-top-0 d-flex justify-content-between">
                <button style="margin-right: 8px;background-color: #f0ad4e" type="button" class="btn btn-secondary"
                        data-dismiss="modal">Close
                </button>
                <a type="button" href="/cart" class="btn btn-success">Cart Manager</a>
            </div>
        </div>
    </div>
</div>
<style>
    #cartModal .modal-title{float:left;}
    #cartModal #qty input{width:50px;}
    #cartModal td{text-align:center;vertical-align:middle;}
    #cartModal th{text-align:center;}
    #cartModal .d-flex{text-align:end;margin-right:1vw;}
    #cartModal .modal-footer{margin-right:1vw;}
    h3{margin:1px;}
    label.error{width:100%;color:red!important;text-align:right;}
    .ui-menu-item-wrapper{
        border: #0da9ef solid 2px!important;
        padding: 10px;
        z-index: 100;
    }
    .bs-autocomplete-menu{
        background-color: white;
    }
</style>

<script>
    function updateCart_Head(){
        let list = document.getElementsByName('dataQuanlity');
        let total = document.getElementsByClassName('dataTotal');
        let price = document.getElementsByClassName('dataPrice');

        let list2 = document.getElementsByName('dataQuanlity2');
        let total2 = document.getElementsByClassName('dataTotal2');

        let subtotal = 0;
        let json = [];
        for (let i = 0; i < list.length; i++) {
            json[i] = list[i].value;
        }

        $.ajax({
            url:"/cart/update",
            type:"POST",
            data: {json:json},
            success:function(){
                subtotal = 0;
                for (let i = 0; i < list.length; i++) {
                    total[i].innerHTML = price[i].innerHTML * list[i].value;
                    subtotal += price[i].innerHTML * list[i].value;

                    list2[i].value = list[i].value;
                    total2[i].innerHTML = price[i].innerHTML * list[i].value;
                }
                $("#subtotal").text(subtotal);
                $("#carttotal").text(subtotal+10000);

                $("#subtotal2").text(subtotal);
                $("#carttotal2").text(subtotal+10000);
            },
        });
    }
</script>






