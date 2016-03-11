(ns fourclojure.prob69-test
  (:require [midje.sweet :refer :all]
            [fourclojure.prob69 :refer :all]))

(fact "can merge a"
      (my-merge * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5}) => {:a 4, :b 6, :c 20})

(fact "can merge a"
      (my-merge - {1 10, 2 20} {1 3, 2 10, 3 15}) => {1 7, 2 10, 3 15})

(fact "can merge a"
      (my-merge concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]}) =>
      {:a [3 4 5], :b [6 7], :c [8 9]})
