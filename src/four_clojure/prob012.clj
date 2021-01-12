(ns four-clojure.prob012)

;; #12 Intro to Sequences

;; Difficulty:	Elementary
;; Topics:

;; All Clojure collections support sequencing. You can operate on sequences with
;; functions like first, second, and last.

(def ans 3)

(= ans (first '(3 2 1)))

(= ans (second [2 3 4]))

(= ans (last (list 1 2 3)))
