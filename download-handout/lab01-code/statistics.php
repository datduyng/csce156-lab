<?php

  /* PHP code starts with a <?php and ends with a ?> so that it can
     be interleaved with static HTML content.
   */

/* functions can be declared which will have global scope */

function getMin($array) {
  if($array == null || count($array) == 0) {
    return null;
  }

  $min = $array[0];
  for($i=1; $i<count($array); $i++) {
    if($min > $array[$i]) {
      $min = $array[$i];
    }
  }
  return $min;
}

function getMax($array) {
  //TODO: implement this function
  return null;
}

function getAverage($array) {
  if($array == null) {
    return null;
  }

  $sum = getSum($array);
  return ($sum / count($array));
}

function getSum($array) {
  //TODO: implement this function
  return null;
}

  echo "Please input the number of integers being entered (>=2): ";
  /* variable identifiers begin with the dollar sign 
     as PHP is weakly typed, no type needs to be declared
   */
  $numberOfEntries = intval(trim(fgets(STDIN)));

  if($numberOfEntries < 2) {
    print "Invalid input: number of entries must be at least 2\n";
    exit(1);
  }

  $numbers = array();
  echo "Enter your integers one at at time, followed by the enter key.\n";
  $count = 0;
  while($count < $numberOfEntries) {

    /* standard input can be scanned with fgets 
       elements can be appended using the following syntax  
     */
    $numbers[] = intval(trim(fgets(STDIN)));
    $count++;
  } //end of for loop

  $min = getMin($numbers);
  $max = getMax($numbers);
  $average = getAverage($numbers);
  $sum = getSum($numbers);

  /*
    Output can be done with echo, print, or printf, string concatenation is done
    with the period operator.
   */
  echo "The sum is ".$sum."\n";
  echo "The average is ".$average."\n";
  echo "The highest is ".$max."\n";
  echo "The lowest is ".$min."\n";
?>
