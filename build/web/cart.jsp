<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Welcome to StalePopcorn</title>

<meta http-equiv="Content-Language" content="English" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="stylesheet" type="text/css" href="styles/style.css" media="screen" />
<link href="styles/nivo-slider.css" rel="stylesheet" type="text/css" media="screen" />
<link href="styles/default.css" rel="stylesheet"  type="text/css" media="screen" />
<link href="styles/rating_style.css" rel="stylesheet"  type="text/css" media="screen" />


<!--  =================Javascript includes================= -->

<script type="text/javascript" src="js/jquery-1.4.2.min.js" ></script>
<script type="text/javascript" src="js/jquery.nivo.slider.pack.js" ></script>

<!--  =================End Javascript includes============= -->

   
<!--  =================Slideshow call================= -->

<script type="text/javascript">
			$(window).load(function() {
    			$('#slider').nivoSlider({
					effect: 'fade',
					pauseTime: 3000
					
				});
				
			});

</script>
<!--  =================End Slideshow call================= -->  

</head>
<body>

<!-- ================= Wrapper ================= -->		
<div id="wrap">

<!-- ================= Header ================= -->
<a href="index.jsp"><div id="header">
</div></a>

<!-- ================= End Header ================= -->

<div id="top"> </div> <!-- div top -->

<!-- ================= Content ================= -->
<div id="content">

<!-- ================= Menu ================= -->
<div id="menu">
<ul>
<li><a href="index.jsp">Home</a></li>
<li><a href="displayMovies" method="get">Display Movies</a></li>
<li><a href="displayConcessions" method="get">Concession Stand</a></li>
<li><a href="about.jsp" id="about">About</a></li>
</ul>
</div>

<!-- ================= End Menu ================= -->

<!-- ================= Left ================= -->
<div class="left" style="margin-left: auto; margin-right: auto;"> 

<!-- ================= Articles ================= -->
<div class="articles">

<h1>Your cart</h1>
<table border="1" cellpadding="5">
  <tr>
    <th>Quantity</th>
    <th>Description</th>
    <th>Price</th>
    <th>Amount</th>
  </tr>

<%@ page import="business.*, java.util.ArrayList" %>
<% 
   Cart cart = (Cart) session.getAttribute("cart"); 
   ArrayList<LineItem> items = cart.getItems();
   for (LineItem item : items)
   {
       Product product = item.getProduct();
%>

  <tr valign="top">
    <td>
      <form action="<%=response.encodeURL("cart")%>" method="post">
        <input type="hidden" name="productCode" 
               value="<%=product.getCode()%>">
        <input type=text size=2 name="quantity" 
               value="<%=item.getQuantity()%>">
        <input type="submit" value="Update">
      </form>
    </td>
    <td>
      <%=product.getDescription()%>
    </td>
    <td>
      <%=product.getPriceCurrencyFormat()%>
    </td>
    <td>
      <%=item.getTotalCurrencyFormat()%>
    </td>
      
  </tr>

<% } %>

  <tr>
    <td colspan="3">
      <p><b>To change the quantity</b>, enter the new quantity 
            and click on the Update button.</p>
    </td>
  </tr>
</table>

<br>

<form action="<%= response.encodeURL("displayConcessions")%>" method="post">
  <input type="submit" name="continue" value="Visit Our Concessions!">
</form>

<form action="<%= response.encodeURL("checkout.jsp")%>" method="post">
  <input type="submit" name="checkout" value="Checkout">
</form>


</div>



<div style="clear: both;"> </div>

</div>


<div id="bottom"> </div>

<div id="footer">
Developed by Carlos Cedeno, Francesco Delli Carpini, Richard Ramos, Juliet Son
</div>

</div>

</body>
<!--- =================End Body ================= -->
</html>

