(ns four-clojure.prob034)

;; #34 Implement range

;; Difficulty:	Easy
;; Topics:	seqs core-functions

;; Write a function which creates a list of all integers in a given range.

(def ans0
  (fn [beg end]
    (reverse
     (loop [count beg acc '()]
       (if (= count end)
         acc
         (recur (inc count) (conj acc count))))))
  )

(def ans
  (fn [beg end]
    (take (- end beg) (iterate inc beg)))
  )
;;(ans -2 2)

(= true
   (= (ans 1 4) '(1 2 3))
   (= (ans -2 2) '(-2 -1 0 1))
   (= (ans 5 8) '(5 6 7)))
