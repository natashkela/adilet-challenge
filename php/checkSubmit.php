<?php
//Connecting to database
$db = new PDO("mysql:host=localhost;dbname=adilet-challenge","root","");

//Get information
$email = $_POST['email'];
$month = $_POST['month'];
$year = $_POST['year'];

//Validate Email
if(isset($email)&&isValidEmail($email)){
  //Validate Month
  if(isset($month)&&isValidMonth($month)){
    //Validate Year
    if(isset($year)&&isValidYear($year)){
      //Make a range for the month
      $date = $year."-".$month."-01";
      $date1 = $year."-".$month."-31";
      //Sum of all the days user was active in a month
      $getUserInfo = $db->prepare("SELECT DISTINCT activity.date FROM users
                                  INNER JOIN activity
                                  ON users.id = activity.userId
                                  WHERE users.email='$email' AND
                                  activity.active=1 AND
                                  (activity.date BETWEEN '$date' AND '$date1')");
      $getUserInfo->execute();
      $resultUserInfo = $getUserInfo->fetch(PDO::FETCH_ASSOC);
      //User Active
      if($getUserInfo->rowCount()>=20){
          die(response(1,"<p>
          User was active at this month. The number of days they were active is ".
          $getUserInfo->rowCount()."</p>"));
      }
      //User Not Active
      else if($getUserInfo->rowCount()>0){
          die(response(1,"User was not active at this month. The number of days they were active is ".$getUserInfo->rowCount()));
      }
      //No Data About User
      else{
        die(response(1,"Sorry, but we could not find any data for the time and user entered."));
      }
    }
    else{
      die(response(0,"Please enter valid year in yyyy format"));
    }
  }
  else{
    die(response(0,"Please enter valid month in mm format"));
  }
}
else{
  die(response(0,"Please enter valid email!"));
}

//Email Validation
function isValidEmail($email){
  if (filter_var($email, FILTER_VALIDATE_EMAIL)) {
    return true;
  }
  else {
    return false;
  }
}

//Month Validation
function isValidMonth($month){
  if($month>0&&$month<=12){
    return true;
  }
  else{
    return false;
  }
}

//Year Validation
function isValidYear($year){
  if($year>0 && $year<=2100){
    return true;
  }
  else{
    return false;
  }
}

//Send Response to DOM
function response($status, $text) {
    return $text;
}
?>
