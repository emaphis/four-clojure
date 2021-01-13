(ns four-clojure.prob016)

;; #16 Hello World

;; Difficulty:	Elementary
;; Topics:

;; Write a function which returns a personalized greeting.

(def ans (fn [s] (str "Hello, " s "!")))

(= true
   (= (ans "Dave") "Hello, Dave!")

   (= (ans "Jenn") "Hello, Jenn!")

   (= (ans "Rhea") "Hello, Rhea!"))
