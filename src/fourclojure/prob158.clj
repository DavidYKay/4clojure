(ns fourclojure.prob158)

(defn decurry [f]
  (fn [& args]
    (reduce #(%1 %2) f args)))
