(ns four-clojure.prob032)

;; #32 Duplicate a SequenceSolutions
;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which duplicates each element of a sequence.

(def ans
  (fn [coll]
    (interleave coll coll)))

(= true
   (= (ans [1 2 3]) '(1 1 2 2 3 3))
   (= (ans [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
   (= (ans [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
   (= (ans [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
