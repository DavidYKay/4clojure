(ns fourclojure.prob89)

(defn traverse [[from to :as edge] g visited]
  (if (= (set g) visited)
    true
    (let [potential-edges (->> (filter #(not (contains? visited %)) g)
                               (filter #(= (first %) to)))]
      (if (empty? potential-edges)
        false
        (for [e potential-edges]
          (traverse e g (conj e visited)))))))

(defn tour? [g]
  (boolean
  (get 
   (set (flatten (let [all-keys (into #{} (flatten g))]
                   (for [e g]
                     (traverse e g #{e})))))
   true)))
