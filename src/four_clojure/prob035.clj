(ns four-clojure.prob035)

;; #35 Local bindings

;; Difficulty:	Elementary
;; Topics:	syntax

;; Clojure lets you give local names to values using the special let-form.

(def ans 7)

(= true
   (= ans (let [x 5] (+ 2 x)))

   (= ans (let [x 3, y 10] (- y x)))

   (= ans (let [x 21] (let [y 3] (/ x y)))))
