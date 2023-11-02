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
    <title>User Page</title>
     
<style>
  
  *
    {    
        box-sizing: border-box;
    }
   body{
    align-items: center;
    justify-content: center;
    background: #4067d1;
   }
   .head
   {
    color: white;
   }
    .div12
    {
      position: absolute;
        
        text-align: center;
        height: 28rem;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
      /*   background-color:white;  
        
         border-style: solid;
        border-color: white;
        border-width: 0.5em; 
    */
    }
    .div-main
    {
      display: flex;
      flex-direction:row;
       height: 20rem;
    }
    .div1
    {
      padding: 2rem;
      background-color:blue;
      height: 23rem;
      width: 23rem;
    }
    .div2
    {
      padding: 2rem;
      background-color:white;
      height: 23rem;
      width: 23rem;
    }
    .div11
    {
      font-family:'Courier New', Courier, monospace;
      color:white;
    }
    .div22
    {
      font-family:'Courier New', Courier, monospace;
      color: #344f9b;
    }
</style>


</head>
 <%
 Configuration cfg = new Configuration();
 cfg.configure("Hibernate.cfg.xml");
  SessionFactory factory = cfg.buildSessionFactory();
  
  Session ses = factory.openSession();
  
   HttpSession ht = request.getSession(false);
   String password =  (String)ht.getAttribute("password");
      //int val = Integer.parseInt(password);
  User u = ses.get(User.class, password);
  //User u =  c.getU();
  
 
 ses.close();
 factory.close();

    %>

<body>
  
 <div class="div12">
  <h1 class="head" >Here the Details</h1>
    <div class="div-main">

      <div class="div1"> 
 
        <h2 class="div11" >Personal Details</h2>
        <h4 class="div11">Name : &nbsp <%= u.getName() %> </h4>
      <h4 class="div11">Email : &nbsp <%= u.getEmail() %> </h4>
      <h4 class="div11">Age : &nbsp <%= u.getAge() %></h4>
      <h4  class="div11">Gender :  &nbsp<%= u.getGender() %></h4>
    </div>
    
    
    <div class="div2">
      <h2 class="div22">Other Details</h2>
    
      <h4 class="div22"> State : &nbsp <%= u.getState() %> </h4>
      <h4 class="div22">car number : &nbsp <%= u.getCar_number()%></h4>
      <h4 class="div22">Near-By RTO office : &nbsp <%= u.getOffice() %></h4>
      <h4 class="div22">Town :  &nbsp<%= u.getTown() %></h4>
    </div>
    
    <a href="UpdatePage.html">Update</a>
  </div>
  </div>
</body>
</html>