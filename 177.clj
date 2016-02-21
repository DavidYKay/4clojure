(defn balance-brackets [s]
  (let [open #{\(\[\{}
        close {\) \(
               \] \[
               \} \{}]
    (loop [current (first s)
           remaining (rest s)
           stack []]
      (if (nil? stack)
        false
        (if (nil? current)
          (if (empty? stack)
            true
            false)
          (recur (first remaining)
                 (rest remaining)
                 (cond
                   (contains? open current) (conj stack current)
                   (contains? close current) (if (= (get close current) (last stack))
                                               (pop stack)
                                               nil)
                   :else stack)))))))
  

(balance-brackets "This string has no brackets.")


(not (balance-brackets "(start, end]"))

(balance-brackets "()")

(not (balance-brackets "())"))

(not (balance-brackets "[ { ] } "))

(balance-brackets "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))")

(not (balance-brackets "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))"))

(not (balance-brackets "["))

(balance-brackets "class Test {
       public static void main(String[] args) {
         System.out.println(\"Hello world.\");
       }
     }")
