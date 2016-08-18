<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "buybooks";
$uname=$_POST["muser"];
$upass=$_POST["mpass"];
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 


$sql = "INSERT INTO testhis (username, password) VALUES ('$uname','$upass')";

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

