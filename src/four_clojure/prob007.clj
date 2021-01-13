(ns four-clojure.prob007)

;; #7 Vectors: conj

;; Difficulty:	Elementary
;; Topics:


;; When operating on a Vector, the conj function will return a new vector with one or more
;; items "added" to the end.

(def ans [1 2 3 4])

(= true
   (= ans (conj [1 2 3] 4))

   (= ans (conj [1 2] 3 4)))
