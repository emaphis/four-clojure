(ns four-clojure.prob018)

;; #18 Sequences: filter

;; Difficulty:	Elementary
;; Topics:

;; The filter function takes two arguments: a predicate function (f) and a sequence (s).
;; Filter returns a new sequence consisting of all the items of s for which (f item)
;; returns true.

(def ans '(6 7))

(= ans (filter #(> % 5) '(3 4 5 6 7)))
