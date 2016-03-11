(ns fourclojure.prob69)

(defn my-merge [f & maps]
  (->> (for [k (set (flatten (map keys maps)))
             m maps]
         [k (get m k)])
       (remove #(nil? (last %)))
       (group-by first)
       (map (fn [[k vs]]
              [k (reduce f (map last vs))]))
       (into {})))
