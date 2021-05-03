<?php 
    $URI = basename($_SERVER['REQUEST_URI'], '?'.$_SERVER['QUERY_STRING']);
    if(empty($URI))
        $URI = 'index.php'
?>
