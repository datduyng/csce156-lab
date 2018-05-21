<?php

if($argc != 2) {
  print "ERROR: expecting an integer command line argument\n";
  exit(1);
} else if(!is_numeric($argv[1])) {
  print "ERROR: command line argument should be an integer\n";
  exit(1);
}

$n = intval($argv[1]);

$oneToTen = array(
  1 => "one",
  2 => "two",
  3 => "three",
  4 => "four",
  5 => "five",
  6 => "six",
  7 => "seven",
  8 => "eight",
  9 => "nine",
  10 => "ten"
);

//TODO: write a for-loop to add up 1 .. n and display the answer

//TODO: write a while-loop to add up 1 .. n and display the answer

//TODO: write a foreach loop to iterate over the $oneToTen array and
//      print a message as specified in the writeup

?>