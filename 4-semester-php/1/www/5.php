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
    <p>Napis 1: <input type="text" name="5_napis1" /></p>
    <p>Napis 2: <input type="text" name="5_napis2" /></p>
    <p><input type="submit" /></p>
  </form>
  <?php 
    if(isset($_POST['5_napis1'])){
      echo '%'.$_POST['5_napis2'].' '.$_POST['5_napis1'].'%$#'; 
    }
  ?>
</body>
</html>
