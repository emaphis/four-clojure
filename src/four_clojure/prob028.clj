(ns four-clojure.prob028)

;; #28 Flatten a Sequence

;; Difficulty:	Easy
;; Topics:	seqs core-functions

;; Write a function which flattens a sequence.

(def ans
  (fn flatn [coll]
    (if (empty? coll)
      '()
      (if (coll? (first coll))
        (concat (flatn (first coll)) (flatn (rest coll)))
        (cons (first coll) (flatn (rest coll)))))))


(= true
   (= (ans '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
   (= (ans ["a" ["b"] "c"]) '("a" "b" "c"))
   (= (ans '((((:a))))) '(:a)))
