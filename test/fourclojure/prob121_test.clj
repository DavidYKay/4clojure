(ns fourclojure.prob121-test
  (:require [midje.sweet :refer :all]
            [fourclojure.prob121 :refer :all]))


(fact "example a"
      ((solve '(/ a b))
       '{b 8 a 16}) => 2 )

(fact "example b"
      ((solve '(+ a b 2)) 
       '{a 2 b 4}) => 8)

(fact "example c" 
      (map (solve '(* (+ 2 a) 
                      (- 10 b))) 
           '[{a 1 b 8} 
             {b 5 a -2} 
             {a 2 b 11}]) => [6 0 -4] )

(fact "example d"
      ((solve '(/ (+ x 2) 
                  (* 3 (+ y 1)))) 
       '{x 4 y 1}) => 1)


