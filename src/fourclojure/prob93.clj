(ns fourclojure.prob93
  (:require [clojure.walk :as walk]))


(defn valid? [s]
  (println "checking: " s )
  (and (coll? s)
       (not (coll? (first s)))))

(defn grab-valid [s]
  (println "grabbing valid: " s)
  (if false
    s
    s))

;; (def thing {:page/tags [{:tag/category "lslsls"}]})
;; (postwalk #(if (keyword? %)
;;              (keyword (name %))
;;              %) thing)

(defn flatten-item [s]
  (println "flattening: " s)
  (if (not (coll? s))
    s
    (if (or (not (coll? (first s)))
            (not (coll? (last s))))
      s
      (flatten-item (or (first s)
                        (last s))))))

(defn partial-flatten [s]
  ;;(map flatten-item s)
  (loop [current (first s)
         remaining (rest s)
         accum []]
    (if (and (coll? current) (not (coll? (first current))))
      :a
      :b)))

