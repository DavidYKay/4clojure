(ns fourclojure.prob158-test
  (:require [midje.sweet :refer :all]
            [fourclojure.prob158 :refer :all]))


(fact "example a" 
      ((decurry (fn [a] 
                  (fn [b] 
                    (fn [c] 
                      (fn [d] 
                        (+ a b c d)))))) 
       1 2 3 4) => 10)

(fact "example b"
      ((decurry (fn [a] 
                  (fn [b] 
                    (fn [c] 
                      (fn [d] 
                        (* a b c d)))))) 
       1 2 3 4) => 24)

(fact "example c" ((decurry (fn [a] 
                              (fn [b] 
                                (* a b)))) 
                   5 5) => 25)

 
