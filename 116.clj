(defn primes
  "
  Input: an integer n > 1
  Let A be an array of Boolean values, indexed by integers 2 to n,
  initially all set to true.
  
  for i = 2, 3, 4, ..., not exceeding √n:
  if A[i] is true:
    for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n :
      A[j] := false
  
  Output: all i such that A[i] is true."
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

(defn mean [a b]
  (/ (+ a b) 2))

(defn prime-before [x]
  (first (last (filter #(= true (last %)) (primes x)))))

(defn prime-after [x]
  (ffirst (filter (fn [[i b]]
                   (and (> i x)
                       (= true b))) (primes (* 2 x)))))

(defn balanced?
  "A balanced prime is a prime number which is also the mean of the primes directly before and after it in the sequence of valid primes. Create a function which takes an integer n, and returns true iff it is a balanced prime."
  [x]
  (= x (mean (prime-before x)
             (prime-after x))))

(= false (balanced? 4))
 ;(= true (balanced? 563))
 ;(= 1103 (nth (filter balanced? (range)) 15))
