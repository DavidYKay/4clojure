(ns fourclojure.prob115)

(defn balanced? [n]
  (let [nums (map int (str n))
        size (quot (count (str n)) 2)]
    (apply = (map #(reduce + %)
            [(take size nums)
             (take-last size nums)]))))
