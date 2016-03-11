(ns fourclojure.prob144)

(defn rotate [s]
  (concat (rest s) [(first s)]))

(defn oscillate [v & fns]
  (lazy-seq (cons v
                  (apply (partial oscillate ((first fns) v))
                         (concat (rest fns) [(first fns)])))))

(def my-seq
  ((fn rseq [v fns]
     (lazy-seq (cons v (rseq ((first fns) v)
                             (rotate fns)))))
     3.14 [int double]))

(def fibonacci
  ((fn rfib [a b]
    (lazy-seq (cons a (rfib b (+ a b)))))
   1 1))
  
