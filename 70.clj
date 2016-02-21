(defn my-sort [s]
  (->> s
       (remove #(contains? #{\! \.} %))
       (partition-by #(= \space %))
       (remove #(= '(\space) %))
       (sort
        #(< (int (Character/toLowerCase (first %1)))
            (int (Character/toLowerCase (first %2)))))
       (map #(if (= (count %) 1)
               (str (first %))
               (reduce str %)))))

(=
 (my-sort  "Have a nice day.")
 ["a" "day" "Have" "nice"])

(=
 (my-sort  "Clojure is a fun language!")
 ["a" "Clojure" "fun" "is" "language"])

(=
 (my-sort  "Fools fall for foolish follies.")
 ["fall" "follies" "foolish" "Fools" "for"])
