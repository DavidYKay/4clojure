(ns fourclojure.prob93)

(defn flatten-item [s]
  (if (not (coll? s))
    s
    (if (not (coll? (first s)))
      s
      (flatten-item (or (first s)
                        (last s))))))

(defn partial-flatten [s]
  (map flatten-item s))
