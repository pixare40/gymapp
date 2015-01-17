/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kegara
 */
navigation={
    
    customermenu{
        MyProfile (controller:'customer', action:'index', titleText:'My Profile')
        PayZone (controller:'customer', action:'payzone', titleText:'PayZone')
        Checkins (controller:'customer', action:'mycheckins', titleText:'Check-Ins')
        MyAccount (controller:'customer', action:'myaccount', titleText:'My Account')
    }
    
    adminmenu{
        MyProfile (controller:'admin', action:'index', titleText:'My Profile')
        UserManagement (controller:'user', action:'index', titleText:'User Management')
        PayBundleManagement (controller:'payBundle', action:'index', titleText:'Pay Bundle Managemnt')
        Appdetails (controller:'home',action:'appdetails',titleText:'Application Details')
    }
    
    homemenu{
        Home (controller:'home', action:'home', titleText:'Home')
        Register (controller:'user',action:'create',titleText:'Register')
        Login (controller:'login',action:'auth',titleText:'Login')
        Checkin (controller:'checkIn',action:'checkin',titleText:'Check In')
        Terms (controller:'home', action:'terms',titleText:'Terms & Conditions')
        Aboutus (controller:'home',action:'aboutus',titleText:'About Us')
        Contactus (controller:'home', action:'contactus',titleText:'Contact Us')
    }
    
}
