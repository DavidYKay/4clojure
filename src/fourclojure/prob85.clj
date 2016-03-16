(ns fourclojure.prob85)


(defn power-set [s]
  (def results (atom #{}))
  (letfn [(backtrack [current remaining]
            (when (not (contains? @results current))
              (swap! results conj current)
              (doseq [x remaining]
                (backtrack (conj current x) (disj remaining x)))))]
    (reset! results #{})
    (backtrack #{} s)
    @results))

  ;;(for [x s]
  ;;  (rpower-set #{x} (disj s x))))

  ;; backtrack(int a[], int k, data input) {
  ;;  int c[MAXCANDIDATES]; (* candidates for next position *)
  ;;  int ncandidates; (* next position candidate count *)
  ;;  int i; (* counter *)
  ;;  if (is a solution(a,k,input))
  ;;  process solution(a,k,input);
  ;;  else {
  ;;        k = k+1;
  ;;        construct candidates(a,k,input,c,&ncandidates);
  ;;        for (i=0; i<ncandidates; i++) {
  ;;             a[k] = c[i];
  ;;             backtrack(a,k,input);
  ;;             if (finished) return; (* terminate early *)
  ;;             }
  ;;        }
  ;;  }
