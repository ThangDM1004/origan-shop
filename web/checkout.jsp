<%-- 
    Document   : checkout
    Created on : Mar 13, 2023, 3:15:16 PM
    Author     : MSI AD
--%>

<%@page import="sample.products.Cart"%>
<%@page import="sample.products.ProductDTO"%>
<%@page import="sample.products.ProductDAO"%>
<%@page import="sample.products.ProductPayment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="sample.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>
        <%
            int count = 0;
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");

            Cart cart = (Cart) session.getAttribute("CART_PRODUCT");
            if (cart != null) {
                if (cart.getProduct() != null) {
                    count = cart.getProduct().size();
                }
            }
            String search = request.getParameter("search");
            if (search != null) {
                search = "";
            }
        %>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Humberger Begin -->
        <div class="humberger__menu__overlay"></div>
        <div class="humberger__menu__wrapper">
            <div class="humberger__menu__logo">
                <a href="index.jsp"><img src="img/logo.png" alt=""></a>
            </div>
            <div class="humberger__menu__cart">
                <ul>

                    <li><a href="shoping-cart.jsp"><i class="fa fa-shopping-bag"></i> <span><%= count%></span></a></li>
                </ul>

            </div>
            <div class="humberger__menu__widget">
                <div class="header__top__right__language">
                    <img src="img/language.png" alt="">
                    <div>English</div>
                    <span class="arrow_carrot-down"></span>
                    <ul>
                        <li><a href="#">Spanis</a></li>
                        <li><a href="#">English</a></li>
                    </ul>
                </div>
                <%
                    if (user == null) {
                %>
                <div class="header__top__right__auth">
                    <a href="login.html"><i class="fa fa-user"></i> Login</a>
                </div>
                <%
                } else {
                %>
                <div class="header__top__right__auth">
                    <a href="login.html"><i class="fa fa-user"></i> <%= user.getName()%></a>

                </div>
                <form action="MainController">
                    <input type="submit" name="action" value="Logout">
                </form>
                <%
                    }
                %>

            </div>
            <nav class="humberger__menu__nav mobile-menu">
                <ul>
                    <li class="active"><a href="./index.jsp">Home</a></li>
                    <li><a href="./shop-grid.jsp">Shop</a></li>
                    <li><a href="#">Pages</a>
                        <ul class="header__menu__dropdown">
                            <li><a href="./shop-details.jsp">Shop Details</a></li>
                            <li><a href="./shoping-cart.jsp">Shoping Cart</a></li>
                            <li><a href="./checkout.jsp">Check Out</a></li>
                            <li><a href="#">Blog Details</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Blog</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </nav>
            <div id="mobile-menu-wrap"></div>
            <div class="header__top__right__social">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-linkedin"></i></a>
                <a href="#"><i class="fa fa-pinterest-p"></i></a>
            </div>
            <div class="humberger__menu__contact">
                <ul>
                    <li><i class="fa fa-envelope"></i> oganiShop@gmail.com</li>
                    <li>Free Shipping for all Order of $99</li>
                </ul>
            </div>
        </div>
        <!-- Humberger End -->

        <!-- Header Section Begin -->
        <header class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__left">
                                <ul>
                                    <li><i class="fa fa-envelope"></i> oganiShop@gmail.com</li>
                                    <li>Free Shipping for all Order of $99</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__right">
                                <div class="header__top__right__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                    <a href="#"><i class="fa fa-pinterest-p"></i></a>
                                </div>
                                <div class="header__top__right__language">
                                    <img src="img/language.png" alt="">
                                    <div>English</div>
                                    <span class="arrow_carrot-down"></span>
                                    <ul>
                                        <li><a href="#">Spanis</a></li>
                                        <li><a href="#">English</a></li>
                                    </ul>
                                </div>
                                <%
                                    if (user == null) {
                                %>
                                <div class="header__top__right__auth">
                                    <a href="login.html"><i class="fa fa-user"></i> Login</a>
                                </div>
                                <%
                                } else {
                                %>
                                <div class="header__top__right__auth">
                                    <a href="login.html"><i class="fa fa-user"></i> <%= user.getName()%></a>
                                </div>
                                <form action="MainController">
                                    <input type="submit" name="action" value="Logout">
                                </form>
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a href="./index.jsp"><img src="img/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="./index.jsp">Home</a></li>
                                <li><a href="./shop-grid.jsp">Shop</a></li>
                                <li><a href="#">Pages</a>
                                    <ul class="header__menu__dropdown">
                                        <li><a href="./shop-details.jsp">Shop Details</a></li>
                                        <li><a href="./shoping-cart.jsp">Shoping Cart</a></li>
                                        <li><a href="./checkout.jsp">Check Out</a></li>
                                        <li><a href="#">Blog Details</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">
                            <ul>

                                <li><a href="shoping-cart.jsp"><i class="fa fa-shopping-bag"></i> <span><%= count%></span></a></li>
                            </ul>

                        </div>
                    </div>
                </div>
                <div class="humberger__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
        <!-- Header Section End -->

        <!-- Hero Section Begin -->
        <section class="hero hero-normal">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="hero__categories">
                            <div class="hero__categories__all">
                                <i class="fa fa-bars"></i>
                                <span>All departments</span>
                            </div>
                            <ul>
                                <li><a href="MainController?type=FM&action=Filter">Fresh Meat</a></li>
                                <li><a href="MainController?type=VT&action=Filter">Vegetables</a></li>
                                <li><a href="MainController?type=FN&action=Filter">Fruit & Nut Gifts</a></li>
                                <li><a href="MainController?type=FB&action=Filter">Fresh Berries</a></li>
                                <li><a href="MainController?type=OF&action=Filter">Ocean Foods</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="MainController">
                                    <input type="text" name="search" value=""<%= request.getParameter("search")%>/>
                                    <input type="submit" name="action" value="Search"/>
                                </form>
                            </div>
                            <div class="hero__search__phone">
                                <div class="hero__search__phone__icon">
                                    <i class="fa fa-phone"></i>
                                </div>
                                <div class="hero__search__phone__text">
                                    <h5>+65 11.188.888</h5>
                                    <span>support 24/7 time</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="breadcrumb__text">
                            <h2>Checkout</h2>
                            <div class="breadcrumb__option">
                                <a href="./index.jsp">Home</a>
                                <span>Checkout</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Checkout Section Begin -->
        <form action="MainController" >
            <section class="checkout spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h6><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click here</a> to enter your code
                            </h6>
                        </div>
                    </div>
                    <div class="checkout__form">
                        <h4>Billing Details</h4>
                        <form action="#">
                            <div class="row">
                                <div class="col-lg-8 col-md-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Fist Name<span>*</span></p>
                                                <input type="text" name="first" required="">

                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Last Name<span>*</span></p>
                                                <input type="text" name="last" required="">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="checkout__input">
                                        <p>Phone<span>*</span></p>
                                        <input type="text" name="Phone" required="">
                                    </div>
                                    <div class="checkout__input">
                                        <p>Province/City<span>*</span></p>
                                        <input type="text" name="city" required="">

                                    </div>
                                    <div class="checkout__input">
                                        <p>District<span>*</span></p>
                                        <input type="text" name="district" required="">
                                    </div>
                                    <div class="checkout__input">
                                        <p>Ward/Commune<span>*</span></p>
                                        <input type="text" name="ward" required="">
                                    </div>
                                    <div class="checkout__input">
                                        <p>Address<span>*</span></p>
                                        <input type="text" name="address" required="">
                                    </div>
                                    <div class="checkout__input">
                                        <p>Order notes</p>
                                        <input type="text"
                                               placeholder="Notes about your order, e.g. special notes for delivery." name="note">
                                    </div>
                                    <div class="checkout__input">
                                        <p>Payment<span>*</span></p>
                                        <form>
                                            <select name="cmbPayment">
                                                <option value="Payment on delivery">Payment on delivery</option>
                                                <option value="Credit/Debit Card"> Credit/Debit Card </option>
                                            </select>
                                        </form>
                                    </div>

                                </div>
                                <%
                                    float sum = 0;
                                    ProductDAO dao = new ProductDAO();
                                    if (user == null) {
                                        response.sendRedirect("login.html");
                                    } else {
                                        List<ProductPayment> list = dao.viewCart(user.getEmail());
                                        if (list != null) {
                                            if (list.size() > 0) {
                                %>
                                <div class="col-lg-4 col-md-6">
                                    <div class="checkout__order">
                                        <h4>Your Order</h4>
                                        <div class="checkout__order__products">Products <span>Total</span></div>
                                        <ul>
                                            <%
                                                for (ProductPayment pp : list) {

                                                    if ("false".equals(pp.getStatus())) {
                                                        sum += pp.getTotal();
                                            %>
                                            <li><%= pp.getProName()%> <span>$<%= pp.getTotal()%></span></li>
                                            <input type="hidden" name="proName" value="<%= pp.getProName()%>">
                                            <input type="hidden" name="email" value="<%=user.getEmail()%>">
                                            <%
                                                    }
                                                }
                                            %>
                                        </ul>
                                        <div class="checkout__order__total">Total <span>$<%= sum%></span></div>
                                        <input type="submit" class="site-btn" name="action" value="PLACE ORDER">
                                    </div>
                                </div>
                                <%
                                            }
                                        }
                                    }
                                %>

                            </div>
                        </form>
                    </div>
                </div>
            </section>
        </form>

        <!-- Checkout Section End -->

        <!-- Footer Section Begin -->
        <footer class="footer spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="footer__about">
                            <div class="footer__about__logo">
                                <a href="./index.jsp"><img src="img/logo.png" alt=""></a>
                            </div>
                            <ul>
                                <li>Address: 60-49 Road 11378 New York</li>
                                <li>Phone: +65 11.188.888</li>
                                <li>Email: hello@colorlib.com</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                        <div class="footer__widget">
                            <h6>Useful Links</h6>
                            <ul>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">About Our Shop</a></li>
                                <li><a href="#">Secure Shopping</a></li>
                                <li><a href="#">Delivery infomation</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="#">Our Sitemap</a></li>
                            </ul>
                            <ul>
                                <li><a href="#">Who We Are</a></li>
                                <li><a href="#">Our Services</a></li>
                                <li><a href="#">Projects</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">Innovation</a></li>
                                <li><a href="#">Testimonials</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12">
                        <div class="footer__widget">
                            <h6>Join Our Newsletter Now</h6>
                            <p>Get E-mail updates about our latest shop and special offers.</p>
                            <form action="#">
                                <input type="text" placeholder="Enter your mail">
                                <button type="submit" class="site-btn">Subscribe</button>
                            </form>
                            <div class="footer__widget__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-pinterest"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer__copyright">
                            <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                            <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Footer Section End -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>



    </body>
</html>
