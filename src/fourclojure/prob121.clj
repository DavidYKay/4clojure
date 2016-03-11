(ns fourclojure.prob121)

(defn find-fn [s]
  (->> s
       (ns-resolve *ns*)))

(defn walk-fn [f m]

  )

(defn solve [form]
  (fn [m]
    (let [f (find-fn (first form))
          symbols (rest form)
          args (map (fn [s]
                      (if (symbol? s)
                        (get m s)
                        s))
                    symbols)]
      (println (format "f: %s symbols: %s args: %s" f symbols (clojure.string/join " " args)))
      (apply f args)
      )))
