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
        <p>Number: <input type="number" min=1 name="4_num" value=1 required /></p>
        <p><input type="submit" /></p>
    </form>
    <?php

function isPrime($number)
{
    if ($number == 1) {
        return false;
    }
    if ($number == 2) {
        return true;
    }
    $hack = sqrt($number);
    $hack = floor($hack);
    for ($i = 2; $i <= $hack; ++$i) {
        if ($number % $i == 0) {
            break;
        }
    }
    if ($hack == $i - 1) {
        return true;
    } else {
        return false;
    }
}

if (isset($_POST['4_num'])) {
    if (!is_numeric($_POST['4_num']) || $_POST['4_num'] <= 0) {
        echo 'Bad number';
    }
    if (isPrime($_POST['4_num'])) {
        echo 'Prime number';
    } else {
        echo 'Not prime number';
    }
}
?>
</body>

</html>