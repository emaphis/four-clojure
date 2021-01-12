(ns four-clojure.prob008)

;; #8 Intro to Sets

;; Difficulty:	Elementary
;; Topics:

;; Sets are collections of unique values.

(def ans #{:a :b :c :d})

(= ans (set '(:a :a :b :c :c :c :c :d :d)))

(= ans (clojure.set/union #{:a :b :c} #{:b :c :d}))
