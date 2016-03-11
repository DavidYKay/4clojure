(ns fourclojure.prob78)

(defn my-trampoline [f x]
  (loop [result (f x)]
    (if (fn? result)
      (recur (result))
      result)))
