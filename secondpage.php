<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "buybooks";
$uusername=$_POST["musername"];
$uname=$_POST["mname"];
$upass=$_POST["mpass"];
$ugender=$_POST["mgender"];
$uaddress=$_POST["maddress"];
$uemail=$_POST["memail"];
$uphone=$_POST["mphone"];

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 


$sql = "INSERT INTO bookusers (username,password,Name,Address,emailid,mobile,gender) VALUES ('$uusername','$upass','$uname','$uaddress','$uemail','$uphone','$ugender')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
$s="Success";
echo json_encode($s);
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
$s="Failed";
echo json_encode($s);
}

$conn->close();

?>