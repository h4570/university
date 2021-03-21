<?php include 'uri.php'; ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
  <form action="<?php echo $URI; ?>" method="post">
    <p>A: <input type="number" name="2_a" /></p>
    <p>B: <input type="number" name="2_b" /></p>
    <p><input type="submit" /></p>
  </form>
  <?php 
    if(isset($_POST['2_a']))
        echo 'Result is '.$_POST['2_a']*$_POST['2_b']; 
  ?>
</body>
</html>
