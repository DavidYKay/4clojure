; (defn my-sort [s]
;   (->> s
;        (remove #(contains? #{\! \.} %))
;        (partition-by #(= \space %))
;        (remove #(= '(\space) %))
;        (sort
;         (fn cmp [l r]
;           (let [a (first l)
;                 b (first r)
;                 value (fn [x]
;                         (int (Character/toLowerCase x)))]
;             (cond
;               (< (value a) (value b)) -1
;               (> (value a) (value b)) 1
;               :else (cmp (rest l)
;                          (rest r))))))
;        (map #(if (= (count %) 1)
;                (str (first %))
;                (reduce str %)))))

(defn my-sort [s]
  (->> (clojure.string/split s #"[^A-Za-z]")
       (sort-by clojure.string/lower-case)))
       
; (comp (partial sort-by clojure.string/lower-case)
;       #(clojure.string/split % #"[^A-Za-z]"))

(=
 (my-sort  "Have a nice day.")
 ["a" "day" "Have" "nice"])

(=
 (my-sort  "Clojure is a fun language!")
 ["a" "Clojure" "fun" "is" "language"])

(=
 (my-sort  "Fools fall for foolish follies.")
 ["fall" "follies" "foolish" "Fools" "for"])
