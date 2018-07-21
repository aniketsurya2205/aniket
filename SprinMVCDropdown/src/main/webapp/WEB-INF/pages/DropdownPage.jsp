<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AJAX calls to Servlet using JQuery and JSON</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function() {
        $('#country').click(function(event) {  
        var $country=$("select#country").val();
           $.get('CountryMethod',{countryname:$country},function(responseJson) { //here data come from controller  
        	   
        	   
        	   var $select = $('#states');                           
               $select.find('option').remove(); //here by default selected value remove                         
              
               $.each(responseJson, function(key, value) { //this is come from db value through servlet               
             
            	   $('<option>').val(value).text(value).appendTo($select);// here change the state       
                    });
            });
        });
    });    
    
    $(document).ready(function() {
        $('#states').click(function(event) {  
        var $states=$("select#states").val();
           $.get('StateMethod',{statesName:$states},function(responseJson) {   
        	   
        	   var $select = $('#cities'); //here city selected                           
               $select.find('option').remove();                //default option gone          
               $.each(responseJson, function(key, value) {               //set the new value 
                   $('<option>').val(value).text(value).appendTo($select);      
                    });
            });
        });
    });  
    
</script>
</head>
<body>
<h1>AJAX calls to Servlet using JQuery and JSON</h1>
Select Country:
<select id="country">
<option selected="selected">Select Country</option>
<option value="India">India</option>
<option value="Usa">Usa</option>
</select>
<br/>
<br/>
Select State:
<select id="states">
<option selected="selected">Select State</option>
</select>
Select City:
<select id="cities">
<option selected="selected">Select Cities</option>
</select>
</body>
</html>






<%-- 




<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    </head>
    <script>
        
        $(document).ready(
        function() {

            $('#countryId').change(
            function() {
                
                $.getJSON('loadStates.htm', {
                    countryId : $(this).val(),
                    ajax : 'true'
                },  function(data) {
                    
                	var html = '<option value="">----Select State----</option>';
                    var len = data.length;
                   
                    for ( var i = 0; i < len; i++) {
                    	   html += '<option value="' + data[i].stateId + '">' + data[i].stateName + '</option>';
                    }
                    html += '</option>'; 
   
                    $('#stateId').html(html);
                });
            });
            
        });
        
    </script>

    <body>

        <h3>Countries</h3>

        <table>
            
            <tr>
                <td>Country-Name</td>
                <td>
                    <select id="countryId" name="countryId">
                        <option value="">Select Country</option> 
                        <c:forEach items="${countryList}" var="country">
                            <option   value="${country.countryId}"  >${country.countryName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>State-Name</td>
                <td>
                    <select  id="stateId">
                        <option value="">Select State</option> 
                        
                        
                         <c:forEach items="${ls}" var="state">
                            <option   value="${sate.stateId}"  >${state.stateName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>                    
        </table>
    </body>
</html>

 --%>
