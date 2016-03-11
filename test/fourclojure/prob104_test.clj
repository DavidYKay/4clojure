(ns fourclojure.prob104-test
  (:require [midje.sweet :refer :all]
            [fourclojure.prob104 :refer :all]))

;;(fact "find prev denom"
;;      (prev-denom 1) => 1
;;      (prev-denom 4) => 1
;;      (prev-denom 5) => 1
;;      (prev-denom 9) => 5
;;      (prev-denom 10) => 5
;;      (prev-denom 11) => 5
;;      (prev-denom 50) => 10
;;      )
;;
;;(fact "find honest denom"
;;      (honest-denom 1) => 1
;;      (honest-denom 2) => 1
;;      (honest-denom 3) => 1
;;      (honest-denom 4) => 1
;;      (honest-denom 5) => 5
;;      (honest-denom 6) => 5
;;      (honest-denom 7) => 5
;;      (honest-denom 8) => 5
;;      (honest-denom 9) => 5
;;      (honest-denom 10) => 10)
;;
;;
;;(fact "find biggest denom"
;;      (biggest-denom 1) => 1
;;      (biggest-denom 2) => 1
;;      (biggest-denom 3) => 1
;;      (biggest-denom 4) => 5
;;      (biggest-denom 5) => 5
;;      (biggest-denom 6) => 5
;;      (biggest-denom 7) => 5
;;      (biggest-denom 8) => 5
;;      (biggest-denom 9) => 10
;;      (biggest-denom 10) => 10
;;      )
;;

;; (= false (subtractive? 1)) 
;; (= false (subtractive? 2)) 
;; (= false (subtractive? 3)) 
;; (= true (subtractive? 4)) 
;; (= false (subtractive? 5)) 
;; (= false (subtractive? 6)) 
;; (= false (subtractive? 7)) 
;; (= false (subtractive? 8)) 
;; (= true (subtractive? 9)) 
;; (= false (subtractive? 10)) 
;; (= true (subtractive? 40)) 
;; (= true (subtractive? 45)) 
;; (= true (subtractive? 49))
;; (= true (subtractive? 89)) 
;; (= true (subtractive? 90)) 
;; (= true (subtractive? 99)) 


;(= (factor 1) {:plus [[1 1]]})
;(= (factor 2) {:plus [[1 2]]})
;(= (factor 3) {:plus [[1 3]]})
;; (= (factor 4) {:plus [[5 1]] :minus [[1 1]]})
;; (= (factor 5) {:plus [[5 1]]})
;; (= (factor 6) {:plus [[5 1] [1 1]]})
;; (= (factor 7) {:plus [[5 1] [1 2]]})
;; (= (factor 8) {:plus [[5 1] [1 3]]})
;; (= (factor 9) {:plus [[10 1]] :minus [1 1]})
;; (= (factor 10) {:plus [[10 1]]})
;; (= (factor 11) {:plus [[10 1] [1 1]]})
;; (= (factor 12) {:plus [[10 1] [1 2]]})
;; (= (factor 13) {:plus [[10 1] [1 3]]})
;; (= (factor 14) {:plus [[10 1] [5 1]] :minus [[1 1]]})
;; (= (factor 15) {:plus [[10 1] [5 1]]})

;(= "I" (unparse 1)) 
;(= "XXX" (unparse 30)) 
;(= "IV" (unparse 4)) 
;(= "CXL" (unparse 140)) 
;(= "DCCCXXVII" (unparse 827)) 
;(= "MMMCMXCIX" (unparse 3999))
;(= "XLVIII" (unparse 48))
