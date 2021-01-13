(ns four-clojure.prob014)

;; #14 Intro to Functions

;; Difficulty:	Elementary
;; Topics:


;; Clojure has many different ways to create functions.
;; test not run	

(def ans 8)

(= true
   (= ans ((fn add-five [x] (+ x 5)) 3))

   (= ans ((fn [x] (+ x 5)) 3))

   (= ans (#(+ % 5) 3))

   (= ans ((partial + 5) 3)))
