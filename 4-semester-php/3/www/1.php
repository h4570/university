<?php include 'uri.php';include '1_funcs.php'?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <form action="<?php echo $URI; ?>" method="post">
        <p>A: <input type="number" name="1_a" /></p>
        <p>B: <input type="number" name="1_b" /></p>
        <p>
            <input type="submit" name="1_action" value="Add" />
            <input type="submit" name="1_action" value="Sub" />
            <input type="submit" name="1_action" value="Mul" />
            <input type="submit" name="1_action" value="Div" />
        </p>
    </form>
    <?php
if (isset($_POST['1_action'])) {
    echo 'Result: ';
    if ($_POST['1_action'] == "Add") {
        echo add_1($_POST['1_a'], $_POST['1_b']);
    }

    if ($_POST['1_action'] == "Sub") {
        echo sub_1($_POST['1_a'], $_POST['1_b']);
    }

    if ($_POST['1_action'] == "Mul") {
        echo mul_1($_POST['1_a'], $_POST['1_b']);
    }

    if ($_POST['1_action'] == "Div") {
        echo div_1($_POST['1_a'], $_POST['1_b']);
    }

    echo '<br/>';
}
?>
</body>

</html>