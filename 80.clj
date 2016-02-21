(ns user)

(defn divisors [n]
  (remove #(= n %)
          (set (filter #(= 0 (mod n %)) (range 1 (inc n))))))

(defn perfect?
  "a number is 'perfect' if the sum of its divisors equal the number itself."
  [n]
  (= (apply + (divisors n))
     n))

(= (perfect? 6) true)
(= (perfect? 7) false)
(= (perfect? 496) true)
(= (perfect? 500) false)
(= (perfect? 8128) true)

