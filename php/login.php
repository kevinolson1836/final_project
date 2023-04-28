<?php
      session_start();
      $_SESSION['authenticated'] = false;
      
      if($_SERVER["REQUEST_METHOD"] == "POST")
      {
        // grab username and password. set authenticated to false
        $myusername = mysqli_real_escape_string($db,$_POST['username']);
         $mypassword = mysqli_real_escape_string($db,$_POST['password']); 
         $_SESSION['authenticated'] = false;
         
          echo $myusername;
          echo"\n";
          echo $mypassword;

         // prepare SQL to search for login credientals 
         $sql = "SELECT * FROM id WHERE username = '$myusername' and password = '$mypassword'";
         $result = mysqli_query($db,$sql);
         $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
         $count = mysqli_num_rows($result);
         $error = "";
         // If match found log user in and set authenticated to true
         if($count == 1)
         {
           $_SESSION['login_user'] = $myusername;
           $_SESSION['authenticated'] = true;
           $error = "valid";
           header("location: draw.html");
          }else
          {
            $_SESSION['authenticated'] = false;
            echo "<h1 id='error' style='position:absolute;vertical-align: text-top; top:10%;color: red;'>Your Login Name or Password is invalid!</h1>";

          }
        }
        ?>