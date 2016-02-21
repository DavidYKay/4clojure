(ns user)

(defn perfect? [n]
  (= (apply + (filter #(= 0 (mod n %))
                      (range 1 n)))
     n))

(= (perfect? 6) true)
(= (perfect? 7) false)
(= (perfect? 496) true)
(= (perfect? 500) false)
(= (perfect? 8128) true)

