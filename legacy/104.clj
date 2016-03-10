(def numerals {1 \I 
               5 \V 
               10 \X 
               50 \L 
               100 \C 
               500 \D 
               1000 \M})

(def denominations (reverse (sort (keys numerals))))

(defn biggest-denom [n]
  (loop [current (first denominations)
         denominations (rest denominations)]
    (if (>= n current)
      current
      (recur (first denominations)
             (rest denominations)))))

(defn subtractive? [n]
    false
  )

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

(defn factor [n]
  (let [denom (biggest-denom n)
        multiplier (min (/ n denom) 3)
        next-denom (biggest-denom (+ n denom))]
    ;; if the next denominator minus 
    (if (or (= denom n)
            (= denom next-denom))
      {:plus [[denom multiplier]]}
      (let [difference (- n (* multiplier denom))]
        {:plus [[next-denom 1]]
         :minus [[(- next-denom n) 1]]})
      )))

(defn unparse [n]
  (let [next-denom (biggest-denom (inc n))
        current-denom (biggest-denom n)]
    (if (> next-denom current-denom)
      ;; return IV / IX / etc
      {:value next-denom
       :minus (- next-denom n)}
      (let [denom (biggest-denom n)
            multiplier (min (/ n denom) 3)
            difference (- n
                          (* multiplier denom))]
        ;; (println (format "denom: %s multiplier: %s difference: %s" denom multiplier difference))
        (apply str
               (take multiplier (repeat (get numerals denom))))))))

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
