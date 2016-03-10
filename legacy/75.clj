(defn divisors [n]
  (set (filter #(= 0 (mod n %)) (range 1 (inc n)))))

(defn coprime?
  "coprime if the only positive integer that evenly divides both of them is 1"
  [a b]
  (= #{1}
     (clojure.set/intersection (divisors a) (divisors b))))

(defn positive-integers-coprime [x]
  (filter #(coprime? x %) (range 1 x)))

(defn totient
  "Two numbers are coprime if their greatest common divisor equals 1.
  Euler's totient function f(x) is defined as the number of positive integers less than x which are coprime to x.
  The special case f(1) equals 1. Write a function which calculates Euler's totient function."
  [x]
  (if (= x 1)
    1
    (count (positive-integers-coprime x))))

;; TODO: Move to GCD-based
(defn condensed [x]
  (if (= x 1)
    1
    (letfn [(divisors [n]
              (set (filter #(= 0 (mod n %)) (range 1 (inc n)))))]
    (count (filter #(= #{1}
                       (clojure.set/intersection (divisors a) (divisors b)) (range 1 x)))))))

  

(= (totient 1) 1)
(= (totient 10) (count '(1 3 7 9)) 4)
(= (totient 40) 16)
(= (totient 99) 60)
