<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import = "java.sql.*" %>
<%@page import = "java.io.*" %>
<%@page import = "java.util.*" %>
<%@page import = "javax.servlet.*" %>  
<%@page import = "org.hibernate.Session" %>  
<%@page import = "org.hibernate.SessionFactory" %>  
<%@page import = "org.hibernate.cfg.Configuration" %> 
<%@page import = "pojoClasses.*" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="CSS/HomeBot.css">
</head>
<%
Configuration cfg = new Configuration();
cfg.configure("Hibernate.cfg.xml");
 SessionFactory factory = cfg.buildSessionFactory();
 
 Session ses = factory.openSession();
 
  HttpSession ht = request.getSession(false);
  String password =  (String)ht.getAttribute("password");
     //int val = Integer.parseInt(password);

     if(password ==  null)
   {
		  
	      response.sendRedirect("LoginPage.html");  
	        
	  }

     User u = ses.get(User.class, password);
  
 //System.out.println(u.getName());
ses.close();
factory.close();

  

   %>
 <body>
    <header class="header">
        <div class="div1">
            <img class="img" src="Images/1.png" alt="Not Available">
            <h2 class="head1" >CarOService </h2>
        </div>
        <div class="div2">
            <h3 class="name_head">Welcome  &nbsp &nbsp<%= u.getName() %></h3>
        </div>
        <a href="LogoutServlet">Logout</a>  
    </header>
 
    <div class="main-div">
          <div class="head_div">
            <h3 class="welcome_head" >Please write the thing what you want to do</h3>

          </div>

    </div>
    <div class="bot_div">
        <form action="MainServlet" class="forms" >
            <input type="text" placeholder="Type Here" name="doing" class="box" >
            
<button class="custom-btn btn-1" type="submit" >Go</button>
        </form>
         
    </div>



    <section class="procedure">
        <div class="div-pro">
          
            <div class="choose">
             <img src="Images/3.png" alt="not Available" class="imgg">
             <h4 class="choose-s">Choose Service</h4>
             <p class="choose-p">After Login , Choose the according to your need after seeing the functionality and cost</p>
           </div>

           <div class="fill">
            <img src="Images/4.png" alt="not Available" class="imgg">
            <h4 class="choose-s">Fill the Details</h4>
            <p class="choose-p"> Fill the Details , after choosing the service for your car </p>
          </div>
 
          <div class="payment">
            <img src="Images/5.png" alt="not Available" class="imgg">
            <h4 class="choose-s">Make Payment</h4>
            <p class="choose-p"> Make Payment after choosing the service and the filling details after this your service will be booked </p>
          </div>


        </div>

    </section>


    <section class="tarif-s">
        <h1 class="tarif-h">Why To Use ?</h1>
        <div class="tarif">
            <div class="div-tarif">
                <div class=" t-24">
                    <img src="Images/6.png" alt="not Available" class="imgg1">
                    <h3 class="h-24  ">24/7 Service</h3>
                </div>
                <div class="fast-t">
                    <img src="Images/7.png" alt="not Available" class="imgg1">
                    <h3 class="fast-h">Fast Service</h3>
                </div>
            </div>
            <div class="div-tarif2">
                <div class="customers">
                    <img src="Images/8.png" alt="not Available" class="imgg1">
                    <h3 class="customer-h">Customer Satisfaction</h3>
                </div>
                <div class="dropnpick">
                    <img src="Images/9.png" alt="not Available" class="imgg1">
                    <h3 class="dropnpick-h">Drop and Pick up</h3>
                </div>
            </div>
    
        </div>
    </section>



</body>
</html>