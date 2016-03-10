(ns user)

(defn eager
  ([f data]
   (eager f (f (first data)
             (second data))
        data))
  ([f initial data]
   (loop [data data
          accum [initial]]
     (if (empty? data)
       accum
       (recur (rest data)
              (conj accum 
                    (f (last accum)
                       (first data))))))))

(defn very-lazy [s]
  (lazy-seq
   (if (seq s)
     (cons (first s) (very-lazy (rest s)))
     [])))

(defn lz-rec-step [s]
  (lazy-seq
   (if (seq s)
     [(first s) (lz-rec-step (rest s))]
     [])))

(defn positive-numbers 
  ([] (positive-numbers 1))
  ([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(defn fibonacci 
  ([] (lazy-seq (cons 1 (fibonacci 0 1))))
  ([a b]
   (let [sum (+ a b)]
     (lazy-seq (cons sum (fibonacci b sum))))))

(defn solution
  ([f data]
   (lazy-seq (solution f (f (first data)
                            (second data))
                       (drop 2 data))))
  ([f initial data]
   (lazy-seq
    (solution f initial data [])))
  
  ([f current data accum]
   (if (nil? current)
     (lazy-seq accum)
     (let [
           ;;_ (println "last accum: " (last accum))
           ;;_ (println "current: " current)
           newval (apply f (remove nil? [(last accum) current]))
           ]
       ;;(println "recursing with current: " current ", newval: " newval " and data: " data " accum: " accum )
       (lazy-seq
        (solution f
                  (first data)
                  (vec (rest data))
                  (conj accum newval)
                  ))))))

(def my-reduce solution)

;(= (take 5 (my-reduce + (range))) [0 1 3 6 10])
;(= (my-reduce conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
;(= (last (my-reduce * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
;(= (last (my-reduce * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
