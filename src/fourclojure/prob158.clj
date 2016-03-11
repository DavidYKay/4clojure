(ns fourclojure.prob158)

(defn decurry [f]
  (fn [& args]
    (loop [args args
           f f]
      (if (empty? args)
        f
        (recur (rest args)
               (f (first args)))))))
