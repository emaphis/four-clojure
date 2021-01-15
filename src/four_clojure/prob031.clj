(ns four-clojure.prob031)

;; #31 Pack a SequenceSolutions
;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which packs consecutive duplicates into sub-lists.

(def ans
  (fn [coll]
    (partition-by identity coll)))

(= true
   (= (ans [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
   (= (ans [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
   (= (ans [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))
