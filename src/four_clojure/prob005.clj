(ns four-clojure.prob005)

;; #5 Lists: conj

;; Difficulty:	Elementary
;; Topics:

;; When operating on a list, the conj function will return a new list with one or more
;; items "added" to the front.

;; Note that there are two test cases, but you are expected to supply only one answer,
;; which will cause all the tests to pass.

(def ans '(1 2 3 4))

(= true
   (= ans (conj '(2 3 4) 1))

   (= ans (conj '(3 4) 2 1)))
