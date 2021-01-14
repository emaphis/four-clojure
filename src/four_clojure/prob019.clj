(ns four-clojure.prob019)

;; #19 Last Element

;; Difficulty:	Easy
;; Topics:	seqs core-functions

;; Write a function which returns the last element in a sequence.

(def ans (comp first reverse))

(= true
   (= (ans [1 2 3 4 5]) 5)
   (= (ans '(5 4 3)) 3)
   (= (ans ["b" "c" "d"]) "d"))
