<?php
//Connecting to database
//Change the host if applicable
//Change dbname to your database name
//Change root and password of the database if applicable
$db = new PDO("mysql:host=localhost;dbname=adilet-challenge","root","");
try{
$createTable = "
  CREATE TABLE IF NOT EXISTS users(
  id INT(11) AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(200) NOT NULL
  );
  CREATE TABLE IF NOT EXISTS activity(
  id INT(11) AUTO_INCREMENT PRIMARY KEY,
  userId INT(11) NOT NULL,
  active INT(11) NOT NULL,
  date DATE NOT NULL
  )";
$res = $db->query($createTable);
}
catch(PDOException $e){
  echo $e->getMessage();
}

//Get information
$date = $_POST['date'];
$file = $_FILES['fileToUpload']['tmp_name'];

//Check if file was uploaded
if(!isset($file)){
  die(response(0,"Error with uploading the file"));
}

//All CSV file types to check the file uploaded was in a correct format
$csv_mimetypes = array(
    'text/csv',
    'text/plain',
    'application/csv',
    'text/comma-separated-values',
    'application/excel',
    'application/vnd.ms-excel',
    'application/vnd.msexcel',
    'text/anytext',
    'application/octet-stream',
    'application/txt',
);
$csvAsArray = array_map('str_getcsv', file($file));

//Check if date is set
  if(isset($date)){
    //Check if file type correct
    if(in_array($_FILES['fileToUpload']['type'], $csv_mimetypes)){
      foreach($csvAsArray as $entry){
          $email = $entry[0];
          $active = $entry[1];
          //Validate email
          if(isValidEmail($email)){
            //Validate activity
            if(isActiveValid($active)){

              //Get id of the user if it exists
              $getUserInfo = $db->prepare("SELECT id FROM users WHERE email='$email'");
              $getUserInfo->execute();
              $resultUserInfo = $getUserInfo->fetch(PDO::FETCH_ASSOC);

              //if the id does not exist insert and get it
              if($resultUserInfo["id"]<=0){
                $insertUserInfo = $db->prepare("INSERT INTO users (email) VALUES ('$email')");
                $insertUserInfo->execute();
                $getUserInfo = $db->prepare("SELECT id FROM users WHERE email='$email'");
                $getUserInfo->execute();
                $resultUserInfo = $getUserInfo->fetch(PDO::FETCH_ASSOC);
              }

            }
            else{
              die(response(0,"Please indicate 1 for active, 0 for not active"));
            }
          }

          else{
            die(response(0,"Email is invalid. Please enter a valid email"));
          }

          if($getUserInfo->rowCount()>0){
            $insertInfo = $db->prepare("INSERT INTO activity (userId,active,date) VALUES ('$resultUserInfo[id]','$active','$date')");
            $insertInfo->execute();
          }
          else{
            die(response(0,"Error inserting the information. Please, try again later. "));
          }
        }
  }

  else{
    die(response(0,"File Type Not Correct"));
  }

}

die(response(1,"Success Uploading the data!"));

function isValidEmail($email){
  if (filter_var($email, FILTER_VALIDATE_EMAIL)) {
    return true;
  }
  else {
    return false;
  }
}

function isActiveValid($active){
  if($active === "1"){
    return true;
  }
  else if($active === "0"){
    return true;
  }
  else{
    return false;
  }
}

function response($status, $text) {
    return $text;
}
?>
