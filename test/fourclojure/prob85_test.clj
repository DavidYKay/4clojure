(ns fourclojure.prob85-test
  (:require [midje.sweet :refer :all]
            [fourclojure.prob85 :refer :all]))


(fact "example a" 
      (power-set #{1 :a}) => #{#{1 :a} #{:a} #{} #{1}})

(fact "example b" 
      (power-set #{}) => #{#{}})

(fact "example c" 
      (power-set #{1 2 3}) => #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})

(fact "example d" (count 
                   (power-set (into #{} (range 10)))) => 1024)
