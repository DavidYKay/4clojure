(defn my-filter [s]
  (letfn [(abs [n] (max n (- n)))
          (close-enough [a b]
            (< (abs (- a b))
               0.0000000000000001))
          (better-guess [x g]
            (/ (+ g (/ x g))
               2))
          (test [x g] 
            (if (close-enough (/ x g) g)
              g
              (test x (better-guess x g))))
          (sqrt [x]
            (test x 1))
          (square [x]
            (* x x))]
  (->> (clojure.string/split s #",")
       (map #(Integer/parseInt %))
       (filter #(close-enough
                 (sqrt %)
                 (int (sqrt %))))
      (clojure.string/join ","))))

(=
 (my-filter "15,16,25,36,37")
 "16,25,36")

