(ns four-clojure.prob026)

;; #26 Fibonacci Sequence

;; Difficulty:	Easy
;; Topics:	Fibonacci seqs

;; Write a function which returns the first X fibonacci numbers.

(def ans
  (fn [n]
    (reverse
     (loop [a 1, b 1, acc '(1)]
       (if (>= (count acc) n)
         acc
         (recur b (+ a b) (conj acc b)))))))

;; found answer
(def ans0
  #(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))))

;;(ans0 8)
;; => (1 1 2 3 5 8 13 21)

(= true
   (= (ans 3) '(1 1 2))
   (= (ans 6) '(1 1 2 3 5 8))
   (= (ans 8) '(1 1 2 3 5 8 13 21)))
