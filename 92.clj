(def numerals {\I 1
               \V 5
               \X 10
               \C 25
               \L 50
               \D 500
               \M 1000})

(defn subtractive [s]
  ;; I placed before V or X indicates one less, so four is IV (one less than five) and nine is IX (one less than ten)
  ;; X placed before L or C indicates ten less, so forty is XL (ten less than fifty) and ninety is XC (ten less than a hundred)
  ;; C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than five hundred) and nine hundred is CM (a hundred less than a thousand)[5]

  )


(defn parse [s]
  (map #(get numerals %) s))


; (= 14 (parse "XIV"))
; (= 827 (parse "DCCCXXVII"))
; (= 3999 (parse "MMMCMXCIX"))
; (= 48 (parse "XLVIII"))
