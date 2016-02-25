(def cache (atom {}))

(defn primes-raw
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

(defn primes [n]
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

(defn prime-before [x]
  (first (last (filter #(= true (last %)) (primes x)))))

(defn prime-after [x]
  (ffirst (filter (fn [[i b]]
                   (and (> i x)
                       (= true b))) (primes (* 2 x)))))

(defn prime? [x]
  (last (first (filter #(= x (first %))
                       (primes (inc x))))))

(defn balanced?
  "A balanced prime is a prime number which is also the mean of the primes directly before and after it in the sequence of valid primes. Create a function which takes an integer n, and returns true iff it is a balanced prime."
  [x]
  (and (prime? x)
       (= x (mean (prime-before x)
                  (prime-after x)))))

(= false (balanced? 4))
(= true (balanced? 563))
(= true (balanced? 1103))
(= 1103 (nth (filter balanced? (range)) 15))
