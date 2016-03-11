(ns fourclojure.prob69)

(defn my-merge [f & maps]
  (->> (apply concat maps)
       (group-by key)
       (map (fn [[k kvs]]
              [k (reduce f (map val kvs))]))
       (into {})))
