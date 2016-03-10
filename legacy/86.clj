(defn exp [x n]
  (reduce * (repeat n x)))

(def max-reps (exp 10 3))
               
(defn happy? [n]
  (loop [n n
         reps 0]
    (let [digits (map #(Integer/parseInt (str %)) (str n))
          new (reduce +
                      (for [d digits]
                        (* d d)))]
      (if (= 1 new)
        true
        (if (> reps max-reps)
          false
          (recur new (inc reps)))))))

(= (happy? 7) true)
(= (happy? 986543210) true)
(= (happy? 2) false)
(= (happy? 3) false)
