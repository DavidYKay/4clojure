(ns fourclojure.prob93-test
  (:require [midje.sweet :refer :all]
            [fourclojure.prob93 :refer :all]))

(fact "example a"
      (partial-flatten [["Do"] ["Nothing"]]) => [["Do"] ["Nothing"]])

(fact "example b"
      (partial-flatten [[[[:a :b]]] [[:c :d]] [:e :f]]) => [[:a :b] [:c :d] [:e :f]])

(fact "example c"
      (partial-flatten '((1 2)((3 4)((((5 6))))))) => '((1 2)(3 4)(5 6)))
