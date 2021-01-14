(ns four-clojure.prob020)

;; #20 Penultimate Element

;; Difficulty:	Easy
;; Topics:	seqs

;; Write a function which returns the second to last element from a sequence.

(def ans1 (comp second reverse))

(def ans #(nth % (- (count %) 2)))

(= true
   (= (ans (list 1 2 3 4 5)) 4)
   (= (ans ["a" "b" "c"]) "b")
   (= (ans [[1 2] [3 4]]) [1 2]))
