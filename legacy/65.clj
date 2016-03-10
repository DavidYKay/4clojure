
(defn black-box [x]
  (letfn [(conj-two [v]
            (-> v
                (conj 1)
                (conj 2)))]
    
    (cond
      (try
        (cons [1 2] x)
        :map
      (= x (set x)) :set
      (= (last (conj-two x)) 2) :vector
      (= (first (conj-two x)) 2)  :list
      :default :unknown)))

(= :map (black-box {:a 1, :b 2}))
(= :list (black-box (range (rand-int 20))))
(= :vector (black-box [1 2 3 4 5 6]))
(= :set (black-box #{10 (rand-int 5)}))

(= :map (black-box {}))
(= :list (black-box '()))
(= :vector (black-box []))
(= :set (black-box #{}))

;(= [:map :set :vector :list] (map black-box [{} #{} [] ()]))
