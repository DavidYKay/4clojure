(defn equivalence-long [t v]
  (->> v
       (map (fn [x]
              [x (t x)]))
       (group-by last)
       (map (fn [[k v]]
              (set (map first v))))
       (set)))

(defn equivalence [t v]
  (->> v
       (map #(vector % (t %)))
       (group-by last)
       (map #(set (map first (last %))))
       (set)))

(defn equivalence [t v]
  (set
   (map #(set (map first (last %)))
        (group-by last
                  (map #(vector % (t %)) v)))))
              
(= (equivalence #(* % %) #{-2 -1 0 1 2})
   #{#{0} #{1 -1} #{2 -2}})
 
 (= (equivalence #(rem % 3) #{0 1 2 3 4 5 })
    #{#{0 3} #{1 4} #{2 5}})
 
 (= (equivalence identity #{0 1 2 3 4})
    #{#{0} #{1} #{2} #{3} #{4}})

(= (equivalence (constantly true) #{0 1 2 3 4})
   #{#{0 1 2 3 4}})
