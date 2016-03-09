(def cache (atom {}))

(defn primes
  [n]
  (let [a (into-array Boolean/TYPE (for [i (range n)]
                                     (if (< i 2) false true)))]
    (doseq [i (range (Math/sqrt n))]
      (when (aget a i)
        (doseq [j (range (* i i) n i)]
          (aset a j false))))
    (map-indexed (fn [idx b]
                   [idx b])
                 (vec a))))

(defn mean [& args]
    (/ (apply + (remove nil? args)) (count args)))

(defn prime-before [x primes]
  (first (last (filter #(and
                         (< (first %) x)
                         (= true (last %))) primes))))

(defn prime-after [x primes]
  (ffirst (filter (fn [[i b]]
                   (and (> i x)
                       (= true b))) primes)))

(defn prime? [x primes]
  (last (first (filter #(= x (first %))
                       primes))))

(defn balanced?
  "A balanced prime is a prime number which is also the mean of the primes directly before and after it in the sequence of valid primes. Create a function which takes an integer n, and returns true iff it is a balanced prime."
  [x]
  (let [primes (primes (* 2 x))]
    (and (prime? x primes)
         (= x (mean (prime-before x primes)
                    (prime-after x primes))))))

(= false (balanced? 4))
(= true (balanced? 563))
(= true (balanced? 1103))
; (= 1103 (nth (filter balanced? (range)) 15))
