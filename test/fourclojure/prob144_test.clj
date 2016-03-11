(ns fourclojure.prob144-test
  (:require [midje.sweet :refer :all]
            [fourclojure.prob144 :refer :all]))


(fact "example a"
      (take 3 (oscillate 3.14 int double)) => [3.14 3 3.0])

(fact "example b"
      (take 5 (oscillate 3 #(- % 3) #(+ 5 %))) => [3 0 5 2 7])

(fact "example c"
      (take 12 (oscillate 0 inc dec inc dec inc)) => [0 1 0 1 0 1 2 1 2 1 2 3])

 

