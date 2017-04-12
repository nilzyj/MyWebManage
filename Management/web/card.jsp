<%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/4/7
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend></legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Card">Card Number</label>
            <div class="col-md-5">
                <input id="Card" name="Card" type="text" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Enter 16 digit card number.</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="fullname">Full Name</label>
            <div class="col-md-2">
                <input id="firstname" name="first" type="text" placeholder="First Name" class="form-control input-md"
                       required="">
                <span class="help-block">Exactly as it appears on the card.</span>
            </div>
            <style="float:left;"

            <!-- Text input-->
            <div class="form-group">
                <div class="col-md-2">
                <input id="lastname" name="last"type

                =
                "text"
                placeholder

                =
                "Last Name"
                class

                =
                "form-control input-md"
                required

                =
                ""
                >
                <
                span class

                =
                "help-block"
                >
                <
                /
                span >
                <

                /
                div > <

                /
                div >

                <!--
                Select Basic

                -->
                <
                div class

                =
                "form-group"
                >
                <
                label class

                =
                "col-md-4 control-label"
                for

                =
                "Exp Date"
                >
                Expiration Date<

                /
                label >
                < div class

                =
                "col-md-2"
                >
                <
                select id

                =
                "Exp Date"
                name

                =
                "Exp Date"
                class

                =
                "form-control"
                >
                <
                option value

                =
                "Month"
                >
                Month<

                /
                option >
                < option value

                =
                "1"
                >
                1
                <
                /
                option >
                < option value

                =
                "2"
                >
                2
                <
                /
                option >
                < option value

                =
                "3"
                >
                3
                <
                /
                option >
                < option value

                =
                "4"
                >
                4
                <
                /
                option >
                < option value

                =
                "5"
                >
                5
                <
                /
                option >
                < option value

                =
                "6"
                >
                6
                <
                /
                option >
                < option value

                =
                "7"
                >
                7
                <
                /
                option >
                < option value

                =
                "8"
                >
                8
                <
                /
                option >
                < option value

                =
                "9"
                >
                9
                <
                /
                option >
                < option value

                =
                "10"
                >
                10
                <
                /
                option >
                < option value

                =
                "11"
                >
                11
                <
                /
                option >
                < option value

                =
                "12"
                >
                12
                <
                /
                option >
                <

                /
                select >
                <

                /
                div style

                =
                "float:left;"
                >

                <!--
                Select Basic

                -->
                <
                div class

                =
                "form-group"
                >
                <
                div class

                =
                "col-md-2"
                >
                <
                select id

                =
                "YY"
                name

                =
                "Year"
                class

                =
                "form-control"
                >
                <
                option value

                =
                "Year"
                >
                Year<

                /
                option >
                < option value

                =
                "2016"
                >
                2016
                <
                /
                option >
                < option value

                =
                "2017"
                >
                2017
                <
                /
                option >
                < option value

                =
                "2018"
                >
                2018
                <
                /
                option >
                < option value

                =
                "2019"
                >
                2019
                <
                /
                option >
                < option value

                =
                "2020"
                >
                2020
                <
                /
                option >
                < option value

                =
                "2021"
                >
                2021
                <
                /
                option >
                < option value

                =
                "2022"
                >
                2022
                <
                /
                option >
                < option value

                =
                "2023"
                >
                2023
                <
                /
                option >
                < option value

                =
                "2024"
                >
                2024
                <
                /
                option >
                < option value

                =
                "2025"
                >
                2025
                <
                /
                option >
                < option value

                =
                "2026"
                >
                2026
                <
                /
                option >
                < option value

                =
                "2027"
                >
                2027
                <
                /
                option >
                < option value

                =
                "2028"
                >
                2028
                <
                /
                option >
                <

                /
                select >
                <

                /
                div > <

                /
                div >

                <!--
                Text input-- >
                < div class

                =
                "form-group"
                >
                <
                label class

                =
                "col-md-4 control-label"
                for

                =
                "cvv"
                >
                Security Code<

                /
                label >
                < div class

                =
                "col-md-1"
                >
                <
                input id

                =
                ""
                name

                =
                "CVV"
                type

                =
                "text"
                placeholder

                =
                ""
                class

                =
                "form-control input-md"
                required

                =
                ""
                >
                <
                /
                div > <

                /
                div >

                <!--
                Text input-- >
                < div class

                =
                "form-group"
                >
                <
                label class

                =
                "col-md-4 control-label"
                for

                =
                ""
                >
                Street Address

                1
                <
                /
                label >
                < div class

                =
                "col-md-5"
                >
                <
                input id

                =
                ""
                name

                =
                "Address 1"
                type

                =
                "text"
                placeholder

                =
                ""
                class

                =
                "form-control input-md"
                required

                =
                ""
                >
                <
                /
                div > <

                /
                div >

                <!--
                Text input-- >
                < div class

                =
                "form-group"
                >
                <
                label class

                =
                "col-md-4 control-label"
                for

                =
                ""
                >
                Street Address

                2
                <
                /
                label >
                < div class

                =
                "col-md-5"
                >
                <
                input id

                =
                ""
                name

                =
                "Address 2"
                type

                =
                "text"
                placeholder

                =
                "Apartment, suite, etc."
                class

                =
                "form-control input-md"
                required

                =
                ""
                >
                <
                /
                div > <

                /
                div >

                <!--
                Text input-- >
                < div class

                =
                "form-group"
                >
                <
                label class

                =
                "col-md-4 control-label"
                for

                =
                ""
                >
                City<

                /
                label >
                < div class

                =
                "col-md-2"
                >
                <
                input id

                =
                ""
                name

                =
                "City"
                type

                =
                "text"
                placeholder

                =
                ""
                class

                =
                "form-control input-md"
                required

                =
                ""
                >
                <
                /
                div > <

                /
                div >

                <!--
                Select Basic

                -->
                <
                div class

                =
                "form-group"
                >
                <
                label class

                =
                "col-md-4 control-label"
                for

                =
                "country"
                >
                Country<

                /
                label >
                < div class

                =
                "col-md-2"
                >
                <
                select id

                =
                "country"
                name

                =
                "country"
                class

                =
                "form-control"
                >
                <
                select id

                =
                "country"
                name

                =
                "country"
                >
                <
                /
                select > <

                /
                div > <

                /
                div >

                <!--
                Select Basic

                -->
                <
                div class

                =
                "form-group"
                >
                <
                label class

                =
                "col-md-4 control-label"
                for

                =
                "state"
                >
                State<

                /
                label >
                < div class

                =
                "col-md-2"
                >
                <
                select id

                =
                "state"
                name

                =
                "state"
                class

                =
                "form-control"
                >
                <
                select id

                =
                "Select State"
                name

                =
                "state"
                >
                <
                /
                select >
                < script language

                =
                "javascript"
                >
                populateCountries

                (
                "country"
                ,
                "state"
                )
                ;
                populateCountries

                (
                "country2"
                )
                ;
                <
                /
                script >
                <

                /
                div > <

                /
                div >

                <!--
                Text input-- >
                < div class

                =
                "form-group"
                >
                <
                label class

                =
                "col-md-4 control-label"
                for

                =
                ""
                >
                Zip or postal code<

                /
                label >
                < div class

                =
                "col-md-2"
                >
                <
                input id

                =
                ""
                name

                =
                "Zip"
                type

                =
                "text"
                placeholder

                =
                ""
                class

                =
                "form-control input-md"
                required

                =
                ""
                >

                <
                /
                div >
                <

                /
                div >

                <!--
                Text input-- >
                < div class

                =
                "form-group"
                >
                <
                label class

                =
                "col-md-4 control-label"
                for

                =
                ""
                >
                Contact Email<

                /
                label >
                < div class

                =
                "col-md-3"
                >
                <
                input id

                =
                ""
                name

                =
                "Email"
                type

                =
                "text"
                placeholder

                =
                ""
                class

                =
                "form-control input-md"
                required

                =
                ""
                >
                <
                span class

                =
                "help-block"
                >
                Please provide email address in which you

                'd like to receive purchase confirmation.</span>

                <
                /
                div >
                <

                /
                div >

                <!--
                Button

                -->
                <
                div class

                =
                "form-group"
                >
                <
                label class

                =
                "col-md-4 control-label"
                for

                =
                "continue"
                >
                <
                /
                label >
                < div class

                =
                "col-md-4"
                >
                <
                button id

                =
                "continue"
                name

                =
                "continue"
                class

                =
                "btn btn-success"
                >
                Continue<

                /
                button >
                <

                /
                div >
                <

                /
                div >
                <

                /
                fieldset >
                <

                /
                form >
                <

                /
                body >
                <

                /
                html >
