(ns four-clojure.prob010)

;; #10 Intro to Maps

;; Difficulty:	Elementary
;; Topics:

;; Maps store key-value pairs. Both maps and keywords can be used as lookup functions.
;; Commas can be used to make maps more readable, but they are not required.

(def ans 20)

(= ans ((hash-map :a 10, :b 20, :c 30) :b))

(= ans (:b {:a 10, :b 20, :c 30}))
