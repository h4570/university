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
    <p>A: <input type="number" name="4_a" /></p>
    <p>B: <input type="number" name="4_b" /></p>
    <p><input type="submit" /></p>
  </form>
  <?php 
    if(isset($_POST['4_a'])){
        echo 'Add: '.$_POST['4_a']+$_POST['4_b'].'<br/>'; 
        echo 'Subtract: '.$_POST['4_a']-$_POST['4_b'].'<br/>'; 
        echo 'Multiply: '.$_POST['4_a']*$_POST['4_b'].'<br/>'; 
        echo 'Modulo: '.$_POST['4_a']%$_POST['4_b'].'<br/>'; 
    }
  ?>
</body>
</html>
