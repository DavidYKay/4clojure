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

(defn lazy
  ([f data]
   (lazy-seq (lazy f 
                   (f (first data)
                      (second data))
                   data)))
  ([f initial data]
   (letfn [(inner [data accum]
             (lazy-seq
                 (if (empty? data)
                   accum
                   (cons accum (
(



(defn very-lazy [s]
  (lazy-seq
   (if (seq s)
     (cons (first s) (very-lazy (rest s)))
     [])))

(defn positive-numbers 
	([] (positive-numbers 1))
	([n] (lazy-seq (cons n (positive-numbers (inc n))))))


(defn lz-rec-step [s]
  (lazy-seq
   (if (seq s)
     [(first s) (lz-rec-step (rest s))]
     [])))
