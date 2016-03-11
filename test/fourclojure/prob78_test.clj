(ns fourclojure.prob78-test
  (:require [midje.sweet :refer :all]
            [fourclojure.prob78 :refer :all]))


(fact "test a"
      (letfn [(triple [x] #(sub-two (* 3 x)))
              (sub-two [x] #(stop? (- x 2)))
              (stop? [x] (if (> x 50) x #(triple x)))]
        (my-trampoline triple 2)) => 82)

(fact "test b"
      (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
              (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
        (map (partial my-trampoline my-even?) (range 6))) => [true false true false true false])

