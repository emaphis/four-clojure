(ns four-clojure.prob162)

;; #162 Logical falsity and truth

;; Difficulty:	Elementary
;; Topics:	logic


;; In Clojure, only `nil` and `false` represent the values of logical falsity
;; in conditional tests - anything else is logical truth.

(def ans 1)

(= true
   (= ans (if-not false 1 0))
   (= ans (if-not nil 1 0))
   (= ans (if true 1 0))
   (= ans (if [] 1 0))
   (= ans (if [0] 1 0))
   (= ans (if 0 1 0))
   (= ans (if 1 1 0)))
