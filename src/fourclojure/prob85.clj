(ns fourclojure.prob85)

;; (defn power-set [s]
;;   (def results (atom #{}))
;;   (letfn [(backtrack [current remaining]
;;             (when (not (contains? @results current))
;;               (swap! results conj current)
;;               (doseq [x remaining]
;;                 (backtrack (conj current x) (disj remaining x)))))]
;;     (reset! results #{})
;;     (backtrack #{} s)
;;     @results))

;; (defn power-set [s]
;;   (let [results (atom #{})
;;         backtrack (fn backtrack [current remaining]
;;                     (when (not (contains? @results current))
;;                       (swap! results conj current)
;;                       (doseq [x remaining]
;;                         (backtrack (conj current x) (disj remaining x)))))]
;;     (backtrack #{} s)
;;     @results))

(defn power-set [s]
  (reduce
   (fn [a x]
     (into a (map #(conj % x) a)))
   #{#{}} s))


;;(defn power-set [s]
;;  (letfn [(backtrack [results current remaining]
;;            (if (contains? results current)
;;              results
;;              (for [x remaining]
;;                (backtrack (conj results current) (conj current x) (disj remaining x)))))]
;;    (backtrack #{} #{} s)))
