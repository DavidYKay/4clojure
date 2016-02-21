(def numerals {1\I 
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

(defn unparse [n]
  (let [denom (biggest-denom n)
        multiplier (min (/ n denom) 3)
        difference (- n
                      (* multiplier denom))]
    (println "difference: " difference)
    (apply str
           (take multiplier (repeat (get numerals denom))))))
  
(= "I" (unparse 1)) 
(= "XXX" (unparse 30)) 
(= "IV" (unparse 4)) 
;(= "CXL" (unparse 140)) 
;(= "DCCCXXVII" (unparse 827)) 
;(= "MMMCMXCIX" (unparse 3999))
;(= "XLVIII" (unparse 48))
