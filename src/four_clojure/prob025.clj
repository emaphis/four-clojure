(ns four-clojure.prob025)

;; #25 Find the odd numbers

;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which returns only the odd numbers from a sequence.

(def ans
  (fn [coll]
    (filter odd? coll)))

(= true
   (= (ans #{1 2 3 4 5}) '(1 3 5))
   (= (ans [4 2 1 6]) '(1))
   (= (ans [2 2 4 6]) '())
   (= (ans [1 1 1 3]) '(1 1 1 3)))
