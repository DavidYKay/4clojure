(defn my-filter [s]
  (->> (clojure.string/split s #",")
       (map #(Integer/parseInt %))
       (filter #(== (Math/sqrt %)
                    (int (Math/sqrt %))))
       (clojure.string/join ",")))

(=
 (my-filter "15,16,25,36,37")
 "16,25,36")

