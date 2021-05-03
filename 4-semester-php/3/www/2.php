<?php include 'uri.php';?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <form action="<?php echo $URI; ?>" method="post">
        <textarea cols="30" rows="10" name="2_text">Enter text </textarea> <br />
        <input type="submit" name="2_action" value="Save" />
    </form>

    <?php
if (isset($_POST['2_action'])) {
    $text = $_POST["2_text"];
    if (file_put_contents('2.txt', $text . "\n", FILE_APPEND)) {
        echo "File saved successfully.";
    } else {
        echo "There was a problem with file saving.. Permissions?";
    }

    echo '<br/>';
}
?>
</body>

</html>