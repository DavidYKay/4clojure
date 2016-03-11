(ns fourclojure.prob104)

(def numerals {1 \I 
               5 \V 
               10 \X 
               50 \L 
               100 \C 
               500 \D 
               1000 \M})

;; if the diff is < half, then perform subtractive

;; otherwise it's additive

;; (if (> (- n denom)
;;        (/ n 2))
;;   :subtractive
;;   :additive)

(def denominations (reverse (sort (keys numerals))))

(defn biggest-denom [n]
  (loop [current (first denominations)
         denominations (rest denominations)]
    (if (>= n current)
      current
      (recur (first denominations)
             (rest denominations)))))

(defn unparse-recur [n]
 
  )

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

