<?php
    foreach (range(1, 12) as $i) {
        echo '<h3>'.'Zadanie '.$i.'</h3><br/>';
        include $i.'.php';
        echo '<br/><hr/><br/>';
    }
?>