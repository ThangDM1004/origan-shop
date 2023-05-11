<%-- 
    Document   : shop-grid
    Created on : Feb 28, 2023, 3:47:17 PM
    Author     : MSI AD
--%>

<%@page import="sample.products.Cart"%>
<%@page import="sample.users.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.products.ProductDTO"%>
<%@page import="sample.products.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ogani Shop</title>

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
                    <li class="active"><a href="./shop-grid.jsp">Home</a></li>
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
                            <a href="index.jsp"><img src="img/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="./shop-grid.jsp">Home</a></li>
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
                            <h2>Organi Shop</h2>
                            <div class="breadcrumb__option">
                                <a href="./shop-grid.jsp">Home</a>
                                <span>Shop</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Product Section Begin -->
        <section class="product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-5">
                        <div class="sidebar">
                            <div class="sidebar__item">
                                <h4>Department</h4>
                                <ul>
                                    <li><a href="MainController?type=all&action=Filter">All</a></li>
                                    <li><a href="MainController?type=FM&action=Filter">Fresh Meat</a></li>
                                    <li><a href="MainController?type=VT&action=Filter">Vegetables</a></li>
                                    <li><a href="MainController?type=FN&action=Filter">Fruit & Nut Gifts</a></li>
                                    <li><a href="MainController?type=FB&action=Filter">Fresh Berries</a></li>
                                    <li><a href="MainController?type=OF&action=Filter">Ocean Foods</a></li>
                                </ul>
                            </div>
                            <div style="display: none" class="sidebar__item">
                                <h4>Price</h4>
                            </div>
                            <div style="display" class="sidebar__item">
                                <div class="latest-product__text">
                                    <h4>Latest Products</h4>
                                    <div class="latest-product__slider owl-carousel">
                                        <div class="latest-prdouct__slider__item">
                                            <%
                                                ProductDAO dao = new ProductDAO();
                                                List<ProductDTO> latest = dao.latestProduct();
                                                for (int i = 0; i < latest.size() / 2; i++) {
                                            %>
                                            <a href="MainController?proName=<%= latest.get(i).getProName()%>&action=ViewDetail" class="latest-product__item">
                                                <div class="latest-product__item__pic">
                                                    <img src="<%= latest.get(i).getUrlImg()%>" alt="">
                                                </div>
                                                <div class="latest-product__item__text">
                                                    <h6><%= latest.get(i).getProName()%></h6>
                                                    <span>$<%= latest.get(i).getPrice()%></span>
                                                </div>
                                            </a>
                                            <%
                                                }
                                            %>
                                        </div>
                                        <div class="latest-prdouct__slider__item">
                                            <%
                                                for (int i = latest.size() / 2; i < latest.size(); i++) {
                                            %>
                                            <a href="MainController?proName=<%= latest.get(i).getProName()%>&action=ViewDetail" class="latest-product__item">
                                                <div class="latest-product__item__pic">
                                                    <img src="<%= latest.get(i).getUrlImg()%>" alt="">
                                                </div>
                                                <div class="latest-product__item__text">
                                                    <h6><%= latest.get(i).getProName()%></h6>
                                                    <span>$<%= latest.get(i).getPrice()%></span>
                                                </div>
                                            </a>
                                            <%
                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-7">
                       
                        <%List<ProductDTO> productSearch = (List<ProductDTO>) request.getAttribute("SEARCH_PRODUCT");
                            String type = request.getParameter("type");
                            if (productSearch != null) {
                                if (productSearch.size() > 0) {
                                    int sum = productSearch.size();

                        %>
                        <div class="filter__item">
                            <div class="row">

                                <div class="col-lg-4 col-md-4">
                                    <div class="filter__found">
                                        <h6><span><%= sum%></span> Products found</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row"><%
                            for (ProductDTO p : productSearch) {

                            %>
                            <div class="col-lg-4 col-md-6 col-sm-6">

                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="<%= p.getUrlImg()%>">
                                        <ul class="product__item__pic__hover">
                                            <li><a href="#"><i class="fa fa-heart"></i></a></li>

                                            <li><a href="MainController?proId=<%= p.getProId()%>&url=shop-grid.jsp&action=Cookie" ><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <h6><a href="MainController?proName=<%= p.getProName()%>&action=ViewDetail"  ><%= p.getProName()%></a></h6>
                                        <h5>$<%= p.getPrice()%></h5>
                                    </div>
                                </div>
                            </div>
                            <%
                                    }
                                }
                            } else if (type == null) {
                                String name = request.getParameter("name");
                                List<ProductDTO> product = dao.getAllProduct();
                                int sum = product.size();
                            %>
                            <div class="filter__item">
                                <div class="row">

                                    <div class="col-lg-4 col-md-4">
                                        <div class="filter__found">
                                            <h6><span><%= sum%></span> Products found</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <%
                                    if (name == null || "1".equals(name)) {
                                        for (int i = 0; i < 9; i++) {
                                %>
                                <div class="col-lg-4 col-md-6 col-sm-6">

                                    <div class="product__item">
                                        <div class="product__item__pic set-bg" data-setbg="<%= product.get(i).getUrlImg()%>">
                                            <ul class="product__item__pic__hover">
                                                <li><a href="#"><i class="fa fa-heart"></i></a></li>

                                                <li><a href="MainController?proId=<%= product.get(i).getProId()%>&url=shop-grid.jsp&action=Cookie" ><i class="fa fa-shopping-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__item__text">
                                            <h6><a href="MainController?proName=<%= product.get(i).getProName()%>&action=ViewDetail"  ><%= product.get(i).getProName()%></a></h6>
                                            <h5>$<%= product.get(i).getPrice()%></h5>
                                        </div>
                                    </div>
                                </div>

                                <%
                                    }
                                } else if ("2".equals(name)) {
                                    for (int i = 9; i < 18; i++) {
                                %>
                                <div class="col-lg-4 col-md-6 col-sm-6">

                                    <div class="product__item">
                                        <div class="product__item__pic set-bg" data-setbg="<%= product.get(i).getUrlImg()%>">
                                            <ul class="product__item__pic__hover">
                                                <li><a href="#"><i class="fa fa-heart"></i></a></li>

                                                <li><a href="MainController?proId=<%= product.get(i).getProId()%>&url=shop-grid.jsp&action=Cookie" ><i class="fa fa-shopping-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__item__text">
                                            <h6><a href="MainController?proName=<%= product.get(i).getProName()%>&action=ViewDetail"  ><%= product.get(i).getProName()%></a></h6>
                                            <h5>$<%= product.get(i).getPrice()%></h5>
                                        </div>
                                    </div>
                                </div>
                                <%
                                    }
                                } else if ("3".equals(name)) {
                                    for (int i = 18; i <25; i++) {
                                %>
                                <div class="col-lg-4 col-md-6 col-sm-6">

                                    <div class="product__item">
                                        <div class="product__item__pic set-bg" data-setbg="<%= product.get(i).getUrlImg()%>">
                                            <ul class="product__item__pic__hover">
                                                <li><a href="#"><i class="fa fa-heart"></i></a></li>

                                                <li><a href="MainController?proId=<%= product.get(i).getProId()%>&url=shop-grid.jsp&action=Cookie" ><i class="fa fa-shopping-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__item__text">
                                            <h6><a href="MainController?proName=<%= product.get(i).getProName()%>&action=ViewDetail"  ><%= product.get(i).getProName()%></a></h6>
                                            <h5>$<%= product.get(i).getPrice()%></h5>
                                        </div>
                                    </div>
                                </div>
                                <%
                                        }
                                    }
                                } else {
                                    List<ProductDTO> product = (List<ProductDTO>) session.getAttribute("TYPE_PRODUCT");
                                    int sum = product.size();
                                %>
                                <div class="filter__item">
                                    <div class="row">

                                        <div class="col-lg-4 col-md-4">
                                            <div class="filter__found">
                                                <h6><span><%= sum%></span> Products found</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <%
                                        for (ProductDTO p : product) {
                                    %>
                                    <div class="col-lg-4 col-md-6 col-sm-6">

                                        <div class="product__item">
                                            <div class="product__item__pic set-bg" data-setbg="<%= p.getUrlImg()%>">
                                                <ul class="product__item__pic__hover">
                                                    <li><a href="#"><i class="fa fa-heart"></i></a></li>

                                                    <li><a href="MainController?proId=<%= p.getProId()%>&url=shop-grid.jsp&action=Cookie" ><i class="fa fa-shopping-cart"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="product__item__text">
                                                <h6><a href="MainController?proName=<%= p.getProName()%>&action=ViewDetail"  ><%= p.getProName()%></a></h6>
                                                <h5>$<%= p.getPrice()%></h5>
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                            }
                                        }
                                    %>

                                </div>
                                <form action="MainControler">
                                    <div class="product__pagination">
                                        <a href="MainController?name=1&action=Next">1</a>
                                        <a href="MainController?name=2&action=Next">2</a>
                                        <a href="MainController?name=3&action=Next">3</a>
                                    </div>
                                </form>

                            </div>
                        </div>

                        </section>
                        <!-- Product Section End -->

                        <!-- Footer Section Begin -->
                        <footer class="footer spad">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-3 col-md-6 col-sm-6">
                                        <div class="footer__about">
                                            <div class="footer__about__logo">
                                                <a href="index.jsp"><img src="img/logo.png" alt=""></a>
                                            </div>
                                            <ul>
                                                <li>Address: 60-49 Road 11378 New York</li>
                                                <li>Phone: +65 11.188.888</li>
                                                <li>Email: oganiShop@gmail.com</li>
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
