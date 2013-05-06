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

<br>
<table cellpadding="5" border=1>

  <tr valign="bottom">
    <th>Concession</th>
    <th>Price</th>
  </tr>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:forEach var="concession" items="${concessions}">
  <tr valign="top">
    <form action="CartServlet?ConcessionName=${concession.conName}&ConcessionPrice=${concession.conPrice}" method="post">
    <td><p>${concession.conName}</td>
    <td><p>${concession.conPrice}</td>
       
    <td><input type="submit" value="Add to Cart"></input></td>
    </form>

  </tr>
  </c:forEach>

</table>
<li><a href="DisplayAdminConcessionServlet" method="get">Administrator Concession Application</a></li>
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

